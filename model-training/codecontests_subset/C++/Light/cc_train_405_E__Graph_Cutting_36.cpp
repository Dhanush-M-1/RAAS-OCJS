#include <bits/stdc++.h>
using namespace std;
inline void setmin(int &x, int y) {
  if (y < x) x = y;
}
inline void setmax(int &x, int y) {
  if (y > x) x = y;
}
inline void setmin(long long &x, long long y) {
  if (y < x) x = y;
}
inline void setmax(long long &x, long long y) {
  if (y > x) x = y;
}
const int N = 100000;
const int inf = (int)1e9 + 1;
const long long big = (long long)1e18 + 1;
const int P = 239;
const int MOD = (int)1e9 + 7;
const int MOD1 = (int)1e9 + 9;
const double eps = 1e-9;
const double pi = atan2(0, -1);
const int ABC = 26;
vector<int> g[N];
bool used[N];
int height[N];
bool dfs(int u, int p, int h) {
  used[u] = true;
  height[u] = h;
  vector<int> todo;
  for (int v : g[u])
    if (v != p) {
      if (!used[v]) {
        if (dfs(v, u, h + 1)) todo.push_back(v);
      } else if (height[v] < height[u])
        todo.push_back(v);
    }
  bool res = true;
  if ((int)todo.size() % 2 == 1) {
    todo.push_back(p);
    res = false;
  }
  for (int i = 0; i < (int)todo.size() / 2; i++)
    cout << todo[i * 2] + 1 << " " << u + 1 << " " << todo[i * 2 + 1] + 1
         << "\n";
  return res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.precision(20);
  cout << fixed;
  int n, m;
  cin >> n >> m;
  if (m % 2 == 1) {
    cout << "No solution\n";
    return 0;
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--;
    v--;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dfs(0, -1, 0);
  return 0;
}
