#include <bits/stdc++.h>
using namespace std;
int n, k, mod, cnt[100005], s[100005], inv[100005], L = 100005, R, ans;
void divide(int l, int r, int h) {
  if (h <= 1 || l == r) {
    cnt[r - l + 1]++, L = min(L, r - l + 1), R = max(R, r - l + 1);
    return;
  }
  int mid = (l + r) >> 1;
  divide(l, mid, h - 1), divide(mid + 1, r, h - 1);
}
int calc(int x, int y) {
  int ret = 1ll * x * y % mod * inv[2] % mod;
  for (int i = 1; i <= x; i++) ret = (ret - 1ll * (s[i + y] - s[i])) % mod;
  return (ret + mod) % mod;
}
int main() {
  scanf("%d%d%d", &n, &k, &mod);
  divide(1, n, k);
  inv[0] = inv[1] = s[1] = 1;
  for (int i = 2; i <= max(4, n); i++)
    inv[i] = 1ll * (mod - mod / i) * inv[mod % i] % mod,
    s[i] = (s[i - 1] + inv[i]) % mod;
  for (int i = L; i <= R; i++) {
    ans = (ans + 1ll * i * (i - 1) % mod * inv[4] % mod * cnt[i]) % mod;
    ans =
        (ans + 1ll * cnt[i] * (cnt[i] - 1) % mod * inv[2] % mod * calc(i, i)) %
        mod;
    for (int j = i + 1; j <= R; j++)
      ans = (ans + 1ll * cnt[i] * cnt[j] % mod * calc(i, j)) % mod;
  }
  printf("%d\n", ans);
}
