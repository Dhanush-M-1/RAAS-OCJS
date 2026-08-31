#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:102400000,102400000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
const int maxn = 2e5 + 5;
vector<int> a[maxn];
int dp[maxn];
int vis[maxn];
vector<int> ans;
void getans(int t, int pre) {
  if (vis[t]) return;
  vis[t] = 1;
  ans.push_back(t);
  for (auto it : a[t]) {
    if (it == pre) continue;
    getans(it, t);
  }
}
int dfs(int t, int pre) {
  int flag = 0;
  if (pre != -1 && a[t].size() == 1) {
    dp[t] = 1;
    return 1;
  }
  int cnt = 0;
  for (auto it : a[t]) {
    if (it == pre) continue;
    dfs(it, t);
    if (dp[it] == 1) cnt++;
  }
  if (pre != -1) cnt++;
  if (cnt & 1) {
    dp[t] = 1;
    return 1;
  } else {
    dp[t] = 0;
    getans(t, pre);
    return 0;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int i, j, k, m, n;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> k;
    if (k == 0) continue;
    a[i].push_back(k);
    a[k].push_back(i);
  }
  int t = dfs(1, -1);
  getans(1, -1);
  if (t == 1) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  for (auto it : ans) cout << it << " ";
  return 0;
}
