#include <bits/stdc++.h>
using namespace std;
const int maxn = 100020;
bool ok[maxn];
int h[maxn];
bool mark[maxn];
vector<int> adj[maxn];
void dfs(int v, int par) {
  mark[v] = 1;
  vector<int> can;
  for (int i = 0; i < adj[v].size(); i++) {
    int u = adj[v][i];
    if (mark[u] != 1) {
      h[u] = h[v] + 1;
      dfs(u, v);
      if (ok[u] != true) {
        can.push_back(u);
      }
    } else if (u != par && h[u] < h[v]) {
      can.push_back(u);
    }
  }
  if (can.size() % 2 != 0) {
    can.push_back(par);
    ok[v] = true;
  }
  for (int i = 0; i < can.size() / 2; i++) {
    cout << can[2 * i] << " " << v << " " << can[2 * i + 1];
    cout << endl;
  }
}
int main() {
  int n, m;
  cin >> n >> m;
  if (m % 2 != 0) {
    cout << "No solution";
    return 0;
  }
  int x, y;
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    adj[x].push_back(y);
    adj[y].push_back(x);
  }
  dfs(1, -1);
}
