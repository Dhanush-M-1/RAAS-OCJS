#include <bits/stdc++.h>
using namespace std;
template <class t>
inline t read(t &x) {
  x = 0;
  char c = getchar();
  bool f = 0;
  while (!isdigit(c)) f |= c == '-', c = getchar();
  while (isdigit(c)) x = (x << 1) + (x << 3) + (c ^ 48), c = getchar();
  if (f) x = -x;
  return x;
}
template <class t>
inline void write(t x) {
  if (x < 0) {
    putchar('-'), write(-x);
  } else {
    if (x > 9) write(x / 10);
    putchar('0' + x % 10);
  }
}
const long long N = 3e5 + 5;
long long n, k, SsEeTt[N][3], f[N << 1], sz[N << 1], s[N], ans, oo;
inline long long min(const long long &x, const long long &y) {
  return x < y ? x : y;
}
inline long long getf(const long long &x) {
  return f[x] == x ? x : f[x] = getf(f[x]);
}
signed main() {
  read(n);
  oo = read(k);
  for (long long i = 1; i <= n; i++) scanf("%1d", &s[i]);
  for (long long i = 1, n, x; i <= k; i++) {
    read(n);
    while (n--) {
      read(x);
      if (!SsEeTt[x][1])
        SsEeTt[x][1] = i;
      else
        SsEeTt[x][2] = i;
    }
  }
  for (long long i = 1; i <= k; i++) {
    f[i * 2 - 1] = i * 2 - 1;
    f[i << 1] = i << 1;
    sz[i << 1] = 1;
  }
  for (long long i = 1, fx, fy, gx, gy; i <= n; i++) {
    if (SsEeTt[i][2]) {
      if (!s[i]) {
        fx = getf(SsEeTt[i][1] * 2 - 1), fy = getf(SsEeTt[i][2] << 1);
        if (fx == fy) {
          write(ans);
          puts("");
          continue;
        }
        gx = getf(SsEeTt[i][1] << 1), gy = getf(SsEeTt[i][2] * 2 - 1);
      } else {
        fx = getf(SsEeTt[i][1] * 2 - 1), fy = getf(SsEeTt[i][2] * 2 - 1);
        if (fx == fy) {
          write(ans);
          puts("");
          continue;
        }
        gx = getf(SsEeTt[i][1] << 1), gy = getf(SsEeTt[i][2] << 1);
      }
      ans -= min(sz[fx], sz[gx]) + min(sz[fy], sz[gy]);
      f[fx] = fy;
      f[gx] = gy;
      sz[fy] += sz[fx];
      sz[gy] += sz[gx];
      ans += min(sz[fy], sz[gy]);
    } else if (SsEeTt[i][1]) {
      long long fx = getf(SsEeTt[i][1] * 2 - 1), fy = getf(SsEeTt[i][1] * 2);
      ans -= min(sz[fx], sz[fy]);
      if (!s[i])
        sz[fx] += oo;
      else
        sz[fy] += oo;
      ans += min(sz[fx], sz[fy]);
    }
    write(ans);
    puts("");
  }
}
