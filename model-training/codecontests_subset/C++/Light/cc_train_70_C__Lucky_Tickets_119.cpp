#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f, N = 2e5 + 5;
inline int read() {
  int sum = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') f = -f;
    c = getchar();
  }
  while (c >= '0' && c <= '9') sum = sum * 10 + c - 48, c = getchar();
  return sum * f;
}
int mx, my, w, x, y, ansx, ansy;
int rev(int x) {
  int ans = 0;
  while (x) {
    ans = ans * 10 + x % 10;
    x /= 10;
  }
  return ans;
}
map<double, int> m1, m2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> mx >> my >> w;
  for (int x = 1; x <= mx; x++) {
    double tmp = x * 1.0 / rev(x);
    m1[tmp]++;
  }
  x = mx;
  int cnt = 0;
  while (y <= my && x >= 1) {
    if (cnt < w) {
      y++;
      double tmp = rev(y) * 1.0 / y;
      cnt += m1[tmp];
      m2[tmp]++;
    } else {
      if (!ansx || x * y < ansx * ansy) {
        ansx = x;
        ansy = y;
      }
      double tmp = x * 1.0 / rev(x);
      cnt -= m2[tmp];
      m1[tmp]--;
      x--;
    }
  }
  if (!ansx)
    cout << -1 << '\n';
  else
    cout << ansx << ' ' << ansy << '\n';
  return 0;
}
