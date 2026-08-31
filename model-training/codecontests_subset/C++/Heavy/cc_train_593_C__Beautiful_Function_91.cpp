#include <bits/stdc++.h>
using namespace std;
int n, x, y, r;
string f, g, a, b;
string to_str(int q);
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  f = "";
  g = "";
  for (int i = 0; i < n; ++i) {
    cin >> x >> y >> r;
    x /= 2;
    y /= 2;
    a = "(((1-abs((t-" + to_str(i) + ")))+abs((abs((t-" + to_str(i) +
        "))-1)))*" + to_str(x) + ")";
    b = "(((1-abs((t-" + to_str(i) + ")))+abs((abs((t-" + to_str(i) +
        "))-1)))*" + to_str(y) + ")";
    f = (f.length() ? "(" + f + "+" + a + ")" : a);
    g = (g.length() ? "(" + g + "+" + b + ")" : b);
  }
  cout << f << "\n";
  cout << g << "\n";
  return 0;
}
string to_str(int q) {
  string e = (q ? "" : "0");
  while (q > 0) {
    e = char('0' + q % 10) + e;
    q /= 10;
  }
  return e;
}
