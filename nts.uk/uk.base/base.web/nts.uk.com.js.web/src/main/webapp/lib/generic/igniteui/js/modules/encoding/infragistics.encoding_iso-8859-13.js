/*!@license
* Infragistics.Web.ClientUI infragistics.encoding_iso-8859-13.js 19.1.20191.172
*
* Copyright (c) 2011-2019 Infragistics Inc.
*
* http://www.infragistics.com/
*
* Depends:
*     jquery-1.4.4.js
*     jquery.ui.core.js
*     jquery.ui.widget.js
*     infragistics.util.js
*     infragistics.ext_core.js
*     infragistics.ext_collections.js
*     infragistics.ext_text.js
*     infragistics.encoding.core.js
*/
(function(factory){if(typeof define==="function"&&define.amd){define(["./infragistics.util","./infragistics.ext_core","./infragistics.ext_collections","./infragistics.ext_text","./infragistics.encoding.core"],factory)}else{factory(igRoot)}})(function($){$.ig=$.ig||{};var $$t={};$.ig.globalDefs=$.ig.globalDefs||{};$.ig.globalDefs.$$be=$$t;$.ig.$currDefinitions=$$t;$.ig.util.bulkDefine(["Iso8859Dash13:a","SingleByteEncoding:b","Encoding:c","Object:d","Type:e","Boolean:f","ValueType:g","Void:h","IConvertible:i","IFormatProvider:j","Number:k","String:l","IComparable:m","Number:n","IComparable$1:o","IEquatable$1:p","Number:q","Number:r","Number:s","NumberStyles:t","Enum:u","Array:v","IList:w","ICollection:x","IEnumerable:y","IEnumerator:z","Error:aa","Error:ab","Number:ac","String:ad","StringComparison:ae","RegExp:af","CultureInfo:ag","DateTimeFormat:ah","Calendar:ai","Date:aj","Number:ak","DayOfWeek:al","DateTimeKind:am","CalendarWeekRule:an","NumberFormatInfo:ao","CompareInfo:ap","CompareOptions:aq","IEnumerable$1:ar","IEnumerator$1:as","IDisposable:at","StringSplitOptions:au","Number:av","Number:aw","Number:ax","Number:ay","Number:az","Number:a0","Assembly:a1","Stream:a2","SeekOrigin:a3","RuntimeTypeHandle:a4","MethodInfo:a5","MethodBase:a6","MemberInfo:a7","ParameterInfo:a8","TypeCode:a9","ConstructorInfo:ba","PropertyInfo:bb","UTF8Encoding:bc","InvalidOperationException:bd","NotImplementedException:be","Script:bf","Decoder:bg","UnicodeEncoding:bh","Math:bi","AsciiEncoding:bj","ArgumentNullException:bk","DefaultDecoder:bl","ArgumentException:bm","IEncoding:bn","Dictionary$2:bo","IDictionary$2:bp","ICollection$1:bq","KeyValuePair$2:br","IDictionary:bs","IEqualityComparer$1:bt","EqualityComparer$1:bu","IEqualityComparer:bv","DefaultEqualityComparer$1:bw","Thread:bx","ThreadStart:by","MulticastDelegate:bz","IntPtr:b0","StringBuilder:b1","Environment:b2","RuntimeHelpers:b3","RuntimeFieldHandle:b4","AbstractEnumerable:b5","Func$1:b6","AbstractEnumerator:b7","GenericEnumerable$1:b8","GenericEnumerator$1:b9"]);var $a=$.ig.intDivide,$b=$.ig.util.cast,$c=$.ig.util.defType,$d=$.ig.util.defEnum,$e=$.ig.util.getBoxIfEnum,$f=$.ig.util.getDefaultValue,$g=$.ig.util.getEnumValue,$h=$.ig.util.getValue,$i=$.ig.util.intSToU,$j=$.ig.util.nullableEquals,$k=$.ig.util.nullableIsNull,$l=$.ig.util.nullableNotEquals,$m=$.ig.util.toNullable,$n=$.ig.util.toString$1,$o=$.ig.util.u32BitwiseAnd,$p=$.ig.util.u32BitwiseOr,$q=$.ig.util.u32BitwiseXor,$r=$.ig.util.u32LS,$s=$.ig.util.unwrapNullable,$t=$.ig.util.wrapNullable,$u=String.fromCharCode,$v=$.ig.util.castObjTo$t;$c("Iso8859Dash13:a","SingleByteEncoding",{ai:null,ac:function(){return this.ai},init:function(){this.ai=["\0","\x01","\x02","\x03","\x04","\x05","\x06","\x07","\b","\t","\n","\x0B","\f","\r","\x0e","\x0f","\x10","\x11","\x12","\x13","\x14","\x15","\x16","\x17","\x18","\x19","\x1a","\x1b","\x1c","\x1d","\x1e","\x1f"," ","!",'"',"#","$","%","&","'","(",")","*","+",",","-",".","/","0","1","2","3","4","5","6","7","8","9",":",";","<","=",">","?","@","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","[","\\","]","^","_","`","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","{","|","}","~","\x7f","\x80","\x81","\x82","\x83","\x84","\x85","\x86","\x87","\x88","\x89","\x8a","\x8b","\x8c","\x8d","\x8e","\x8f","\x90","\x91","\x92","\x93","\x94","\x95","\x96","\x97","\x98","\x99","\x9a","\x9b","\x9c","\x9d","\x9e","\x9f","\xa0","\u201d","\xa2","\xa3","\xa4","\u201e","\xa6","\xa7","\xd8","\xa9","\u0156","\xab","\xac","\xad","\xae","\xc6","\xb0","\xb1","\xb2","\xb3","\u201c","\xb5","\xb6","\xb7","\xf8","\xb9","\u0157","\xbb","\xbc","\xbd","\xbe","\xe6","\u0104","\u012e","\u0100","\u0106","\xc4","\xc5","\u0118","\u0112","\u010c","\xc9","\u0179","\u0116","\u0122","\u0136","\u012a","\u013b","\u0160","\u0143","\u0145","\xd3","\u014c","\xd5","\xd6","\xd7","\u0172","\u0141","\u015a","\u016a","\xdc","\u017b","\u017d","\xdf","\u0105","\u012f","\u0101","\u0107","\xe4","\xe5","\u0119","\u0113","\u010d","\xe9","\u017a","\u0117","\u0123","\u0137","\u012b","\u013c","\u0161","\u0144","\u0146","\xf3","\u014d","\xf5","\xf6","\xf7","\u0173","\u0142","\u015b","\u016b","\xfc","\u017c","\u017e","\u2019"];$$t.$b.init1.call(this,1,28603,"iso-8859-13")},$type:new $.ig.Type("Iso8859Dash13",$$t.$b.$type)},true)});