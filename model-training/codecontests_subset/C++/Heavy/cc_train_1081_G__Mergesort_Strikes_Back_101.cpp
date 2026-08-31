#include <bits/stdc++.h>
template <typename T>
inline void read(T &x) {
  x = 0;
  char c = getchar();
  while (!isdigit(c)) c = getchar();
  while (isdigit(c)) x = x * 10 + (c ^ 48), c = getchar();
}
using namespace std;
int n, K, P;
long long inv[201000], isum[201000];
inline void init() {
  inv[1] = 1;
  for (int i = 2; i <= max(n, 20); ++i)
    inv[i] = ((P - inv[P % i] * (P / i)) % P + P) % P;
  for (int i = 1; i <= max(n, 20); ++i) isum[i] = (isum[i - 1] + inv[i]) % P;
}
int tmp, cnt[201000];
void dfs_find(int L, int R, int nwk) {
  if (nwk == 1) {
    ++cnt[R - L + 1];
    tmp = R - L + 1;
    return;
  }
  if (L == R) {
    ++cnt[1];
    tmp = 1;
    return;
  }
  int mid = (L + R) >> 1;
  dfs_find(L, mid, nwk - 1);
  dfs_find(mid + 1, R, nwk - 1);
}
inline long long sol(int t, int tt) {
  long long res = 0;
  for (int i = 1; i <= t; ++i) {
    res += isum[i + tt] - isum[i];
  }
  return (res % P + P) % P;
}
int main() {
  read(n), read(K), read(P);
  init();
  if (K >= 30) {
    puts("0");
    return 0;
  }
  dfs_find(1, n, K);
  int jzp, zzz;
  if (cnt[tmp - 1]) {
    jzp = tmp, zzz = tmp - 1;
  } else {
    jzp = tmp + 1, zzz = tmp;
  }
  int inv2 = inv[2];
  long long ans = sol(jzp, jzp) * cnt[jzp] % P * (cnt[jzp] - 1) % P * inv2 % P;
  ans =
      (ans + sol(zzz, zzz) * cnt[zzz] % P * (cnt[zzz] - 1) % P * inv2 % P) % P;
  ans = (ans + sol(jzp, zzz) * cnt[jzp] % P * cnt[zzz] % P) % P;
  ans = 1ll * n * (n - 1) % P * inv[4] % P - ans;
  printf("%lld\n", (ans % P + P) % P);
  return 0;
}
