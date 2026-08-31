#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-7;
const double PI = acos(-1.0);
const long long mod = 1e18;
const int maxn = 100000 + 5;
const int N = 10000 + 5;
int r1, r2, c1, c2, d1, d2;
int x, y, z, w;
int infer(int n) {
  if (n > 0 && n < 10) return 1;
  return 0;
}
int ck(int a, int b, int c, int d) {
  if (a == b || a == c || a == d) return 0;
  if (b == c || b == d) return 0;
  if (c == d) return 0;
  return 1;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool flag = false;
  for (int i = 1; i < 10; i++) {
    for (int j = 1; j < 10; j++) {
      x = i, y = j;
      w = d1 - x, z = d2 - y;
      if (infer(z) && infer(w)) {
        if (x + y == r1 && z + w == r2 && x + z == c1 && y + w == c2 &&
            ck(x, y, z, w)) {
          flag = true;
          break;
        }
      }
    }
    if (flag) break;
  }
  if (flag)
    cout << x << " " << y << endl << z << " " << w << endl;
  else
    cout << "-1" << endl;
  return 0;
}
