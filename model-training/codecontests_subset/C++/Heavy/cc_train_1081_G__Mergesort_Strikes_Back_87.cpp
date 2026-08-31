#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, k, mod, ans;
int inv[N], sum[N];
map<int, int> cnt;
map<int, int>::iterator it1, it2;
int read() {
  int ret = 0, f = 1;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = 0;
    c = getchar();
  }
  while (isdigit(c)) ret = ret * 10 + (c ^ 48), c = getchar();
  return f ? ret : -ret;
}
void up(int &x, int y) {
  x += y;
  if (x >= mod) x -= mod;
  if (x < 0) x += mod;
}
int qpow(int x, int y) {
  int res = 1;
  x %= mod;
  for (; y; y >>= 1, x = (long long)x * x % mod)
    if (y & 1) res = (long long)res * x % mod;
  return res;
}
void init() {
  n = read();
  k = read();
  mod = read();
  for (int i = 1; i < N; ++i)
    sum[i] = inv[i] = qpow(i, mod - 2), up(sum[i], sum[i - 1]);
}
void divide(int l, int r, int dp) {
  if (dp <= 1 || l == r) {
    cnt[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  divide(l, mid, dp - 1);
  divide(mid + 1, r, dp - 1);
}
int calc(int x, int y) {
  int res = (long long)x * y % mod;
  for (int i = 1; i <= x; ++i) up(res, -(sum[i + y] - sum[i]) * 2 % mod);
  return res;
}
void solve() {
  for (it1 = cnt.begin(); it1 != cnt.end(); ++it1) {
    int t = it1->first, s = it1->second;
    up(ans, (long long)t * (t - 1) % mod * inv[2] % mod * s % mod);
    up(ans, (long long)s * (s - 1) % mod * inv[2] % mod * calc(t, t) % mod);
  }
  for (it1 = cnt.begin(); it1 != cnt.end(); ++it1)
    for (it2 = cnt.begin(); it2 != cnt.end(); ++it2) {
      int x = it1->first, y = it2->first;
      if (x >= y) continue;
      up(ans, (long long)calc(x, y) * it1->second % mod * it2->second % mod);
    }
  printf("%d\n", (long long)ans * inv[2] % mod);
}
int main() {
  init();
  divide(1, n, k);
  solve();
  return 0;
}
