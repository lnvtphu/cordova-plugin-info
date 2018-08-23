module.exports = {
    getInfo: function (successCallback, errorCallback) {
        try {
            var packageSpecificToken;

            packageSpecificToken = Windows.System.Profile.HardwareIdentification.getPackageSpecificToken(null);

            // hardware id, signature, certificate IBuffer objects 
            // that can be accessed through properties.
            var hardwareId = packageSpecificToken.id;
            var deviceId = Windows.Storage.Streams.DataReader.fromBuffer(hardwareId).readGuid();

            // window version
            var deviceFamilyVersion = Windows.System.Profile.AnalyticsInfo.versionInfo.deviceFamilyVersion;
            var deviceFamilyVersionUlong = parseInt(deviceFamilyVersion).toString(16),
                bit00 = parseInt(deviceFamilyVersionUlong.slice(deviceFamilyVersionUlong.length - 4), 16),
                bit16 = parseInt(deviceFamilyVersionUlong.slice(deviceFamilyVersionUlong.length - 8, deviceFamilyVersionUlong.length - 4), 16),
                bit32 = parseInt(deviceFamilyVersionUlong.slice(deviceFamilyVersionUlong.length - 12, deviceFamilyVersionUlong.length - 8), 16),
                bit48 = parseInt(deviceFamilyVersionUlong.slice(0, deviceFamilyVersionUlong.length - 12), 16);
            var version = [bit48, bit32, bit16, bit00].join(".");
            //
            var easClientDeviceInformation = Windows.Security.ExchangeActiveSyncProvisioning.EasClientDeviceInformation();
            var infoDevice = {
                id: easClientDeviceInformation.id,
                productName: easClientDeviceInformation.systemProductName,
                version: version,
                manufacture: easClientDeviceInformation.systemManufacturer
            };
            successCallback(infoDevice);
        } catch (error) {
            errorCallback(error);
        }

    }
}
require("cordova/exec/proxy").add("InfoDevice", module.exports);