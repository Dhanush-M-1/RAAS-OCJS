#include <bits/stdc++.h>
using namespace std;
const long long INF = 12345678987654321LL;
const int MAXN = 100100;
pair<int, int> r[MAXN];
inline int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
inline int rev(int x) {
  int r = 0;
  while (x > 0) {
    r = r * 10 + x % 10;
    x /= 10;
  }
  return r;
}
pair<int, int> inv(pair<int, int> &p) { return make_pair(p.second, p.first); }
void init() {
  for (int i = 1; i <= 100000; i++) {
    int t = rev(i);
    int g = gcd(i, t);
    r[i] = make_pair(i / g, t / g);
  }
}
int main() {
  init();
  for (int mx, my, w; ~scanf("%d%d%d", &mx, &my, &w);) {
    map<pair<int, int>, int> mpx, mpy;
    for (int y = 1; y <= my; y++) {
      mpy[r[y]]++;
    }
    long long X = -1, Y = -1;
    long long iw = 0;
    for (long long x = 1, y = my; x <= mx; x++) {
      iw += mpy[inv(r[x])];
      mpx[r[x]]++;
      while (iw >= w) {
        iw -= mpx[inv(r[y])];
        mpy[r[y]]--;
        y--;
        if (iw < w) {
          y++;
          mpy[r[y]]++;
          iw += mpx[inv(r[y])];
          break;
        }
      }
      if (iw >= w && (X == -1 || x * y < X * Y)) {
        X = x;
        Y = y;
      }
    }
    if (X == -1) {
      puts("-1");
    } else {
      printf("%I64d %I64d\n", X, Y);
    }
  }
  return 0;
}
