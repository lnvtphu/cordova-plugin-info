var exec = cordova.require('cordova/exec');

var AndroidInfo = function() {
    console.log('AndroidInfo instanced');
};

AndroidInfo.prototype.show = function(msg, onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'AndroidInfo', 'show', [msg]);
};

if (typeof module != 'undefined' && module.exports) {
    module.exports = AndroidInfo;
}