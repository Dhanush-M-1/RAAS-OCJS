#include <bits/stdc++.h>
const int MAXN = 100007;
long long MOD;
inline long long FST(long long base, int times) {
  long long ret = 1;
  while (times) {
    if (times & 1) ret = ret * base % MOD;
    times >>= 1;
    base = base * base % MOD;
  }
  return ret;
}
long long seg[MAXN], tot_seg;
long long inv[MAXN], invS[MAXN];
void getSeg(const int &l, const int &r, const int &h) {
  if (h <= 1 || l == r) {
    seg[++tot_seg] = r - l + 1;
    return;
  }
  const int &mid = (l + r) >> 1;
  getSeg(l, mid, h - 1);
  getSeg(mid + 1, r, h - 1);
  return;
}
inline long long calc(long long max_i, long long max_j) {
  long long ret = max_i * max_j % MOD;
  for (int i = 1; i <= max_i; ++i)
    ret = (ret - (invS[i + max_j] - invS[i]) * 2) % MOD;
  return ret;
}
long long buc[2][2];
int main() {
  int n, k;
  scanf("%d%d%I64d", &n, &k, &MOD);
  inv[1] = 1;
  for (int i = 2; i <= n; ++i) inv[i] = inv[i - 1] * i % MOD;
  inv[n] = FST(inv[n], MOD - 2);
  for (int i = n; i > 1; --i) {
    long long tmp_inv = inv[i];
    inv[i] = inv[i - 1] * inv[i] % MOD;
    inv[i - 1] = tmp_inv * i % MOD;
  }
  for (int i = 1; i <= n; ++i) invS[i] = (invS[i - 1] + inv[i]) % MOD;
  inv[2] = FST(2, MOD - 2);
  long long ans = 0;
  getSeg(1, n, k);
  for (int i = 1; i <= tot_seg; ++i) {
    if (!buc[0][0]) buc[0][0] = seg[i];
    if (seg[i] == buc[0][0])
      ++buc[0][1];
    else {
      if (!buc[1][0]) buc[1][0] = seg[i];
      ++buc[1][1];
    }
    ans = (ans + seg[i] * (seg[i] - 1) / 2 % MOD) % MOD;
  }
  for (int i = 0; i < 2; ++i)
    if (buc[i][1] >= 2)
      ans = (ans + calc(buc[i][0], buc[i][0]) *
                       (buc[i][1] * (buc[i][1] - 1) / 2 % MOD) % MOD) %
            MOD;
  if (buc[0][0] && buc[0][1])
    ans = (ans +
           calc(buc[0][0], buc[1][0]) * (buc[1][1] * buc[0][1] % MOD) % MOD) %
          MOD;
  ans = ans * inv[2] % MOD;
  printf("%I64d\n", (ans + MOD) % MOD);
  return 0;
}
