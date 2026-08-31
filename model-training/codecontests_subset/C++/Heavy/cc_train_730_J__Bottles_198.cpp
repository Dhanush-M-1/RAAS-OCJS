#include <bits/stdc++.h>
using namespace std;
pair<int, int> dp[20001];
pair<int, int> dp_copy[20001];
int a[100];
int b[100];
void copy_dp() {
  for (int i = -10000; i <= 10000; i++) {
    dp_copy[i + 10000] = dp[i + 10000];
    dp[i + 10000] = make_pair(1e9, 1e9);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  int t;
  for (int i = 0; i < n; i++) scanf("%d", &t), a[i] = t;
  for (int i = 0; i < n; i++) scanf("%d", &t), b[i] = t;
  copy_dp();
  dp[0 + 10000] = make_pair(0, 0);
  for (int i = 0; i < n; i++) {
    copy_dp();
    for (int j = -10000 + a[i]; j <= 10000; j++)
      dp[j - a[i] + 10000] = min(dp[j - a[i] + 10000],
                                 make_pair(dp_copy[j + 10000].first,
                                           dp_copy[j + 10000].second + a[i]));
    for (int j = -10000; j <= 10000; j++)
      dp[j + b[i] - a[i] + 10000] = min(
          dp[j + b[i] - a[i] + 10000],
          make_pair(dp_copy[j + 10000].first + 1, dp_copy[j + 10000].second));
  }
  pair<int, int> res_min = make_pair(1e9, 1e9);
  for (int i = 0; i <= 10000; i++) res_min = min(dp[i + 10000], res_min);
  printf("%d %d\n", res_min.first, res_min.second);
  return 0;
}
