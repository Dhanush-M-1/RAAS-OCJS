#include <bits/stdc++.h>
using namespace std;
vector<int> t[1000000];
int dp[1000000];
int up[1000000];
int val[1000000];
int n, k;
void dfs(int cur, int h) {
  for (int i = 0; i < t[cur].size(); i++) dfs(t[cur][i], h + 1);
  if (t[cur].size() == 0) {
    up[cur] = max(0, h - k);
    val[cur] = 1;
    dp[cur] = 1;
  } else {
    int all = 0;
    up[cur] = h;
    for (int i = 0; i < t[cur].size(); i++) {
      up[cur] = min(up[cur], up[t[cur][i]]);
      if (up[t[cur][i]] <= h) val[cur] += val[t[cur][i]];
    }
    for (int i = 0; i < t[cur].size(); i++) {
      int mm = 0;
      if (up[t[cur][i]] <= h) mm = val[t[cur][i]];
      dp[cur] = max(dp[cur], val[cur] - mm + dp[t[cur][i]]);
    }
  }
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 0; i < n; i++) up[i] = 2000000000;
  for (int i = 0; i < n - 1; i++) {
    int tmp;
    scanf("%d", &tmp);
    t[tmp - 1].push_back(i + 1);
  }
  dfs(0, 0);
  printf("%d\n", dp[0]);
  return 0;
}
