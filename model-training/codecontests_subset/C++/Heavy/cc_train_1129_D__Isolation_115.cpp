#include <bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;
inline int Read() {
  int x(0);
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') x = (x << 3) + (x << 1) + c - '0', c = getchar();
  return x;
}
const int maxn = 1e5 + 9, mod = 998244353, maxm = 409;
int n, k, ans;
int a[maxn], cnt[maxn], lst[maxn], fir[maxn], bl[maxm], br[maxm], col[maxn],
    v[maxn], lazy[maxm], f[maxn], sum[maxm][maxn];
inline void Fir() {
  int size(sqrt(n)), pieces(ceil(1.0 * n / size));
  for (int i = 1; i < pieces; ++i) {
    bl[i] = (i - 1) * size + 1;
    br[i] = i * size;
    for (int j = bl[i]; j <= br[i]; ++j) col[j] = i;
  }
  bl[pieces] = (pieces - 1) * size + 1;
  br[pieces] = n;
  for (int j = bl[pieces]; j <= br[pieces]; ++j) col[j] = pieces;
  for (int i = 1; i <= n; ++i) {
    lst[i] = fir[a[i]];
    fir[a[i]] = i;
  }
}
inline void Modify(int l, int r, int val) {
  int lt(col[l]), rt(col[r]);
  if (lt == rt) {
    for (int i = l; i <= r; ++i) {
      if (val == 1)
        (v[i] + lazy[lt] == k) ? ans = (ans - f[i] + mod) % mod : 0;
      else
        (v[i] + lazy[lt] == k + 1) ? ans = (ans + f[i]) % mod : 0;
      sum[lt][v[i]] = (sum[lt][v[i]] - f[i] + mod) % mod, v[i] += val,
      sum[lt][v[i]] = (sum[lt][v[i]] + f[i]) % mod;
    }
  } else {
    for (int i = l; i <= br[lt]; ++i) {
      if (val == 1)
        (v[i] + lazy[lt] == k) ? ans = (ans - f[i] + mod) % mod : 0;
      else
        (v[i] + lazy[lt] == k + 1) ? ans = (ans + f[i]) % mod : 0;
      sum[lt][v[i]] = (sum[lt][v[i]] - f[i] + mod) % mod, v[i] += val,
      sum[lt][v[i]] = (sum[lt][v[i]] + f[i]) % mod;
    }
    for (int i = bl[rt]; i <= r; ++i) {
      if (val == 1)
        (v[i] + lazy[rt] == k) ? ans = (ans - f[i] + mod) % mod : 0;
      else
        (v[i] + lazy[rt] == k + 1) ? ans = (ans + f[i]) % mod : 0;
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
inline void Solve() {
  ans = f[1] = sum[1][0] = 1;
  for (int i = 1; i <= n; ++i) {
    ++cnt[a[i]];
    int p(lst[i]), q(lst[p]);
    if (cnt[a[i]] == 1)
      Modify(1, i, 1);
    else if (cnt[a[i]] == 2) {
      Modify(p + 1, i, 1);
      Modify(1, p, -1);
    } else {
      Modify(p + 1, i, 1);
      Modify(q + 1, p, -1);
    }
    f[i + 1] = ans;
    sum[col[i + 1]][v[i + 1]] = (sum[col[i + 1]][v[i + 1]] + f[i + 1]) % mod;
    ans = (ans + f[i + 1]) % mod;
  }
  printf("%d", f[n + 1]);
}
int main() {
  n = Read();
  k = Read();
  for (int i = 1; i <= n; ++i) a[i] = Read();
  Fir();
  Solve();
  return 0;
}
