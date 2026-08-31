#include <bits/stdc++.h>
using namespace std;
void del(int edge, vector<set<int>>& g, map<int, int>& degr, int k) {
  degr.erase(degr.find(edge));
  for (auto neigh : g[edge]) {
    g[neigh].erase(edge);
    auto it = degr.find(neigh);
    if (it != degr.end()) {
      if (--degr[neigh] < k) {
        del(neigh, g, degr, k);
      }
    }
  }
  g[edge].clear();
}
int main() {
  int n, m, k;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> k;
  vector<set<int>> g(n);
  vector<pair<int, int>> edges;
  map<int, int> degr;
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    g[a].insert(b);
    g[b].insert(a);
    edges.push_back({a, b});
    degr[a]++;
    degr[b]++;
  }
  for (int i = 0; i < n; i++) {
    if (degr.find(i) != degr.end() && degr[i] < k) {
      del(i, g, degr, k);
    }
  }
  std::list<int> answ;
  for (int i = m - 1; i >= 0; i--) {
    answ.push_front(degr.size());
    auto edge = edges[i];
    if (g[edge.second].find(edge.first) != g[edge.second].end()) {
      g[edge.second].erase(edge.first);
      if (--degr[edge.first] < k) del(edge.first, g, degr, k);
    }
    if (g[edge.first].find(edge.second) != g[edge.first].end()) {
      g[edge.first].erase(edge.second);
      if (--degr[edge.second] < k) del(edge.second, g, degr, k);
    }
  }
  for (auto a : answ) {
    cout << a << "\n";
  }
  return 0;
}
