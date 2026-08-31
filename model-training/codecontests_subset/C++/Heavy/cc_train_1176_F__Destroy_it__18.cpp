#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n;
long long dp[N][10];
vector<pair<int, int>> v[N];
long long solve(int idx, int pre) {
  if (idx == n) return 0;
  long long &ans = dp[idx][pre];
  if (~ans) return ans;
  ans = 0;
  ans = max(ans, solve(idx + 1, pre));
  int sz = v[idx].size();
  for (int i = 0; i < sz; i++) {
    long long cur = 0, curPre = pre;
    if (curPre == 0) {
      cur += 2 * v[idx][i].second;
    } else
      cur += v[idx][i].second;
    curPre = (curPre + 1) % 10;
    ans = max(ans, solve(idx + 1, curPre) + cur);
  }
  for (int i = 0; i < sz; i++) {
    for (int j = 0; j < sz; j++) {
      if (i == j || v[idx][i].first + v[idx][j].first > 3) continue;
      long long cur = 0, curPre = pre;
      if (curPre == 0)
        cur += 2 * v[idx][i].second;
      else
        cur += v[idx][i].second;
      curPre = (curPre + 1) % 10;
      if (curPre == 0)
        cur += 2 * v[idx][j].second;
      else
        cur += v[idx][j].second;
      curPre = (curPre + 1) % 10;
      ans = max(ans, solve(idx + 1, curPre) + cur);
    }
  }
  for (int i = 0; i < sz; i++) {
    for (int j = 0; j < sz; j++) {
      if (i == j || v[idx][i].first + v[idx][j].first >= 3) continue;
      for (int k = 0; k < sz; k++) {
        if (k == i || k == j ||
            v[idx][i].first + v[idx][j].first + v[idx][k].first > 3)
          continue;
        long long cur = 0;
        long long curPre = pre;
        if (curPre == 0)
          cur += 2 * v[idx][i].second;
        else
          cur += v[idx][i].second;
        curPre = (curPre + 1) % 10;
        if (curPre == 0)
          cur += 2 * v[idx][j].second;
        else
          cur += v[idx][j].second;
        curPre = (curPre + 1) % 10;
        if (curPre == 0)
          cur += 2 * v[idx][k].second;
        else
          cur += v[idx][k].second;
        curPre = (curPre + 1) % 10;
        ans = max(ans, solve(idx + 1, curPre) + cur);
      }
    }
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    vector<int> g[4];
    for (int j = 0; j < k; j++) {
      int c, d;
      cin >> c >> d;
      g[c].push_back(d);
    }
    for (auto &x : g) sort(x.rbegin(), x.rend());
    for (int j = 0; j < 3; j++) {
      if (j >= g[1].size()) break;
      v[i].push_back({1, g[1][j]});
    }
    if (g[2].size() >= 1) v[i].push_back({2, g[2][0]});
    if (g[3].size() >= 1) v[i].push_back({3, g[3][0]});
  }
  memset(dp, -1, sizeof dp);
  cout << solve(0, 1);
  return 0;
}
