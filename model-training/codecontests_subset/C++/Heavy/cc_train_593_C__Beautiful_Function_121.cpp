#include <bits/stdc++.h>
using namespace std;
string unko(int x) {
  stringstream ss;
  ss << x;
  return ss.str();
}
string _unko(int x) {
  stringstream ss;
  if (x >= 0)
    ss << "+(";
  else
    ss << "-(";
  ss << abs(x);
  return ss.str();
}
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<int> x(n), y(n), r(n);
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i] >> r[i];
    x[i] = x[i] / 2 * 2;
    y[i] = y[i] / 2 * 2;
  }
  string f = unko(x[0]), g = unko(y[0]);
  int _dx = 0, _dy = 0;
  for (int i = 0; i + 1 < n; i++) {
    int dx = (x[i + 1] - x[i]) / 2, dy = (y[i + 1] - y[i]) / 2;
    string s = "*(abs((t-" + unko(i) + "))+(t-" + unko(i) + "))";
    f = "(" + f + _unko(dx - _dx) + s + "))";
    g = "(" + g + _unko(dy - _dy) + s + "))";
    _dx = dx;
    _dy = dy;
  }
  cout << f << endl;
  cout << g << endl;
  return 0;
}
