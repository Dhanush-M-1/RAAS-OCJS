#include <bits/stdc++.h>
using namespace std;
const int maxn = 120;
int w[maxn], v[maxn];
pair<int, int> dp[maxn * maxn];
int main() {
  int n;
  while (scanf("%d", &n) == 1) {
    int sum = 0, need = 0;
    for (int i = 0; i < n; i++) {
      scanf("%d", &v[i]);
      need += v[i];
    }
    for (int i = 0; i < n; i++) {
      scanf("%d", &w[i]);
      sum += w[i];
    }
    for (int i = 0; i <= sum; i++) dp[i] = make_pair(1e9, 0);
    dp[0] = make_pair(0, 0);
    for (int i = 0; i < n; i++) {
      for (int j = sum; j >= w[i]; j--) {
        pair<int, int> tmp = dp[j - w[i]];
        if (dp[j].first > dp[j - w[i]].first + 1) {
          dp[j].first = dp[j - w[i]].first + 1;
          dp[j].second = dp[j - w[i]].second + v[i];
        } else if (dp[j].first == dp[j - w[i]].first + 1) {
          dp[j].second = max(dp[j].second, dp[j - w[i]].second + v[i]);
        }
      }
    }
    pair<int, int> ans;
    ans = make_pair(n, 0);
    for (int i = need; i <= sum; i++) {
      if (dp[i].first < ans.first)
        ans = dp[i];
      else if (dp[i].first == ans.first) {
        ans.second = max(ans.second, dp[i].second);
      }
    }
    printf("%d %d\n", ans.first, need - ans.second);
  }
  return 0;
}
