#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 105;
const int MOD = 998244353;
long long qpower(long long a, long long b) {
  long long ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % MOD;
    b >>= 1;
    a = a * a % MOD;
  }
  return ans;
}
long long inv(long long n) { return qpower(n, MOD - 2); }
int get_len(int n) {
  int res = 0;
  while (n) {
    n /= 10;
    res++;
  }
  return res;
}
long long get(long long n, int len, int sta) {
  int nl = get_len(n), ml = len;
  long long m = 0;
  if (sta == 1) {
    swap(n, m);
    swap(nl, ml);
  }
  long long ans = 0, p = 1;
  for (int i = 1; i <= min(nl, ml); ++i) {
    ans = (ans + m % 10 * p) % MOD;
    p = p * 10 % MOD;
    ans = (ans + n % 10 * p) % MOD;
    p = p * 10 % MOD;
    n /= 10;
    m /= 10;
  }
  while (n) {
    ans = (ans + n % 10 * p) % MOD;
    p = p * 10 % MOD;
    n /= 10;
  }
  while (m) {
    ans = (ans + m % 10 * p) % MOD;
    p = p * 10 % MOD;
    m /= 10;
  }
  return ans;
}
long long _pre[N][11], cnt[11], _be[N][11];
int a[N], len[N];
void solve() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]), len[i] = get_len(a[i]);
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= 10; ++j) {
      _pre[i][j] = get(a[i], j, 0);
      _be[i][j] = get(a[i], j, 1);
    }
    cnt[len[i]]++;
  }
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= 10; ++j) {
      ans = (ans + cnt[j] * (_pre[i][j] + _be[i][j])) % MOD;
    }
  }
  printf("%lld\n", ans);
}
int main() {
  int _ = 1;
  for (int i = 1; i <= _; ++i) solve();
}
