var exec = cordova.require('cordova/exec');

var AndroidInfo = function() {
    console.log('AndroidInfo instanced');
};

AndroidInfo.prototype.getInfo = function(onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'AndroidInfo', 'getInfo', []);
};

if (typeof module != 'undefined' && module.exports) {
    module.exports = AndroidInfo;
}