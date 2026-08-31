#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
long long f(string s, long long len) {
  string t;
  for (long long i = s.size() - 1; i >= 0; i--) {
    t = s[i] + t;
    if (len > 0) {
      t = '0' + t;
      len--;
    }
  }
  return stoll(t) % mod;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  long long n;
  cin >> n;
  const long long maxlen = 10;
  vector<vector<long long>> dp(1 + maxlen, vector<long long>(1 + maxlen));
  vector<long long> arr(n), cnt(1 + maxlen, 0);
  vector<string> brr(n);
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
    brr[i] = to_string(arr[i]);
    cnt[brr[i].size()]++;
    for (long long len = 1; len <= maxlen; len++) {
      dp[brr[i].size()][len] += f(brr[i], len - 1) * 10;
      dp[brr[i].size()][len] %= mod;
    }
  }
  long long res = 0;
  for (long long i = 0; i < n; i++) {
    for (long long len = 1; len <= maxlen; len++) {
      res += cnt[len] * f(brr[i], len) + dp[len][brr[i].size()];
      res %= mod;
    }
  }
  cout << res;
  return 0;
}
