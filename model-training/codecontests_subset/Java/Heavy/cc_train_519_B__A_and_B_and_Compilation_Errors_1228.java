(function() {
var INPUT = ``;
var OUTPUT = ``;

var main = function() {"use strict";
    // TODO
    var n = rdN();
    var A = rdArN().sortLt();
    var B = rdArN().sortLt().concat([null]);
    var C = rdArN().sortLt().concat([null, null]);
    for (var i = 0; i < A.length; ++i) {
        if (A[i] !== B[i]) {
            pr(A[i]);
            break;
        }
    }
    for (var i = 0; i < B.length; ++i) {
        if (B[i] !== C[i]) {
            pr(B[i]);
            break;
        }
    }
};

if(INPUT){INPUT=INPUT.split('\n').reverse();
readline=()=>INPUT.pop();
write=(...s)=>{OUTPUT+=[...s].join(' ')};
print=(...s)=>{write(...s);OUTPUT+='\n'};}
const rdS=readline;
const rdN=()=>+rdS();
const rdArS=()=>rdS().split(' ');
const rdArN=()=>rdArS().map(v=>+v);
const wr=write;
const pr=print;
const prAr=(a)=>pr(...a);
const prOb=(o)=>pr(JSON.stringify(o,null,4));
const cmpLt=(a,b)=>a-b;
const cmpGt=(a,b)=>b-a;
const crAr=function(length,...fillArgs){return new Array(length).fill(...fillArgs);};
const getPrimes=function(n){var sieve=crAr(n+1,true);for(var i=2,j=4;j<sieve.length;j=Math.pow(++i,2)){if(sieve[j]){for(;j<sieve.length;j+=i){sieve[j]=false;}}}var primes=[];for(i=2;i<sieve.length;++i){if(sieve[i]){primes.push(i);}}return primes;};
const defineProperty=(o,pN,v)=>Object.defineProperty(o,pN,{configurable:true,enumerable:false,value:v});
defineProperty(Array.prototype,'sortLt',function(){return this.sort(cmpLt);});
defineProperty(Array.prototype,'sortGt',function(){return this.sort(cmpGt);});
defineProperty(Set.prototype,'union',function(s){return new Set([...this,...s]);});
defineProperty(Set.prototype,'intersection',function(s){return new Set([...this].filter((v)=>s.has(v)));});
defineProperty(Set.prototype,'difference',function(s){return new Set([...this].filter((v)=>!s.has(v)));});

main();
return OUTPUT;
})();