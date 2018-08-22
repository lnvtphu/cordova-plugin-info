var exec = cordova.require('cordova/exec');

var InfoDevice = function() {
    console.log('InfoDevice instanced');
};

InfoDevice.prototype.getInfo = function(onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'InfoDevice', 'getInfo', []);
};

if (typeof module != 'undefined' && module.exports) {
    module.exports = InfoDevice;
}