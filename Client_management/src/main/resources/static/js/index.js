!function(t){function o(i){if(n[i])return n[i].exports;var e=n[i]={exports:{},id:i,loaded:!1};return t[i].call(e.exports,e,e.exports,o),e.loaded=!0,e.exports}var n={};return o.m=t,o.c=n,o.p="",o(0)}([function(t,o,n){"use strict";function i(t){this.options=s.extend({},this.defaultOptions,t),this._confirmList=[],this.confirmed=!1,this.init()}var e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol?"symbol":typeof t},r=n(1).security,s=n(2),c="riskTelephoneAccount";i.prototype={_type:"riskTelephoneAccount",defaultOptions:{confirmBtnId:"tel_confirm_btn",errorCntId:"tel_error_cnt",waitCntId:"tel_wait_cnt",pollInterval:3e3},init:function(t){var o=this.options;return o.timeout?void this.onTimeout():void this.startPoll()},startPoll:function(){function t(){setTimeout(function(){s.request(r,{securityId:f,t:(new Date).getTime().toString(32)},{format:"jsonp",success:o})},c)}function o(t){"object"===("undefined"==typeof t?"undefined":e(t))&&"success"===t.checkStatus?n(t.telephoneAccountValidatorStatus):u.onError("\u51fa\u9519\u5566")}function n(o){switch(o){case"notTested":t();break;case"failed":case"successed":u.confirm();break;case"timeOut":u.onError("\u8d85\u65f6\u4e86");break;default:u.onError("\u51fa\u9519\u5566")}}var i=this.options,r=i.ajaxUrl,c=i.pollInterval,f=i.sid,u=this;t()},onError:function(t){this.confirmed=!0;var o=this.options;s.node("#"+o.waitCntId).hide(),s.node("#"+o.errorCntId).show().find(".header").text(t);var n=this;s.node("#"+o.confirmBtnId).click(function(){n.confirm()})},onConfirm:function(t){if("function"!=typeof t)throw new Error("onConfirm only accept function parm");this.confirmed?t.call(this):this._confirmList.push(t)},confirm:function(){this.confirmed=!0;for(var t=this._confirmList;t.length;)t.shift().call(this)}},r[c]=i,t.exports=i},function(t,o){t.exports=alipay},function(t,o){t.exports=light}]);