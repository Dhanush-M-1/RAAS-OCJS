#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(chrono::steady_clock::now().time_since_epoch().count());
const int N = 100005;
vector<int> g[N];
int col[N];
bool intrest(int v) {
  col[v] = 1;
  bool ok = 1;
  for (int to : g[v]) {
    if (col[to] == 0) {
      ok &= intrest(to);
    } else if (col[to] == 2) {
      return 0;
    }
    if (!ok) break;
  }
  col[v] = 2;
  return ok;
}
int low[N];
int tin[N];
int cup[N];
int root;
vector<int> ord;
bool good[N];
void find(int v) {
  col[v] = 1;
  tin[v] = (int)ord.size();
  ord.push_back(v);
  low[v] = tin[v];
  cup[v] = 0;
  for (int to : g[v]) {
    if (col[to] == 0) {
      find(to);
      low[v] = min(low[v], low[to]);
      cup[v] += cup[to];
    } else if (col[to] == 1) {
      low[v] = min(low[v], tin[to]);
      --cup[to];
      ++cup[v];
    } else {
      throw;
    }
  }
  col[v] = 2;
}
void mark(int v) {
  col[v] = 1;
  if (cup[v] == 1) {
    good[v] = good[ord[low[v]]];
  }
  for (int to : g[v]) {
    if (col[to] == 0) {
      mark(to);
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int tt;
  cin >> tt;
  while (tt--) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) g[i].clear(), good[i] = 0;
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;
      --x;
      --y;
      g[x].push_back(y);
    }
    root = -1;
    for (int i = 0; i < 50; i++) {
      for (int i = 0; i < n; i++) col[i] = 0;
      int x = rnd() % n;
      if (intrest(x)) {
        root = x;
        break;
      }
    }
    if (root == -1) {
      cout << -1 << '\n';
      continue;
    }
    ord.clear();
    for (int i = 0; i < n; i++) col[i] = 0;
    good[root] = 1;
    find(root);
    for (int i = 0; i < n; i++) col[i] = 0;
    mark(root);
    int cnt = accumulate(good, good + n, 0);
    if (5 * cnt < n) {
      cout << -1 << '\n';
    } else {
      for (int i = 0; i < n; i++) {
        if (good[i]) {
          cout << i + 1 << ' ';
          good[i] = 0;
        }
      }
      cout << '\n';
    }
  }
  return 0;
}
