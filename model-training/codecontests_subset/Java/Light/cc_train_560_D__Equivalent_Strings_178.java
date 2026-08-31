var print = this.print || require("lol-io").print;
var readline = this.readline || require("lol-io").readline;

const s1 = readline(); const s2 = readline();
print(is_equivalent(s1, s2)  ? 'YES' : 'NO');

function is_equivalent(s1, s2) {
  if(s1.length & 1) return s1 === s2;

  const n = s1.length;
  const a1 = s1.substr(0, n / 2); const a2 = s1.substr(n / 2, n / 2);
  const b1 = s2.substr(0, n / 2); const b2 = s2.substr(n / 2, n / 2);  
  return ((is_equivalent(a1, b2) && is_equivalent(a2, b1) || is_equivalent(a1, b1) && is_equivalent(a2, b2)));
}
