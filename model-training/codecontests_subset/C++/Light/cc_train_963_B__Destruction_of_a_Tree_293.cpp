#include <bits/stdc++.h>
using namespace std;
const int N = 4e5 + 10;
const int inf = 1e9;
int h[N], e[N], ne[N], idx;
int st[N];
int vis[N], f[N];
vector<int> ans;
int sign;
void add(int a, int b) { e[idx] = b, ne[idx] = h[a], h[a] = idx++; }
void dfs(int u, int fa) {
  int i;
  int cnt = 0;
  for (i = h[u]; i != -1; i = ne[i]) {
    int j = e[i];
    if (j == fa) continue;
    f[j] = u;
    dfs(j, u);
    if (vis[j]) {
      continue;
    } else {
      cnt++;
    }
  }
  if (cnt % 2 && u != 1) {
    vis[u] = 1;
    ans.push_back(u);
  }
  if (u == 1) {
    sign = cnt;
  }
}
void dfs1(int u, int fa) {
  int i;
  for (i = h[u]; i != -1; i = ne[i]) {
    int j = e[i];
    if (j == fa) continue;
    if (vis[f[j]] && !vis[j]) {
      ans.push_back(j);
      vis[j] = 1;
    }
    dfs1(j, u);
  }
}
int main() {
  ios::sync_with_stdio(false);
  memset(h, -1, sizeof h);
  int i;
  int n;
  cin >> n;
  for (i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (x != 0) {
      add(x, i);
      add(i, x);
    }
  }
  dfs(1, 0);
  if (!vis[1] && sign % 2 == 0) {
    ans.push_back(1);
    vis[1] = 1;
  }
  dfs1(1, 0);
  if ((int)ans.size() < n) {
    cout << "NO" << endl;
  } else {
    cout << "YES" << endl;
    for (auto x : ans) {
      cout << x << endl;
    }
  }
  return 0;
}
