module.exports = {
    getInfo: function (successCallback, errorCallback) {
        try {
            var packageSpecificToken;

            packageSpecificToken = Windows.System.Profile.HardwareIdentification.getPackageSpecificToken(null);
    
            // hardware id, signature, certificate IBuffer objects 
            // that can be accessed through properties.
            var hardwareId = packageSpecificToken.id;
            var signature = packageSpecificToken.signature;
            var certificate = packageSpecificToken.certificate;
            
            successCallback(hardwareId)
        } catch (error) {
            errorCallback(error);
        }

    }
}
require("cordova/exec/proxy").add("InfoDevice", module.exports);