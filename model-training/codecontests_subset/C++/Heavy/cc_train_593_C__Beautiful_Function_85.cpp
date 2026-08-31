#include <bits/stdc++.h>
using namespace std;
struct elem {
  string s;
  elem() {}
  elem(string ins) { s = ins; }
  elem(int x) {
    if (x == 0)
      s = "0";
    else {
      while (x) {
        s += string(1, char(x % 10 + '0'));
        x /= 10;
      }
      for (int i = 0, j = int(s.size()) - 1; i < j; i++, j--) swap(s[i], s[j]);
    }
  }
};
elem operator+(elem e1, elem e2) { return "(" + e1.s + "+" + e2.s + ")"; }
elem operator-(elem e1, elem e2) { return "(" + e1.s + "-" + e2.s + ")"; }
elem operator*(elem e1, elem e2) { return "(" + e1.s + "*" + e2.s + ")"; }
elem abs(elem e) { return "abs(" + e.s + ")"; }
elem genera(int c, int val) {
  elem e = elem(c) - elem("t");
  e = abs(e + e);
  e = abs(e - 50);
  e = abs(e - 24);
  e = abs(e - 12);
  e = abs(e - 6);
  e = abs(e - 3);
  e = abs(e - 2);
  e = e - 1;
  e = e * (val / 2);
  return e;
}
int main() {
  int n;
  cin >> n;
  int x, y, r;
  cin >> x >> y >> r;
  elem ex = genera(0, x);
  elem ey = genera(0, y);
  for (int i = 1; i < n; i++) {
    cin >> x >> y >> r;
    ex = ex + genera(i, x);
    ey = ey + genera(i, y);
  }
  cout << ex.s << endl;
  cout << ey.s << endl;
}
