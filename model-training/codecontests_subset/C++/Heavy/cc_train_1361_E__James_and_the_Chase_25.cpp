#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const int K = 70;
int n, m;
vector<int> v[N];
int h[N];
bool dfs_check(int x) {
  h[x] = 1;
  for (auto u : v[x]) {
    if (!h[u]) {
      if (!dfs_check(u)) return 0;
    } else if (h[u] == 1) {
    } else if (h[u] == 2) {
      return 0;
    }
  }
  h[x] = 2;
  return 1;
}
int tick;
int st[N];
int back[N], top1[N], top2[N];
void upgrade(int x, int u) {
  if (top1[x] == -1 or st[u] < st[top1[x]]) {
    top2[x] = top1[x];
    top1[x] = u;
  } else if (top2[x] == -1 or st[u] < st[top2[x]])
    top2[x] = u;
}
void dfs(int x) {
  st[x] = ++tick;
  h[x] = 1;
  for (auto u : v[x]) {
    assert(h[u] <= 1);
    if (!h[u]) {
      dfs(u);
      if (top1[u] != -1) upgrade(x, top1[u]);
      if (top2[u] != -1) upgrade(x, top2[u]);
    } else if (h[u] == 1) {
      upgrade(x, u);
    }
  }
  h[x] = 2;
}
int dp[N];
void dfs_solve(int x) {
  if (top1[x] != -1 and st[top1[x]] <= st[x]) {
    if (top2[x] == -1 or st[top2[x]] >= st[x]) {
      dp[x] = (top1[x] == -1 or top1[x] == x ? 1 : dp[top1[x]]);
    } else {
      dp[x] = 0;
    }
  } else {
    dp[x] = 1;
  }
  h[x] = 1;
  for (auto u : v[x]) {
    if (!h[u]) {
      dfs_solve(u);
    }
  }
}
void solve() {
  srand(time(0));
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    v[i].clear();
  }
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    v[x].push_back(y);
  }
  int root = -1;
  for (int it = 0; it < K; it++) {
    int x = (long long)rand() * rand() % n + 1;
    for (int i = 1; i <= n; i++) {
      h[i] = 0;
    }
    if (dfs_check(x)) {
      root = x;
      break;
    }
  }
  if (root == -1) {
    puts("-1");
    return;
  }
  for (int i = 1; i <= n; i++) {
    h[i] = 0;
    back[i] = 0;
    st[i] = 0;
    top1[i] = top2[i] = -1;
  }
  tick = 0;
  dfs(root);
  for (int i = 1; i <= n; i++) {
    h[i] = 0;
    dp[i] = 0;
  }
  dp[root] = 1;
  dfs_solve(root);
  vector<int> ans;
  for (int i = 1; i <= n; i++) {
    if (dp[i]) {
      ans.push_back(i);
    }
  }
  if (ans.size() * 5 < n) {
    puts("-1");
  } else {
    for (auto x : ans) {
      printf("%d ", x);
    }
    puts("");
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
