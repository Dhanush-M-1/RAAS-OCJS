#include <bits/stdc++.h>
using namespace std;
int n, k;
int p[1000005];
int dp[1000005];
int cnt[1000005];
int ans[1000005];
vector<int> v[1000005];
void dfs0(int x) {
  ans[x] = dp[x];
  int tmp = 0;
  for (auto y : v[x]) {
    dfs0(y);
    tmp = max(tmp, ans[y]);
  }
  ans[x] += tmp;
}
void dfs(int x) {
  if (v[x].empty()) {
    dp[x] = 1;
    cnt[x] = k;
    return;
  }
  int ma = 0;
  for (auto y : v[x]) {
    dfs(y);
    ma = max(ma, cnt[y]);
    if (cnt[y] >= 1) {
      dp[x] += dp[y];
      dp[y] = 0;
    }
  }
  cnt[x] = max(0, ma - 1);
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &p[i]);
    v[p[i]].push_back(i);
  }
  dfs(1);
  dfs0(1);
  cout << ans[1] << endl;
  return 0;
}
