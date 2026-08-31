#include <bits/stdc++.h>
using namespace std;
struct Tree {
  vector<int> child;
};
int ans[1000005] = {0};
long deep[1000005];
void dfs(int x, Tree t[], int dp[], int k) {
  int temp = 0;
  if (t[x].child.size() == 0) {
    dp[x] = 1;
    deep[x] = 0;
    return;
  }
  for (int i : t[x].child) {
    dfs(i, t, dp, k);
    if (deep[i] < k) dp[x] += dp[i];
    temp = max(temp, ans[i] - (deep[i] < k ? dp[i] : 0));
    deep[x] = min(deep[x], deep[i] + 1);
  }
  ans[x] = dp[x] + temp;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long n;
  long k;
  cin >> n >> k;
  fill(deep, deep + n + 1, 1000000);
  Tree t[n + 1];
  int dp[n + 1];
  fill(dp, dp + n + 1, 0);
  for (long i = 2; i < n + 1; i++) {
    long p;
    cin >> p;
    t[p].child.push_back(i);
  }
  dfs(1, t, dp, k);
  cout << ans[1] << endl;
  return 0;
}
