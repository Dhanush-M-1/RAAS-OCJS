#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e3 + 10;
int a[maxn], n, x;
bool mark[maxn];
vector<int> v;
int can[maxn][maxn], x_bood, pos_x;
vector<int> adj[maxn];
int dfs_visit(int v, int cnt) {
  if (!v) return 0;
  if (v == x) x_bood = cnt + 1;
  mark[v] = 1;
  for (int i = 0; i < adj[v].size(); i++)
    if (!mark[adj[v][i]]) return 1 + dfs_visit(adj[v][i], cnt + 1);
  return 1;
}
void dfs() {
  for (int i = 1; i <= n; i++)
    if (!mark[i] && !a[i - 1]) {
      int tmp = dfs_visit(i, 0);
      if (!x_bood)
        v.push_back(tmp);
      else {
        pos_x = x_bood;
        x_bood = 0;
      }
    }
}
void input() {
  cin >> n >> x;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i]) {
      adj[i + 1].push_back(a[i]);
      adj[a[i]].push_back(i + 1);
    }
  }
  dfs();
}
void knap() {
  for (int i = 0; i <= n; i++) can[0][i] = 1;
  for (int j = 1; j <= v.size(); j++) {
    for (int i = 1; i <= n; i++) {
      if (can[i][j - 1]) {
        can[i][j] = 1;
      } else if (i >= v[j - 1] && can[i - v[j - 1]][j - 1]) {
        can[i][j] = 1;
      }
    }
  }
}
void solve() {
  for (int i = 0; i <= n; i++)
    if (can[i][v.size()]) cout << i + pos_x << endl;
}
int main() {
  input();
  knap();
  solve();
}
