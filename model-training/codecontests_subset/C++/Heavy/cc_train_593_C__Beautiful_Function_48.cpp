#include <bits/stdc++.h>
using namespace std;
int n;
int x, y, r;
string f, g;
string trans(int q);
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  f = "";
  g = "";
  for (int i = 0; i < n; ++i) {
    cin >> x >> y >> r;
    x /= 2;
    y /= 2;
    string a = "";
    string b = "";
    a += "(((1-abs((t-";
    a += trans(i);
    a += ")))+abs((abs((t-";
    a += trans(i);
    a += "))-1)))*";
    a += trans(x);
    a += ")";
    b += "(((1-abs((t-";
    b += trans(i);
    b += ")))+abs((abs((t-";
    b += trans(i);
    b += "))-1)))*";
    b += trans(y);
    b += ")";
    if (f.length() == 0)
      f += a;
    else {
      f = "(" + f;
      f += "+";
      f += a;
      f += ")";
    }
    if (g.length() == 0)
      g += b;
    else {
      g = "(" + g;
      g += "+";
      g += b;
      g += ")";
    }
  }
  cout << f << endl;
  cout << g << endl;
  return 0;
}
string trans(int q) {
  string e = "";
  if (q == 0)
    e += "0";
  else {
    while (q > 0) {
      int p = q % 10;
      char c = char('0' + p);
      e = c + e;
      q /= 10;
    }
  }
  return e;
}
