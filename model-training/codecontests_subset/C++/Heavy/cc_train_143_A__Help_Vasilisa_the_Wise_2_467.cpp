#include <bits/stdc++.h>
using namespace std;
bool fun(int a) {
  if (a > 0 && a < 10)
    return true;
  else
    return false;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a[4];
  a[0] = (r1 + d1 - c2) / 2;
  a[1] = (c2 + r1 - d1) / 2;
  a[2] = c1 - a[0];
  a[3] = c2 - a[1];
  int k = r1 + r2, l = d1 + d2, m = c1 + c2;
  if (k == l && l == m && a[0] != a[1] && a[1] != a[2] && a[2] != a[3] &&
      a[1] != a[3] && a[0] != a[3] && a[0] != a[2] && fun(a[0]) && fun(a[1]) &&
      fun(a[2]) && fun(a[3])) {
    cout << a[0] << " " << a[1] << endl;
    cout << a[2] << " " << a[3] << endl;
  } else
    cout << "-1" << endl;
}
