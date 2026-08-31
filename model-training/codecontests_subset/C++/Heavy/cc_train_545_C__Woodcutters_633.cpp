#include <bits/stdc++.h>
using namespace std;
void solve();
template <class T, class... U>
void pr(T&& a, U&&... b) {
  cout << forward<T>(a);
  (int[]){(cout << " " << forward<U>(b), 0)...};
  cout << "\n";
}
template <class T, class... U>
void re(T&& a, U&&... b) {
  cin >> forward<T>(a);
  (int[]){(cin >> forward<U>(b), 0)...};
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  cerr << "time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs" << endl;
  return 0;
}
void solve() {
  int n;
  int dp[100001][3];
  vector<pair<long long, long long>> trees;
  re(n);
  for (int i = 0; i < n; i++) {
    long long x, h;
    re(x, h);
    trees.push_back({x, h});
  }
  memset(dp, 0, sizeof(dp));
  dp[0][1] = 1;
  dp[0][2] = 1;
  for (int i = 1; i < n; i++) {
    for (int j = 0; j < 3; j++) {
      long long pre_x, pre_h;
      pre_x = trees[i - 1].first;
      pre_h = trees[i - 1].second;
      int c = (trees[i].first <= pre_x + pre_h) ? 0 : dp[i - 1][2];
      dp[i][0] = max(max(dp[i - 1][0], dp[i - 1][1]), c);
      dp[i][2] = dp[i][0] + 1;
      int a = (trees[i].first - trees[i].second <= pre_h + pre_x)
                  ? 0
                  : dp[i - 1][2];
      if (trees[i].first - trees[i].second <= pre_x)
        dp[i][1] = 0;
      else {
        dp[i][1] = max(max(dp[i - 1][0], dp[i - 1][1]), a) + 1;
      }
    }
  }
  pr(max(max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
}
