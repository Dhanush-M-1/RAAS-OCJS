#include <bits/stdc++.h>
using namespace std;
const int maxn = 200100;
int mod, n, h;
inline void Add(int &a, int b) { a = a + b >= mod ? a + b - mod : a + b; }
int inv[maxn], sum[maxn];
inline int Qsum(int l, int r) { return (sum[r] - sum[l - 1] + mod) % mod; }
int cnt[maxn], S, L;
int ans;
inline void getblock(int l, int r, int dep) {
  if (dep >= h || l == r) {
    int size = r - l + 1;
    cnt[size]++;
    if (L == 0)
      L = size;
    else if (L != size)
      S = size;
    if (S > L) swap(S, L);
    Add(ans, 1ll * size * (size - 1) % mod * inv[4] % mod);
    return;
  }
  int mid = (l + r) >> 1;
  getblock(l, mid, dep + 1);
  getblock(mid + 1, r, dep + 1);
}
inline int getans(int size1, int size2) {
  int ans = 1ll * size1 * size2 * inv[2] % mod;
  for (int i = 1; i <= size1; i++) Add(ans, mod - Qsum(i + 1, i + size2));
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &h, &mod);
  inv[1] = 1;
  for (int i = 2; i < maxn; i++)
    inv[i] = 1ll * (mod - mod / i) * inv[mod % i] % mod;
  for (int i = 1; i < maxn; i++) sum[i] = (sum[i - 1] + inv[i]) % mod;
  getblock(1, n, 1);
  if (S == 0) S = L, L = 0;
  Add(ans,
      1ll * getans(S, S) * cnt[S] % mod * (cnt[S] - 1) % mod * inv[2] % mod);
  if (L)
    Add(ans,
        1ll * getans(L, L) * cnt[L] % mod * (cnt[L] - 1) % mod * inv[2] % mod);
  if (L) Add(ans, 1ll * getans(S, L) * cnt[S] % mod * cnt[L] % mod);
  printf("%d", ans);
}
