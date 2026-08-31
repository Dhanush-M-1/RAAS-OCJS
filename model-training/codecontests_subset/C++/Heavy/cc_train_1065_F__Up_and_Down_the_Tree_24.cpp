#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int grand(int x) { return uniform_int_distribution<int>(0, x - 1)(rng); }
const int maxn = 1e6 + 7;
const long long inf = 1e15;
const long long md = 1e9 + 7;
long long gcd(long long x, long long y) {
  if (x < y) return gcd(y, x);
  if (y == 0) return x;
  return gcd(y, x % y);
}
int K;
vector<int> G[maxn];
int pars[maxn];
int ka[maxn];
int g;
vector<int> lf;
struct digraph {
  vector<int> G[maxn];
  vector<int> H[maxn];
  int A[maxn];
  int N;
  int totalColors;
  vector<int> T[maxn];
  void init(int n) {
    N = n;
    totalColors = 0;
    for (int i = 1; i <= n; i++) {
      G[i].clear();
      H[i].clear();
      T[i].clear();
      A[i] = -1;
    }
  }
  void addEdge(int x, int y) {
    ;
    G[x].push_back(y);
    H[y].push_back(x);
  }
  void dfs(int x, bool vis[], stack<int> *second) {
    vis[x] = true;
    for (int y : G[x]) {
      if (vis[y]) continue;
      dfs(y, vis, second);
    }
    second->push(x);
  }
  void dfscc(int x, bool vis[], vector<int> *comp) {
    vis[x] = true;
    comp->push_back(x);
    for (int y : H[x]) {
      if (vis[y]) continue;
      dfscc(y, vis, comp);
    }
  }
  vector<vector<int> > scc() {
    stack<int> second;
    bool vis[N + 1];
    fill(vis, vis + N + 2, false);
    for (int i = 1; i <= N; i++) {
      if (!vis[i]) {
        dfs(i, vis, &second);
      }
    }
    vector<vector<int> > sccs;
    fill(vis, vis + N + 2, false);
    while (!second.empty()) {
      int v = second.top();
      second.pop();
      if (vis[v]) continue;
      ;
      vector<int> comp;
      dfscc(v, vis, &comp);
      sccs.push_back(comp);
    }
    return sccs;
  }
  void topoSortComponents() {
    totalColors = 0;
    for (vector<int> comp : scc()) {
      totalColors++;
      for (int v : comp) {
        A[v] = totalColors;
      }
    }
    for (int x = 1; x <= N; x++) {
      for (int y : G[x]) {
        T[A[x]].push_back(A[y]);
      }
    }
    for (int x = 1; x <= totalColors; x++) {
      sort(T[x].begin(), T[x].end());
      T[x].resize(unique(T[x].begin(), T[x].end()) - T[x].begin());
    }
  }
  bool dfsr(int x, bool vis[], int y) {
    if (x == y) return true;
    vis[x] = true;
    for (int z : G[x]) {
      if (vis[z]) continue;
      if (dfsr(z, vis, y)) return true;
    }
    return false;
  }
  bool reachable(int x, int y) {
    bool vis[N + 1];
    fill(vis, vis + N + 2, false);
    return dfsr(x, vis, y);
  }
  int getCol(int x) { return A[x]; }
} W;
void dfs(int x, int pi, int idx) {
  pars[++idx] = x;
  if (idx > K) {
    ka[x] = pars[idx - K];
  } else {
    ka[x] = pars[1];
  }
  if (ka[x] != x && G[x].size() == 0) {
    W.addEdge(x, ka[x]);
  }
  for (int y : G[x]) {
    dfs(y, x, idx);
    W.addEdge(x, y);
  }
}
vector<vector<int> > comps;
int cnt[maxn];
int fuc[maxn];
int main() {
  {
    ios ::sync_with_stdio(false);
    cin.tie(0);
  };
  int n;
  cin >> n >> K;
  for (int i = 2; i <= n; i++) {
    int p;
    cin >> p;
    G[p].push_back(i);
  }
  W.init(n);
  fill(cnt, cnt + maxn, 0);
  pars[1] = -1;
  dfs(1, -1, 0);
  comps = W.scc();
  W.topoSortComponents();
  fill(fuc, fuc + maxn, 0);
  for (int j = 1; j <= n; j++) {
    if (G[j].size() == 0 && j != 1) fuc[W.getCol(j)]++;
  }
  int ans = 0;
  for (int j = W.totalColors; j >= 1; j--) {
    cnt[j] = fuc[j];
    for (int q : W.T[j]) {
      if (q == j) continue;
      cnt[j] = max(cnt[j], fuc[j] + cnt[q]);
    }
    ans = max(ans, cnt[j]);
  }
  cout << ans << "\n";
}
