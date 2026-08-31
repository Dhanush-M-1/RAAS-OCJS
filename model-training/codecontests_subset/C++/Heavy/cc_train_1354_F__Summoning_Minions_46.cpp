#include <bits/stdc++.h>
using namespace std;
int t, n, k;
long long dp[80][80];
vector<pair<pair<int, int>, int> > v;
long long solve(int i, int rem) {
  if (i == n) {
    if (rem) return -1e15;
    return 0;
  }
  long long &ans = dp[i][rem];
  if (ans != -1) return ans;
  if (rem)
    ans = solve(i + 1, rem - 1) + (k - rem) * v[i].first.first +
          v[i].first.second;
  ans = max(ans, solve(i + 1, rem) + v[i].first.first * (k - 1));
  return ans;
}
vector<int> v1, v2;
void build(int i, int rem) {
  if (i == n) return;
  long long ans1 =
      solve(i + 1, rem - 1) + (k - rem) * v[i].first.first + v[i].first.second;
  long long ans2 = solve(i + 1, rem) + v[i].first.first * (k - 1);
  if (ans1 > ans2) {
    v1.push_back(v[i].second);
    build(i + 1, rem - 1);
    return;
  }
  v2.push_back(v[i].second);
  build(i + 1, rem);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
      int x, y;
      cin >> x >> y;
      v.push_back({{y, x}, i + 1});
    }
    sort(v.begin(), v.end());
    memset(dp, -1, sizeof dp);
    solve(0, k);
    build(0, k);
    cout << v1.size() + v2.size() * 2 << "\n";
    v2.push_back(v1.back());
    v1.pop_back();
    for (auto i : v1) cout << i << " ";
    for (int i = 0; i < v2.size(); i++) {
      if (i == v2.size() - 1)
        cout << v2[i];
      else
        cout << v2[i] << " " << -v2[i] << " ";
    }
    cout << "\n";
    v.clear();
    v1.clear();
    v2.clear();
  }
}
