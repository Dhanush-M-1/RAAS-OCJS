#include <bits/stdc++.h>
using namespace std;
long long t, n, k, dp[80][80];
pair<pair<long long, long long>, long long> v[100];
long long f(int pos, long long num) {
  if (dp[pos][num] != -1) return dp[pos][num];
  if (pos == n) {
    if (num != k)
      return dp[pos][num] = -1000000000000000;
    else
      return dp[pos][num] = 0;
  }
  long long res = -1000000000000000;
  res = max(res, f(pos + 1, num) + v[pos].first.first * (k - 1ll));
  if (num < k) {
    res = max(res, f(pos + 1, num + 1) + v[pos].first.first * num +
                       v[pos].first.second);
  }
  return dp[pos][num] = res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> t;
  while (t--) {
    memset(dp, -1, sizeof(dp));
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
      cin >> v[i].first.second >> v[i].first.first;
      v[i].second = i + 1;
    }
    sort(v, v + n);
    f(0, 0);
    int pos = 0, num = 0;
    vector<int> us, notus;
    while (pos < n) {
      if (dp[pos + 1][num] != -1 &&
          dp[pos + 1][num] + v[pos].first.first * (k - 1ll) == dp[pos][num]) {
        notus.push_back(v[pos].second);
      } else {
        us.push_back(v[pos].second);
        num++;
      }
      pos++;
    }
    cout << us.size() + notus.size() * 2 << "\n";
    for (int i = 0; (i + 1) < us.size(); i++) {
      cout << us[i] << " ";
    }
    for (auto i : notus) cout << i << " " << -i << " ";
    cout << us[us.size() - 1] << "\n";
  }
  return 0;
}
