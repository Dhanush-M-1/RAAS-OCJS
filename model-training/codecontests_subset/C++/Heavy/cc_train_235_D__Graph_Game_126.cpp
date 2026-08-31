#include <bits/stdc++.h>
using namespace std;
const int N = 3005;
int n, stk[N], top, num[N], cyc[N], idx;
bool vis[N], instk[N], fl;
vector<int> v[N];
void dfs(int pos, int fa) {
  stk[++top] = pos;
  instk[pos] = 1;
  for (auto &i : v[pos]) {
    if (i == fa) continue;
    if (!instk[i]) return dfs(i, pos);
    if (fl) continue;
    fl = 1;
    while (1) {
      int cur = stk[top--];
      cyc[++idx] = cur;
      num[cur] = idx;
      if (cur == i) break;
    }
  }
  --top;
  instk[pos] = 0;
}
int rt[N], dep[N];
void dfs(int pos, int fa, int root) {
  rt[pos] = root;
  dep[pos] = dep[fa] + 1;
  for (auto &i : v[pos])
    if (i != fa && !num[i]) dfs(i, pos, root);
}
int root;
double ans;
void solve(int pos, int d) {
  vis[pos] = 1;
  if (rt[pos] == rt[root])
    ans += 1.0 / d;
  else {
    int x = dep[root] + dep[pos], y = abs(num[rt[pos]] - num[rt[root]]) - 1,
        z = idx - 2 - y;
    ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
  }
  for (auto &i : v[pos])
    if (!vis[i]) solve(i, d + 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  int t1, t2;
  for (int i = 1; i <= n; i++)
    cin >> t1 >> t2, ++t1, ++t2, v[t1].push_back(t2), v[t2].push_back(t1);
  dfs(1, 0);
  for (int i = 1; i <= idx; i++) dfs(cyc[i], 0, cyc[i]);
  cout << endl;
  for (int i = 1; i <= n; i++)
    memset(vis, 0, sizeof(vis)), root = i, solve(i, 1);
  printf("%.8lf\n", ans);
  return 0;
}
