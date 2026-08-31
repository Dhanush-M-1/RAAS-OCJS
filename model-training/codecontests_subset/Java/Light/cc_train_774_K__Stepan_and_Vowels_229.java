var n = readline();
var s = readline()

var letters = ['a', 'i', 'u', 'y']
var lettters = ['o', 'e']

var ss = ""
var k = 1;

for (var i = 1; i < s.length; ++i) {
  if (s[i] == s[i - 1]) ++k;
  else {
    if (k > 1) {
      if (letters.indexOf(s[i - 1]) != -1) {
        ss += s[i - 1];
      }
      else if (lettters.indexOf(s[i - 1]) != -1) {
        if (k > 2) ss += s[i - 1];
        else ss += s[i - 1] + s[i - 1];
      }
      else {
        for (var q = 0; q < k; ++q) ss += s[i - 1];
      }
    }
    else ss += s[i - 1];
    k = 1;
  }
}

var i = s.length
if (k > 1) {
  if (letters.indexOf(s[i - 1]) != -1) {
    ss += s[i - 1];
  }
  else if (lettters.indexOf(s[i - 1]) != -1) {
    if (k > 2) ss += s[i - 1];
    else ss += s[i - 1] + s[i - 1];
  }
  else {
    for (var q = 0; q < k; ++q) ss += s[i - 1];
  }
}
else ss += s[i - 1];

print(ss);
