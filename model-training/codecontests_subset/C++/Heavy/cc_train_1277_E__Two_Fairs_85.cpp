#include <bits/stdc++.h>
using namespace std;
template <class T>
using v2d = vector<vector<T> >;
template <class T>
bool uin(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
mt19937 rng(chrono::system_clock::now().time_since_epoch().count());
const int maxN = 2e5 + 10;
const int maxM = 5e5 + 10;
int n, m, a, b;
vector<int> adj[maxN];
int fa[maxN], fb[maxN];
long long ca = 0, cb = 0;
void DFSa(int u) {
  if (u == b) {
    return;
  }
  fa[u] = 1;
  for (auto &v : adj[u]) {
    if (!fa[v]) {
      DFSa(v);
    }
  }
}
void DFSb(int u) {
  if (u == a) {
    return;
  }
  fb[u] = 1;
  for (auto &v : adj[u]) {
    if (!fb[v]) {
      DFSb(v);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> m >> a >> b;
    for (int i = 1; i <= (int)(n); ++i) {
      adj[i].clear();
      fa[i] = fb[i] = 0;
    }
    while (m--) {
      int u, v;
      cin >> u >> v;
      adj[u].emplace_back(v);
      adj[v].emplace_back(u);
    }
    DFSa(a);
    DFSb(b);
    ca = cb = 0;
    for (int i = 1; i <= (int)(n); ++i) {
      if (fa[i]) {
        ca += !fb[i];
      }
      if (fb[i]) {
        cb += !fa[i];
      }
    }
    cout << (ca - 1) * (cb - 1) << '\n';
  }
  return 0;
}
