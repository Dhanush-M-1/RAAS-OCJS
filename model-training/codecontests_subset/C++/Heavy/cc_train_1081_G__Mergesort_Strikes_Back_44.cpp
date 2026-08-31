#include <bits/stdc++.h>
using namespace std;
int n, k, mod, num[200005];
void Add(int &a, int b) { ((a += b) >= mod) && (a -= mod); }
int ksm(int a, int b) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = 1ll * ans * a % mod;
    a = 1ll * a * a % mod;
    b >>= 1;
  }
  return ans;
}
void dfs(int dep, int l, int r) {
  if (dep == 1) {
    ++num[r - l + 1];
    return;
  }
  if (l == r) {
    ++num[1];
    return;
  }
  int mid = l + r >> 1;
  dfs(dep - 1, l, mid);
  dfs(dep - 1, mid + 1, r);
}
int ans, sm[200005], inv[200005], ny[200005];
int main() {
  scanf("%d%d%d", &n, &k, &mod);
  n <<= 1;
  sm[0] = ny[0] = 1;
  for (int i = 1; i <= n; ++i) sm[i] = 1ll * sm[i - 1] * i % mod;
  inv[n] = ksm(sm[n], mod - 2);
  for (int i = n - 1; i >= 0; --i) inv[i] = 1ll * inv[i + 1] * (i + 1) % mod;
  for (int i = 1; i <= n; ++i) ny[i] = 1ll * inv[i] * sm[i - 1] % mod;
  n >>= 1;
  dfs(k, 1, n);
  for (int i = 1; i <= n; ++i) {
    if (num[i]) {
      Add(ans, 1ll * i * (i - 1) % mod * ksm(4, mod - 2) % mod * num[i] % mod);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (num[i])
      for (int j = i; j <= n; ++j) {
        if (num[j]) {
          for (int k = 2; k <= i + j; ++k) {
            if (i == j)
              Add(ans, 1ll * (k - 2) * ny[2 * k] % mod *
                           min(k - 1, min(k, i) - max(k - j, 1) + 1) % mod *
                           (1ll * num[i] * (num[i] - 1) % mod * ny[2] % mod) %
                           mod);
            else
              Add(ans, 1ll * (k - 2) * ny[2 * k] % mod *
                           min(k - 1, min(k, i) - max(k - j, 1) + 1) % mod *
                           num[i] % mod * num[j] % mod);
          }
        }
      }
  }
  printf("%d\n", ans);
  return 0;
}
