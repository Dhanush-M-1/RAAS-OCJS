#include <bits/stdc++.h>
using namespace std;
void Freopen() {
  freopen(
      "title"
      ".in",
      "r", stdin);
  freopen(
      "title"
      ".out",
      "w", stdout);
}
int read() {
  int g = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || '9' < ch) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while ('0' <= ch && ch <= '9') {
    g = g * 10 + ch - '0';
    ch = getchar();
  }
  return g * f;
}
const int N = 1e5 + 5;
int n, k, mod, l1, l2, c1, c2, inv[N], s[N];
int ksm(int x, int y) {
  int re = 1;
  for (; y; y >>= 1, x = 1ll * x * x % mod)
    if (y & 1) re = 1ll * re * x % mod;
  return re;
}
void solve(int l, int r, int h) {
  if (h == k || l == r) {
    if (!l1)
      l1 = r - l + 1, c1++;
    else if (r - l + 1 == l1)
      c1++;
    else if (!l2)
      l2 = r - l + 1, c2++;
    else
      c2++;
    return void();
  }
  int mid = l + r >> 1;
  solve(l, mid, h + 1), solve(mid + 1, r, h + 1);
}
int calc(int l1, int l2) {
  if (!l1 || !l2) return 0;
  int re = 1ll * l1 * l2 % mod * inv[2] % mod;
  for (int i = (1); i <= (l1); i++)
    re = (1ll * re + mod - (s[i + l2] + mod - s[i]) % mod) % mod;
  return re;
}
signed main() {
  n = read(), k = read(), mod = read();
  inv[1] = 1;
  for (int i = (2); i <= ((int)1e5); i++)
    inv[i] = 1ll * (mod - mod / i) * inv[mod % i] % mod;
  for (int i = (1); i <= (n); i++) s[i] = (s[i - 1] + inv[i]) % mod;
  solve(1, n, 1);
  int ans = (1ll * c1 * l1 % mod * (l1 - 1) % mod * inv[4] % mod +
             1ll * c2 * l2 % mod * (l2 - 1) % mod * inv[4] % mod) %
            mod;
  ans = (ans + 1ll * c1 * (c1 - 1) % mod * inv[2] % mod * calc(l1, l1) % mod) %
        mod;
  ans = (ans + 1ll * c2 * (c2 - 1) % mod * inv[2] % mod * calc(l2, l2) % mod) %
        mod;
  ans = (ans + 1ll * c1 * c2 % mod * calc(l1, l2) % mod) % mod;
  return cout << ans, signed();
}
