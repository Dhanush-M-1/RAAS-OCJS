#include <bits/stdc++.h>
inline long long read() {
  char c = getchar();
  while (c != '-' && (c < '0' || c > '9')) c = getchar();
  long long k = 0, kk = 1;
  if (c == '-') c = getchar(), kk = -1;
  while (c >= '0' && c <= '9') k = k * 10 + c - '0', c = getchar();
  return kk * k;
}
using namespace std;
void write(long long x) {
  if (x < 0) x = -x, putchar('-');
  if (x / 10) write(x / 10);
  putchar(x % 10 + '0');
}
void writeln(long long x) {
  write(x);
  puts("");
}
long long n, d, a[1000010], l, r, ans;
signed main() {
  n = read();
  d = read();
  l = r = 0;
  for (long long i = 1; i <= n; i++) {
    a[i] = read();
    l += a[i];
    r += a[i];
    if (l > d) {
      puts("-1");
      return 0;
    }
    r = min(r, d);
    if (!a[i] && l < 0) {
      l = max(l, 0ll);
      if (r < 0) ans++, r = d;
    }
  }
  writeln(ans);
}
