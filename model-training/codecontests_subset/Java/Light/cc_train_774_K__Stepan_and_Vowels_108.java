maybelength = +readline();
s = readline();
s = s.replace(/e{3,}/g,'e');
s = s.replace(/o{3,}/g,'o');
s = s.replace(/a{2,}/g,'a');
s = s.replace(/u{2,}/g,'u');
s = s.replace(/y{2,}/g,'y');
s = s.replace(/i{2,}/g,'i');
print(s);