#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 3;
int n, k;
vector<int> AdjList[maxn];
int die[maxn];
int cnt[maxn];
int ans[maxn];
const int inf = 1e9 + 7;
void dfs(int st) {
  die[st] = inf;
  for (int u : AdjList[st]) {
    dfs(u);
    cnt[st] += cnt[u];
    die[st] = min(die[st], die[u] + 1);
    ans[st] = max(ans[st], ans[u] - cnt[u]);
  }
  ans[st] += cnt[st];
  if (die[st] == inf) {
    die[st] = 0;
    ans[st] = cnt[st] = 1;
  }
  if (die[st] >= k) cnt[st] = 0;
}
signed main() {
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int p;
    cin >> p;
    AdjList[p].push_back(i);
  }
  dfs(1);
  cout << ans[1];
}
