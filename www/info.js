module.exports = {
    getInfo: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "info", "getInfo");
    }
};