/*!@license
 * Infragistics.Web.ClientUI DataGrid 19.1.20191.172
 *
 * Copyright (c) 2011-2019 Infragistics Inc.
 *
 * http://www.infragistics.com/
 *
 * Depends on:
 * jquery.js
 * jquery-ui.js
 * infragistics.util.js
 * infragistics.util.jquery.js
 * infragistics.ext_core.js
 * infragistics.ext_collections.js
 * infragistics.ext_ui.js
 * infragistics.dv_core.js
 * infragistics.dv_geometry.js
 * infragistics.dv_jquerydom.js
 * infragistics.zoomslider_core.js
 */
(function(factory){if(typeof define==="function"&&define.amd){define(["jquery","jquery-ui","./infragistics.util","./infragistucs.util.jquery","./infragistics.dv_jquerydom","./infragistics.zoomslider_core"],factory)}else{factory(jQuery)}})(function($){$.widget("ui.igZoomSlider",{css:{unsupportedBrowserClass:"ui-html5-non-html5-supported-message ui-helper-clearfix ui-html5-non-html5",zoomSlider:"ui-zoomslider"},events:{propertyChanged:null,resolvingAxisValue:null,windowRectChanged:null},options:{width:null,height:null,panTransitionDuration:500,maxZoomWidth:1,pixelScalingRatio:NaN,actualPixelScalingRatio:1,windowRect:null,minZoomWidth:1e-5,startInset:0,endInset:0,trackStartInset:5,trackEndInset:5,barExtent:16,orientation:"horizontal",lowerThumbBrush:null,lowerThumbStrokeThickness:1,higherThumbStrokeThickness:1,higherThumbBrush:null,lowerThumbOutline:null,higherThumbOutline:null,lowerThumbRidgesBrush:null,higherThumbRidgesBrush:null,lowerThumbWidth:10,higherThumbWidth:10,lowerThumbHeight:22,higherThumbHeight:22,lowerShadeBrush:null,lowerShadeOutline:null,lowerShadeStrokeThickness:1,higherShadeBrush:null,higherShadeOutline:null,higherShadeStrokeThickness:1,barBrush:null,barOutline:null,barStrokeThickness:0,rangeThumbBrush:null,rangeThumbOutline:null,rangeThumbStrokeThickness:1,rangeThumbRidgesBrush:null,lowerCalloutBrush:null,lowerCalloutTextColor:null,lowerCalloutOutline:null,lowerCalloutStrokeThickness:1,higherCalloutBrush:null,higherCalloutTextColor:null,higherCalloutOutline:null,higherCalloutStrokeThickness:1,areThumbCalloutsEnabled:false,thumbCalloutTextStyle:null},_fireZoomSlider_resolvingAxisValue:function(zoomSlider,evt){var opts={};opts.position=evt.position();opts.value=evt.value();opts.owner=this;this._trigger("resolvingAxisValue",null,opts);evt.value(opts.value)},_fireZoomSlider_windowRectChanged:function(zoomSlider,evt){var opts={};opts.oldLeft=evt.oldRect().left();opts.oldTop=evt.oldRect().top();opts.oldWidth=evt.oldRect().width();opts.oldHeight=evt.oldRect().height();opts.newLeft=evt.newRect().left();opts.newTop=evt.newRect().top();opts.newWidth=evt.newRect().width();opts.newHeight=evt.newRect().height();this._trigger("windowRectChanged",null,opts)},_setOption:function(key,value,checkPrev){var zoomSlider=this._zoomSlider,o=this.options;if(checkPrev&&o[key]===value){return}$.Widget.prototype._setOption.apply(this,arguments);if(this._set_option(zoomSlider,key,value)){return this}this._set_generated_option(zoomSlider,key,value);return this},_set_generated_option:function(zoomSlider,key,value){switch(key){case"panTransitionDuration":zoomSlider.panTransitionDuration(value);return true;case"maxZoomWidth":zoomSlider.maxZoomWidth(value);return true;case"pixelScalingRatio":zoomSlider.pixelScalingRatio(value);return true;case"actualPixelScalingRatio":zoomSlider.actualPixelScalingRatio(value);return true;case"windowRect":zoomSlider.windowRect(new $.ig.Rect(0,value.left,value.top,value.width,value.height));return true;case"minZoomWidth":zoomSlider.minZoomWidth(value);return true;case"startInset":zoomSlider.startInset(value);return true;case"endInset":zoomSlider.endInset(value);return true;case"trackStartInset":zoomSlider.trackStartInset(value);return true;case"trackEndInset":zoomSlider.trackEndInset(value);return true;case"barExtent":zoomSlider.barExtent(value);return true;case"orientation":switch(value){case"horizontal":zoomSlider.orientation(0);break;case"vertical":zoomSlider.orientation(1);break}return true;case"lowerThumbBrush":if(value==null){zoomSlider.lowerThumbBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerThumbBrush($tempBrush)}return true;case"lowerThumbStrokeThickness":zoomSlider.lowerThumbStrokeThickness(value);return true;case"higherThumbStrokeThickness":zoomSlider.higherThumbStrokeThickness(value);return true;case"higherThumbBrush":if(value==null){zoomSlider.higherThumbBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherThumbBrush($tempBrush)}return true;case"lowerThumbOutline":if(value==null){zoomSlider.lowerThumbOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerThumbOutline($tempBrush)}return true;case"higherThumbOutline":if(value==null){zoomSlider.higherThumbOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherThumbOutline($tempBrush)}return true;case"lowerThumbRidgesBrush":if(value==null){zoomSlider.lowerThumbRidgesBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerThumbRidgesBrush($tempBrush)}return true;case"higherThumbRidgesBrush":if(value==null){zoomSlider.higherThumbRidgesBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherThumbRidgesBrush($tempBrush)}return true;case"lowerThumbWidth":zoomSlider.lowerThumbWidth(value);return true;case"higherThumbWidth":zoomSlider.higherThumbWidth(value);return true;case"lowerThumbHeight":zoomSlider.lowerThumbHeight(value);return true;case"higherThumbHeight":zoomSlider.higherThumbHeight(value);return true;case"lowerShadeBrush":if(value==null){zoomSlider.lowerShadeBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerShadeBrush($tempBrush)}return true;case"lowerShadeOutline":if(value==null){zoomSlider.lowerShadeOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerShadeOutline($tempBrush)}return true;case"lowerShadeStrokeThickness":zoomSlider.lowerShadeStrokeThickness(value);return true;case"higherShadeBrush":if(value==null){zoomSlider.higherShadeBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherShadeBrush($tempBrush)}return true;case"higherShadeOutline":if(value==null){zoomSlider.higherShadeOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherShadeOutline($tempBrush)}return true;case"higherShadeStrokeThickness":zoomSlider.higherShadeStrokeThickness(value);return true;case"barBrush":if(value==null){zoomSlider.barBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.barBrush($tempBrush)}return true;case"barOutline":if(value==null){zoomSlider.barOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.barOutline($tempBrush)}return true;case"barStrokeThickness":zoomSlider.barStrokeThickness(value);return true;case"rangeThumbBrush":if(value==null){zoomSlider.rangeThumbBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.rangeThumbBrush($tempBrush)}return true;case"rangeThumbOutline":if(value==null){zoomSlider.rangeThumbOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.rangeThumbOutline($tempBrush)}return true;case"rangeThumbStrokeThickness":zoomSlider.rangeThumbStrokeThickness(value);return true;case"rangeThumbRidgesBrush":if(value==null){zoomSlider.rangeThumbRidgesBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.rangeThumbRidgesBrush($tempBrush)}return true;case"lowerCalloutBrush":if(value==null){zoomSlider.lowerCalloutBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerCalloutBrush($tempBrush)}return true;case"lowerCalloutTextColor":if(value==null){zoomSlider.lowerCalloutTextColor(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerCalloutTextColor($tempBrush)}return true;case"lowerCalloutOutline":if(value==null){zoomSlider.lowerCalloutOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.lowerCalloutOutline($tempBrush)}return true;case"lowerCalloutStrokeThickness":zoomSlider.lowerCalloutStrokeThickness(value);return true;case"higherCalloutBrush":if(value==null){zoomSlider.higherCalloutBrush(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherCalloutBrush($tempBrush)}return true;case"higherCalloutTextColor":if(value==null){zoomSlider.higherCalloutTextColor(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherCalloutTextColor($tempBrush)}return true;case"higherCalloutOutline":if(value==null){zoomSlider.higherCalloutOutline(null)}else{var $tempBrush=$.ig.Brush.prototype.create(value);zoomSlider.higherCalloutOutline($tempBrush)}return true;case"higherCalloutStrokeThickness":zoomSlider.higherCalloutStrokeThickness(value);return true;case"areThumbCalloutsEnabled":zoomSlider.areThumbCalloutsEnabled(value);return true;case"thumbCalloutTextStyle":zoomSlider.thumbCalloutTextStyle(value);return true}},_set_option:function(zoomSlider,key,value){var currentKey;switch(key){case"width":this._setSize(zoomSlider,"width",value);return true;case"height":this._setSize(zoomSlider,"height",value);return true}},_creationOptions:null,_zoomSlider:null,_createWidget:function(options,element,widget){this._creationOptions=options;$.Widget.prototype._createWidget.apply(this,[options,element])},_create:function(){var key,v,size,zoomSlider,width,height,i=-1,self=this,elem=self.element,style=elem[0].style,o=this._creationOptions;self._old_state={style:{position:style.position,width:style.width,height:style.height},css:elem[0].className,elems:elem.find("*")};if(!$.ig.util._isCanvasSupported()){$.ig.util._renderUnsupportedBrowser(this);return}zoomSlider=this._createZoomSlider();self._zoomSlider=zoomSlider;zoomSlider.propertyChanged=$.ig.Delegate.prototype.combine(zoomSlider.propertyChanged,$.proxy(this._fireZoomSlider_propertyChanged,this));zoomSlider.resolvingAxisValue=$.ig.Delegate.prototype.combine(zoomSlider.resolvingAxisValue,$.proxy(this._fireZoomSlider_resolvingAxisValue,this));zoomSlider.windowRectChanged=$.ig.Delegate.prototype.combine(zoomSlider.windowRectChanged,$.proxy(this._fireZoomSlider_windowRectChanged,this));if(o.hasOwnProperty("width"))elem[0].style.width=o["width"];if(o.hasOwnProperty("height"))elem[0].style.height=o["height"];var elemWrapper=new $.ig.JQueryDomWrapper(elem[0],elem);var renderer=new $.ig.JQueryDomRenderer(elemWrapper);this._bootstrapZoomSlider(renderer);zoomSlider.provideContainer(renderer);for(key in o){if(o.hasOwnProperty(key)){v=o[key];if(v!==null){this._setOption(key,v,false)}}}while(i++<1){key=i===0?"width":"height";if(o[key]){size=key;v=o[key]}else{v=elem[0].style[key]}if(v&&typeof v==="string"&&v.indexOf("%")>0){self._setSize(zoomSlider,size=key,v)}}if(!size){self._setSize(zoomSlider,"width")}if(self.css&&self.css.zoomSlider){elem.addClass(self.css.zoomSlider)}},_createZoomSlider:function(){this._columnsColl={};var zoomSlider=new $.ig.ZoomSlider;return zoomSlider},_container:null,_bootstrapZoomSlider:function(renderer){var zoomSlider=this._zoomSlider},_setSize:function(zoomSlider,key,val){$.ig.util.setSize(this.element,key,val,zoomSlider,this._getNotifyResizeName())},_getNotifyResizeName:function(){return"notifySizeChanged"},notifySizeChanged:function(){this._zoomSlider.notifySizeChanged()},flush:function(){if(this._zoomSlider&&this._zoomSlider.view())this._zoomSlider.flush()},destroy:function(){var key,style,zoomSlider=this._zoomSlider,old=this._old_state,elem=this.element;if(!old){return}elem.find("*").not(old.elems).remove();if(this.css.zoomSlider){elem.removeClass(this.css.zoomSlider)}old=old.style;style=elem[0].style;for(key in old){if(old.hasOwnProperty(key)){if(style[key]!==old[key]){style[key]=old[key]}}}if(zoomSlider){this._setSize(zoomSlider)}$.Widget.prototype.destroy.apply(this,arguments);if(zoomSlider&&zoomSlider.destroy){zoomSlider.destroy()}delete this._zoomSlider;delete this._old_state}});$.extend($.ui.igZoomSlider,{version:"19.1.20191.172"});return $.ui.igZoomSlider});