#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
long long MOD, f[N];
long long qpow(long long x, long long y) {
  long long z = 1;
  while (y > 0) {
    if (y % 2) z = z * x % MOD;
    x = x * x % MOD;
    y /= 2;
  }
  return z;
}
map<int, int> ma;
pair<int, int> a[10];
void dfs(int x, int k) {
  if (k == 1 || x == 1) {
    ma[x]++;
    return;
  }
  dfs((x + 1) / 2, k - 1);
  dfs(x / 2, k - 1);
}
int main() {
  int n, k;
  scanf("%d%d%lld", &n, &k, &MOD);
  dfs(n, k);
  for (int i = 1; i <= n * 2; i++)
    f[i] = (f[i - 1] - qpow(i, MOD - 2) + qpow(2, MOD - 2) + MOD) % MOD;
  int cnt = 0;
  for (auto p : ma) {
    a[++cnt] = p;
  }
  long long ans = 0;
  for (int i = 1; i <= cnt; i++) {
    ans += 1LL * a[i].second * a[i].first % MOD * (a[i].first - 1) % MOD *
           qpow(4, MOD - 2) % MOD;
    long long sum = 0;
    for (int j = 1; j <= a[i].first; j++) {
      sum = (sum + f[j + a[i].first] - f[j] + MOD) % MOD;
    }
    ans += sum * a[i].second % MOD * (a[i].second - 1) % MOD *
           qpow(2, MOD - 2) % MOD;
  }
  if (cnt == 2) {
    long long sum = 0;
    for (int j = 1; j <= a[1].first; j++) {
      sum = (sum + f[j + a[2].first] - f[j] + MOD) % MOD;
    }
    ans += sum * a[1].second % MOD * a[2].second % MOD;
  }
  printf("%lld", ans % MOD);
  return 0;
}
