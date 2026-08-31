#include <bits/stdc++.h>
using namespace std;
int read() {
  int X = 0, w = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') w = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') X = X * 10 + c - '0', c = getchar();
  return X * w;
}
const int N = 100000 + 10;
int mod, inv2, inv4;
int qpow(int a, int b) {
  int c = 1;
  for (; b; b >>= 1, a = 1ll * a * a % mod)
    if (b & 1) c = 1ll * c * a % mod;
  return c;
}
int n, k;
int inv[N], sum[N], o[N];
vector<int> l;
void divide(int l, int r, int d) {
  if (d == k || l == r) {
    ++o[r - l + 1];
    return;
  }
  int mid = (l + r) >> 1;
  divide(l, mid, d + 1), divide(mid + 1, r, d + 1);
}
int calc(int x, int y) {
  int res = 1ll * x * y % mod * inv2 % mod;
  for (int i = 1; i <= x; ++i)
    res = (res - (sum[i + y] - sum[i] + mod) % mod + mod) % mod;
  return res;
}
int main() {
  n = read(), k = read(), mod = read(), inv2 = qpow(2, mod - 2),
  inv4 = qpow(4, mod - 2);
  inv[1] = 1;
  for (int i = 2; i <= n; ++i)
    inv[i] = mod - 1ll * inv[mod % i] * (mod / i) % mod;
  for (int i = 1; i <= n; ++i) sum[i] = (sum[i - 1] + inv[i]) % mod;
  divide(1, n, 1);
  for (int i = 1; i <= n; ++i)
    if (o[i]) l.emplace_back(i);
  int ans = 0;
  for (int i : l)
    ans = (ans + 1ll * i * (i - 1) % mod * inv4 % mod * o[i]) % mod;
  for (int i : l)
    ans = (ans + 1ll * o[i] * (o[i] - 1) / 2 % mod * calc(i, i)) % mod;
  if (l.size() > 1)
    ans = (ans + 1ll * o[l[0]] * o[l[1]] % mod * calc(l[0], l[1])) % mod;
  printf("%d\n", ans);
  return 0;
}
