#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 7;
const int BASE = 1e9 + 7;
const int dx[4] = {-1, 1, 0, 0};
const int dy[4] = {0, 0, -1, 1};
const int N = 1e5 + 1;
vector<int> a[N];
int pa[N], n;
int F[N];
void DFS(int p, int u) {
  bool Check = true;
  for (__typeof(a[u].begin()) it = a[u].begin(); it != a[u].end(); it++) {
    int v = *it;
    if (v == p) continue;
    Check = false;
    DFS(u, v);
    pa[v] = u;
    F[u] = F[u] + F[v];
  }
  F[u] += Check;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  int u, v;
  for (int i = 1; i < n; i++) {
    cin >> u >> v;
    a[u].push_back(v);
    a[v].push_back(u);
  }
  bool Check = true;
  for (int u = 1; u <= n; u++) {
    for (__typeof(a[u].begin()) it = a[u].begin(); it != a[u].end(); it++) {
      int v = *it;
      if (a[u].size() == 1) {
        if (a[v].size() == 1) continue;
        if (a[v].size() < 3) {
          Check = false;
        }
      } else if (a[v].size() == 1) {
        if (a[u].size() == 1) continue;
        if (a[u].size() < 3) {
          Check = false;
        }
      } else {
        if (a[v].size() < 3 || a[u].size() < 3) {
          Check = false;
        }
      }
    }
  }
  cout << (Check ? "YES" : "NO");
}
