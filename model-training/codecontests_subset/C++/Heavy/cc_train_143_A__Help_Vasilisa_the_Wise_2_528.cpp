#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 5;
int a[maxn];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int k2 = (d2 + r2 - c2);
  if (k2 % 2 == 1) {
    cout << -1 << endl;
    return 0;
  }
  int c = k2 / 2;
  int a = c1 - c;
  int b = r1 - a;
  int d = r2 - c;
  if (a < 1 || b < 1 || c < 1 || d < 1 || a > 9 || b > 9 || c > 9 || d > 9) {
    cout << -1 << endl;
    return 0;
  }
  if (a == b || a == c || a == d || b == c || b == d || c == d) {
    cout << -1 << endl;
    return 0;
  }
  if (a + b != r1 || a + c != c1 || a + d != d1 || b + c != d2 || b + d != c2 ||
      c + d != r2) {
    cout << -1 << endl;
    return 0;
  }
  cout << a << " " << b << endl;
  cout << c << " " << d << endl;
}
