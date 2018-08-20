module.exports = {
    greet: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "info", "getInfo");
    }
};