#include <bits/stdc++.h>
using namespace std;
bool comp(const pair<int, int>& a, const pair<int, int>& b) {
  if (a.second != b.second) {
    return a.second > b.second;
  }
  return false;
}
const int inf = 1e9;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int> > v(n);
  int x = 0;
  for (int i = 0; i < n; ++i) {
    cin >> v[i].first;
    x += v[i].first;
  }
  for (int i = 0; i < n; ++i) {
    cin >> v[i].second;
  }
  sort((v).begin(), (v).end(), comp);
  int k = 0;
  while (x > 0) {
    x -= v[k].second;
    ++k;
  }
  x = 0;
  for (int i = 0; i < n; ++i) {
    x += v[i].first;
  }
  cout << k << " ";
  vector<vector<int> > dp(x + 1, vector<int>(k + 1, -inf));
  dp[0][0] = 0;
  for (int i = 0; i < n; ++i) {
    vector<vector<int> > dp_new = dp;
    for (int sum = 0; sum <= x; ++sum) {
      for (int taken = 0; taken <= k; ++taken) {
        int new_sum = min(x, sum + v[i].second);
        if (taken + 1 <= k) {
          dp_new[new_sum][taken + 1] =
              max(dp_new[new_sum][taken + 1], dp[sum][taken] + v[i].first);
        }
      }
    }
    dp.swap(dp_new);
  }
  cout << x - dp[x][k] << "\n";
}
