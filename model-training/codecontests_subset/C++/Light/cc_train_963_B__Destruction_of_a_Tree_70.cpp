#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, sumsub[N], deg[N], par[N];
vector<int> adj[N];
bool mark[N];
void des(int v) {
  if (!mark[v]) {
    cout << v + 1 << '\n';
    mark[v] = true;
  }
  for (auto u : adj[v])
    if (!mark[u] && u != par[v]) des(u);
}
void dfs(int v) {
  sumsub[v] = 1;
  for (auto u : adj[v]) {
    if (u != par[v]) {
      par[u] = v;
      dfs(u);
      sumsub[v] += sumsub[u];
    }
  }
  if (sumsub[v] % 2 == 0) des(v);
}
void input() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int v;
    cin >> v;
    if (v) {
      v--;
      adj[i].push_back(v);
      adj[v].push_back(i);
    }
  }
}
void solve() {
  if (n % 2 == 0) cout << "NO", exit(0);
  cout << "YES" << '\n';
  int st = -1;
  for (int i = 0; i < n; i++)
    if (adj[i].size() == 1) st = i;
  if (st == -1) cout << 1 << '\n', exit(0);
  par[st] = -1;
  dfs(st);
  cout << st + 1 << '\n';
}
int main() {
  ios ::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  input(), solve();
}
