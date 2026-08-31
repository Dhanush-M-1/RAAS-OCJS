#include <bits/stdc++.h>
using namespace std;
int dp[200100];
pair<int, int> a[200100];
int main(void) {
  int n;
  dp[1] = 1;
  dp[2] = 1;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i].first >> a[i].second;
  for (int i = 3; i < 2 * n; i += 2) {
    int ptr = (i + 1) / 2;
    if (((long long)a[ptr].first - a[ptr].second) >
        ((long long)a[ptr - 1].first + a[ptr - 1].second))
      dp[i] = dp[i - 1] + 1;
    else if (((long long)a[ptr].first - a[ptr].second) >
             (long long)a[ptr - 1].first)
      dp[i] = max(dp[i - 1], dp[i - 2] + 1);
    else if ((long long)a[ptr].first >
             ((long long)a[ptr - 1].first + a[ptr - 1].second))
      dp[i] = dp[i - 1];
    else
      dp[i] = dp[i - 2];
    if ((long long)a[ptr].first >
        ((long long)a[ptr - 1].first + a[ptr - 1].second))
      dp[i + 1] = max(dp[i - 1] + 1, dp[i - 2] + 1);
    else
      dp[i + 1] = dp[i - 2] + 1;
  }
  cout << dp[2 * n];
  return 0;
}
