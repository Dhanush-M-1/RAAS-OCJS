#include <bits/stdc++.h>
using namespace std;
constexpr int N = 1e6 + 10;
constexpr int MOD = 998244353;
long long n, a[N], ans, sum[20][20], pw[30], cnt[20];
vector<int> v[20];
int len(long long x) {
  int ret = 0;
  while (x) {
    ret++;
    x /= 10;
  }
  return ret;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  pw[0] = 1;
  for (int i = 1; i < 30; i++) pw[i] = (pw[i - 1] * 10) % MOD;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    v[len(a[i])].push_back(a[i]);
    cnt[len(a[i])]++;
  }
  for (int i = 1; i <= 10; i++) {
    for (auto j : v[i]) {
      long long val = j;
      for (int k = 0; k < i; k++) {
        sum[i][k] += (val % 10);
        val /= 10;
      }
    }
  }
  for (int i = 0; i < 20; i++) {
    for (int j = 1; j <= 10; j++) {
      for (int k = 1; k <= 10; k++) {
        if ((j + k - 1) >= i) {
          long long kochike = min(j, k);
          if (i + 1 <= (2 * kochike)) {
            long long kodom = i / 2;
            if (i & 1) {
              ans += ((pw[i] * sum[j][kodom] % MOD) * cnt[k]) % MOD;
              ans %= MOD;
            } else {
              ans += ((pw[i] * sum[k][kodom] % MOD) * cnt[j]) % MOD;
              ans %= MOD;
            }
          } else {
            long long kodom = i - kochike;
            if (kochike == j) {
              ans += ((pw[i] * sum[k][kodom] % MOD) * cnt[j]) % MOD;
              ans %= MOD;
            } else {
              ans += ((pw[i] * sum[j][kodom] % MOD) * cnt[k]) % MOD;
              ans %= MOD;
            }
          }
        }
      }
    }
  }
  cout << ans << '\n';
  return 0;
}
