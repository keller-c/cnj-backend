webpackJsonp(["main"],{

/***/ "../../../../../src/$$_gendir lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_gendir lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\r\n<div><h1>{{ad}}</h1></div>\r\n  <div><img width=\"300\" src=\"assets/header.png\">\r\n  </div>\r\n  <!-- Liste der Veranstaltungen -->\r\n  <div class=\"col-md-10\">\r\n    <div class=\"panel panel-default\">\r\n      <div class=\"panel-heading\">\r\n        <h3>Veranstaltungen</h3>\r\n      </div>\r\n      <div class=\"panel-body\">\r\n        <button (click)=\"toggleList()\">\r\n          <span *ngIf=\"!allEvents\">Vergangene Events auch anzeigen</span>\r\n          <span *ngIf=\"allEvents\">Vergangene Events ausblenden</span>\r\n        </button>\r\n        <table class=\"table table-bordered\" *ngIf=\"events!=null\">\r\n          <tr class=\"active\">\r\n            <th>Titel</th>\r\n            <th>Beschreibung</th>\r\n            <th>Beginn</th>\r\n            <th></th>\r\n          </tr>\r\n          <tr *ngFor=\"let event of events\">\r\n            <td>{{event.titel}}</td>\r\n            <td>{{event.beschreibung}}</td>\r\n            <td>{{event.beginn | date:'yyyy-MM-dd'}}</td>\r\n            <td><button (click)=\"load(event.id)\">Ändern</button><button (click)=\"delete(event.id)\">Löschen</button></td>\r\n          </tr>\r\n        </table>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n<div class=\"container\">\r\n  <div class=\"col-md-10\">\r\n    <div class=\"panel panel-default\">\r\n      <div class=\"panel-heading\">\r\n        <h3>Veranstaltung\r\n          <span *ngIf=\"event.id==null\">anlegen</span>\r\n          <span *ngIf=\"event.id!=null\">ändern</span>\r\n        </h3>\r\n      </div>\r\n\r\n      <div class=\"panel-body\">\r\n        <form>\r\n          <label for=\"titel\">Titel:</label>\r\n          <input name=\"titel\" type=\"text\" placeholder=\"Titel\" [(ngModel)]=\"event.titel\" class=\"form-control\" />\r\n          <label for=\"beschreibung\">Beschreibung:</label>\r\n          <input name=\"beschreibung\" type=\"text\" placeholder=\"Beschreibung\" [(ngModel)]=\"event.beschreibung\" ng-required=\"true\" class=\"form-control\"\r\n          />\r\n          <label for=\"beginn\">Datum:</label>\r\n          <input [ngModel]=\"event.beginn | date:'yyyy-MM-dd'\" (ngModelChange)=\"event.beginn = $event\" type=\"date\" name=\"beginn\" class=\"form-control\"\r\n          />\r\n        </form>\r\n        <button (click)=\"createEvent()\" class=\"btn btn-primary\" *ngIf=\"event.id==null\">Sichern</button>\r\n        <button (click)=\"updateEvent()\" class=\"btn btn-primary\" *ngIf=\"event.id!=null\">Sichern</button>\r\n        <button (click)=\"reset()\" class=\"btn btn-primary\">Zurücksetzen</button>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"container\">\r\n  <div class=\"col-md-10\">\r\n    <div class=\"panel panel-default\">\r\n      <div class=\"panel-heading\">\r\n        <h3>Servernachricht</h3>\r\n      </div>\r\n      <div class=\"panel-body\">\r\n        <span *ngIf=\"info!=null && !error\">{{info.message}}</span>\r\n        <span *ngIf=\"info!=null && error\">konnte Backend nicht erreichen!</span>\r\n        <span *ngIf=\"info==null\">Lade...</span>\r\n      </div>\r\n    </div>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__ = __webpack_require__("../../../../rxjs/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__veranstaltung__ = __webpack_require__("../../../../../src/app/veranstaltung.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AppComponent = (function () {
    function AppComponent(http) {
        this.http = http;
        this.info = null;
        this.ad = "Lade Werbung...";
        this.allEvents = false;
        this.error = false;
        this.sub = null;
        this.events = null;
        this.event = new __WEBPACK_IMPORTED_MODULE_4__veranstaltung__["a" /* Veranstaltung */]();
    }
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.checkInfo();
        this.loadEvents();
        this.loadAd();
        this.sub = __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__["Observable"].interval(5000).subscribe(function (x) {
            _this.loadAd();
        });
    };
    AppComponent.prototype.ngOnDestroy = function () {
        this.sub.unsubscribe();
    };
    AppComponent.prototype.checkInfo = function () {
        var _this = this;
        this.http.get('/v1/info').map(function (response) { return response.json(); }).subscribe(function (info) {
            _this.info = info;
            _this.error = false;
        }, function (error) {
            _this.error = true;
        });
    };
    AppComponent.prototype.loadAd = function () {
        var _this = this;
        this.http.get('/v1/adproxy').map(function (response) { return response.text(); }).subscribe(function (ad) {
            _this.ad = ad;
        }, function (error) {
            _this.ad = "(Konnte Werbung nicht laden)";
        });
    };
    AppComponent.prototype.loadEvents = function () {
        var _this = this;
        this.http.get('/v1/veranstaltungen?allEvents=' + this.allEvents).map(function (response) { return response.json(); }).subscribe(function (veranstaltungen) {
            _this.events = veranstaltungen;
        });
    };
    AppComponent.prototype.load = function (id) {
        var _this = this;
        this.http.get('/v1/veranstaltungen/' + id).map(function (response) { return response.json(); }).subscribe(function (veranstaltung) {
            _this.event = veranstaltung;
        });
    };
    AppComponent.prototype.delete = function (id) {
        var _this = this;
        this.http.delete('/v1/veranstaltungen/' + id).subscribe(function (response) {
            _this.loadEvents();
            _this.event = new __WEBPACK_IMPORTED_MODULE_4__veranstaltung__["a" /* Veranstaltung */]();
        });
    };
    AppComponent.prototype.createEvent = function () {
        var _this = this;
        this.http.post('/v1/veranstaltungen', this.event).subscribe(function (veranstaltungen) {
            _this.loadEvents();
            _this.event = new __WEBPACK_IMPORTED_MODULE_4__veranstaltung__["a" /* Veranstaltung */]();
        }, function (error) {
            window.alert(error);
        });
    };
    AppComponent.prototype.updateEvent = function () {
        var _this = this;
        this.http.put('/v1/veranstaltungen/' + this.event.id, this.event).subscribe(function (veranstaltungen) {
            _this.loadEvents();
            _this.event = new __WEBPACK_IMPORTED_MODULE_4__veranstaltung__["a" /* Veranstaltung */]();
        }, function (error) {
            window.alert(error);
        });
    };
    AppComponent.prototype.reset = function () {
        this.event = new __WEBPACK_IMPORTED_MODULE_4__veranstaltung__["a" /* Veranstaltung */]();
    };
    AppComponent.prototype.toggleList = function () {
        this.allEvents = !this.allEvents;
        this.loadEvents();
    };
    return AppComponent;
}());
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
        selector: 'app-root',
        template: __webpack_require__("../../../../../src/app/app.component.html"),
        styles: [__webpack_require__("../../../../../src/app/app.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */]) === "function" && _a || Object])
], AppComponent);

var _a;
//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};





var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["L" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_2__angular_http__["b" /* HttpModule */],
            __WEBPACK_IMPORTED_MODULE_3__angular_forms__["a" /* FormsModule */]
        ],
        providers: [],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/veranstaltung.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Veranstaltung; });
var Veranstaltung = (function () {
    function Veranstaltung() {
    }
    return Veranstaltung;
}());

//# sourceMappingURL=veranstaltung.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_20" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map