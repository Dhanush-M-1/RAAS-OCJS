#include <bits/stdc++.h>
using namespace std;
const long long N = 200005;
long long n, k, mo, gs[3], len[3], top, inv[N], s[N], ans;
map<long long, long long> ma;
inline long long read() {
  long long ret = 0, ff = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') ff = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    ret = ret * 10 + (ch ^ 48);
    ch = getchar();
  }
  return ret * ff;
}
void write(long long x) {
  if (x < 0) {
    x = -x, putchar('-');
  }
  if (x > 9) write(x / 10);
  putchar(x % 10 + 48);
}
void writeln(long long x) { write(x), puts(""); }
void writesp(long long x) { write(x), putchar(' '); }
void mergesort(long long l, long long r, long long h) {
  if (l == r || h <= 1) {
    ma[r - l + 1]++;
    return;
  }
  long long mid = (l + r) >> 1;
  mergesort(l, mid, h - 1), mergesort(mid + 1, r, h - 1);
}
long long calc(long long x, long long y) {
  long long res = x * y % mo * inv[2] % mo;
  for (long long i = 1; i <= x; i++)
    res = (res - (s[i + y] - s[i]) % mo + mo) % mo;
  return res;
}
signed main() {
  n = read(), k = read(), mo = read();
  mergesort(1, n, k);
  for (map<long long, long long>::iterator it = ma.begin(); it != ma.end();
       it++) {
    len[++top] = it->first;
    gs[top] = it->second;
  }
  inv[0] = inv[1] = 1;
  s[0] = 1, s[1] = 2;
  for (long long i = 2; i <= 200000; i++)
    inv[i] = (mo - mo / i) * inv[mo % i] % mo, s[i] = (s[i - 1] + inv[i]) % mo;
  ans = (ans + gs[1] * len[1] % mo * (len[1] - 1) % mo * inv[4] % mo) % mo;
  ans = (ans + gs[2] * len[2] % mo * (len[2] - 1) % mo * inv[4] % mo) % mo;
  ans = (ans +
         gs[1] * (gs[1] - 1) % mo * inv[2] % mo * calc(len[1], len[1]) % mo) %
        mo;
  ans = (ans +
         gs[2] * (gs[2] - 1) % mo * inv[2] % mo * calc(len[2], len[2]) % mo) %
        mo;
  ans = (ans + gs[1] * gs[2] % mo * calc(len[1], len[2]) % mo) % mo;
  write(ans);
  return 0;
}
