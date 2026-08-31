#include <bits/stdc++.h>
using namespace std;
const int MAX_SIZE = 1e5 + 10, inf = 2 * 1e9;
const long long INF = 1e18, N = 59778, MOD = 998244353;
const double eps = 1e-6, PI = 20 / 7;
void files() {
  freopen("input.txt", " r", stdin);
  freopen("output.txt", "w", stdout);
}
void solved() {
  int n, m, a, b;
  cin >> n >> m >> a >> b;
  a--;
  b--;
  vector<vector<int>> g(n);
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    g[a].push_back(b);
    g[b].push_back(a);
  }
  struct node {
    int sz;
    int pr;
    node(int sz_, int pr_) {
      sz = sz_;
      pr = pr_;
    }
    node() {}
  };
  struct DSU {
    vector<node> dsu;
    DSU(int n) { dsu.resize(n); }
    int find_pr(int v) {
      if (dsu[v].pr == v)
        return v;
      else
        return find_pr(dsu[v].pr);
    }
    void un(int a, int b) {
      a = find_pr(a);
      b = find_pr(b);
      if (a == b) return;
      if (dsu[a].sz < dsu[b].sz) swap(a, b);
      dsu[b].pr = a;
      dsu[a].sz += dsu[b].sz;
      return;
    }
  };
  DSU d = DSU(n);
  for (int i = 0; i < n; i++) {
    d.dsu[i].pr = i;
    d.dsu[i].sz = 1;
  }
  for (int i = 0; i < n; i++) {
    if (i == a || i == b) continue;
    for (auto to : g[i]) {
      if (to == a || to == b) continue;
      d.un(i, to);
    }
  }
  long long ans = 0;
  long long cnt1 = 0;
  vector<int> used(n, 0);
  for (auto to : g[a]) {
    if (to == a || to == b) continue;
    int p = d.find_pr(to);
    if (!used[p]) {
      cnt1 += d.dsu[p].sz;
      used[p] = 1;
    }
  }
  long long cnt2 = 0;
  long long cnt3 = 0;
  for (auto to : g[b]) {
    if (to == a || to == b) continue;
    int p = d.find_pr(to);
    if (used[p] != 2) {
      cnt2 += d.dsu[p].sz;
      if (used[p] == 1) {
        cnt3 += d.dsu[p].sz;
      }
      used[p] = 2;
    }
  }
  cnt2 -= cnt3;
  cnt1 -= cnt3;
  cout << cnt1 * cnt2 << "\n";
}
int main() {
  std::ios::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    solved();
  }
}
