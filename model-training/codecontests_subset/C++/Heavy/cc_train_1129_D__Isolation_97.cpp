#include <bits/stdc++.h>
using namespace std;
const int mn = 1e5, msq = 317, mod = 998244353;
int n, sq, k, a[mn + 3];
int inp[mn + 3], lw[msq + 3], rw[msq + 3];
int num[mn + 3];
int topw[mn + 3], secw[mn + 3];
long long f[mn + 3];
long long Sumf[msq + 3][2 * msq + 3];
int add[msq + 3];
void Add(int l, int r, int ad) {
  l--;
  r++;
  if (inp[l] >= inp[r]) {
    register int p = inp[l];
    for (register int i = l + 1; i <= r - 1; i++) {
      if (ad == 1)
        Sumf[p][num[i]] -= f[i - 1];
      else
        Sumf[p][num[i] - 1] += f[i - 1];
      num[i] += ad;
    }
    return;
  }
  register int p = inp[l];
  for (register int i = l + 1; i <= rw[p]; i++) {
    if (ad == 1)
      Sumf[p][num[i]] -= f[i - 1];
    else
      Sumf[p][num[i] - 1] += f[i - 1];
    num[i] += ad;
  }
  for (p = inp[l] + 1; p <= inp[r] - 1; p++) add[p] += ad;
  p = inp[r];
  for (register int i = lw[p]; i <= r - 1; i++) {
    if (ad == 1)
      Sumf[p][num[i]] -= f[i - 1];
    else
      Sumf[p][num[i] - 1] += f[i - 1];
    num[i] += ad;
  }
}
int main() {
  cin >> n >> k;
  sq = sqrt(n);
  for (int i = 1; i <= n; i++) scanf("%d", a + i);
  int totp = 0;
  for (int i = 1; i <= n; i++) {
    if ((i - 1) % sq == 0) lw[++totp] = i;
    if (i % sq == 0 || i == n) rw[totp] = i;
    inp[i] = totp;
  }
  inp[n + 1] = ++totp;
  lw[totp] = rw[totp] = n + 1;
  f[0] = 1;
  for (register int i = 1; i <= n; i++) {
    for (int nu = 0; nu <= 2 * sq; nu++) Sumf[inp[i]][nu] += f[i - 1];
    Add(topw[a[i]] + 1, i, 1);
    if (topw[a[i]]) Add(secw[a[i]] + 1, topw[a[i]], -1);
    for (register int p = 1; p < inp[i]; p++)
      if (add[p] <= k) f[i] += Sumf[p][min(2 * sq, k - add[p])], f[i] %= mod;
    register int p = inp[i];
    for (register int w = lw[p]; w <= i; w++)
      if (num[w] + add[p] <= k) f[i] += f[w - 1], f[i] %= mod;
    f[i] = (f[i] + mod) % mod;
    secw[a[i]] = topw[a[i]];
    topw[a[i]] = i;
  }
  cout << f[n];
  return 0;
}
