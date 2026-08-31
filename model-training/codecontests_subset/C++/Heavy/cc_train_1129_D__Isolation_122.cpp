#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 9, mod = 998244353, maxm = 409;
int n, k, ans;
int a[maxn], cnt[maxn], lst[maxn], fir[maxn], bl[maxm], br[maxm], col[maxn],
    v[maxn], lazy[maxm], f[maxn], sum[maxm][maxn];
inline void Fir() {
  int size(sqrt(n));
  int pieces(ceil(1.0 * n / size));
  for (int i = 1; i <= pieces; ++i) {
    bl[i] = (i - 1) * size + 1;
    br[i] = (i == pieces ? n : i * size);
    for (int j = bl[i]; j <= br[i]; ++j) col[j] = i;
  }
  for (int i = 1; i <= n; ++i) {
    lst[i] = fir[a[i]];
    fir[a[i]] = i;
  }
}
inline void Modify(int l, int r, int val) {
  int lt(col[l]), rt(col[r]);
  if (lt == rt) {
    for (int i = l; i <= r; ++i) {
      if (val == 1) {
        if (v[i] + lazy[lt] == k) ans = (ans - f[i] + mod) % mod;
      } else {
        if (v[i] + lazy[lt] == k + 1) ans = (ans + f[i]) % mod;
      }
      sum[lt][v[i]] = (sum[lt][v[i]] - f[i] + mod) % mod, v[i] += val,
      sum[lt][v[i]] = (sum[lt][v[i]] + f[i]) % mod;
    }
  } else {
    for (int i = l; i <= br[lt]; ++i) {
      if (val == 1) {
        if (v[i] + lazy[lt] == k) ans = (ans - f[i] + mod) % mod;
      } else {
        if (v[i] + lazy[lt] == k + 1) ans = (ans + f[i]) % mod;
      }
      sum[lt][v[i]] = (sum[lt][v[i]] - f[i] + mod) % mod, v[i] += val,
      sum[lt][v[i]] = (sum[lt][v[i]] + f[i]) % mod;
    }
    for (int i = bl[rt]; i <= r; ++i) {
      if (val == 1) {
        if (v[i] + lazy[rt] == k) ans = (ans - f[i] + mod) % mod;
      } else {
        if (v[i] + lazy[rt] == k + 1) ans = (ans + f[i]) % mod;
      }
      sum[rt][v[i]] = (sum[rt][v[i]] - f[i] + mod) % mod, v[i] += val,
      sum[rt][v[i]] = (sum[rt][v[i]] + f[i]) % mod;
    }
    for (int i = lt + 1; i <= rt - 1; ++i) {
      if (val == 1)
        ans = (ans - sum[i][k - lazy[i]] + mod) % mod;
      else
        ans = (ans + sum[i][k + 1 - lazy[i]]) % mod;
      lazy[i] += val;
    }
  }
}
inline void Update(int x) {
  sum[col[x + 1]][v[x + 1]] = (sum[col[x + 1]][v[x + 1]] + f[x + 1]) % mod;
  ans = (ans + f[x + 1]) % mod;
}
inline void Solve() {
  ans = 1;
  f[1] = 1;
  sum[1][0] = 1;
  for (int i = 1; i <= n; ++i) {
    ++cnt[a[i]];
    int p(lst[i]), q(lst[p]);
    if (cnt[a[i]] == 1) {
      Modify(1, i, 1);
    } else if (cnt[a[i]] == 2) {
      Modify(p + 1, i, 1);
      Modify(1, p, -1);
    } else {
      Modify(p + 1, i, 1);
      Modify(q + 1, p, -1);
    }
    f[i + 1] = ans;
    Update(i);
  }
  printf("%d", f[n + 1]);
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; ++i) scanf("%d", a + i);
  Fir();
  Solve();
  return 0;
}
