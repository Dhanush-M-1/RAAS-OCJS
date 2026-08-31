#include <bits/stdc++.h>
using namespace std;
int maxx, maxy, w, l, r, ans, ansl, ansr, cnt, sum;
map<double, int> t1, t2;
inline int read() {
  int s = 0, w = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    s = s * 10 + ch - '0';
    ch = getchar();
  }
  return s * w;
}
int rev(int x) {
  int res = 0;
  while (x) {
    res = res * 10 + x % 10;
    x /= 10;
  }
  return res;
}
int main() {
  maxx = read();
  maxy = read();
  w = read();
  ans = 1e10;
  for (int i = 1; i <= maxx; i++) t1[1.0 * i / rev(i)]++;
  for (int i = 1; i <= maxy; i++) sum += t1[1.0 * rev(i) / i];
  if (sum < w)
    printf("%d\n", -1);
  else {
    l = maxx, r = 0;
    while (l && r <= maxy) {
      while (cnt < w && r <= maxy) {
        r++;
        t2[1.0 * rev(r) / r]++;
        cnt += t1[1.0 * rev(r) / r];
      }
      if (cnt >= w && r * l < ans) {
        ans = r * l;
        ansl = l;
        ansr = r;
      }
      cnt -= t2[1.0 * l / rev(l)];
      t1[1.0 * l / rev(l)]--;
      l--;
    }
    printf("%d %d\n", ansl, ansr);
  }
  return 0;
}
