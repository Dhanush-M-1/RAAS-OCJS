#include <bits/stdc++.h>
using namespace std;
struct UF {
  int n;
  vector<int> par;
  UF(int n) : n(n) {
    for (int i = 0; i < n; i++) par.push_back(i);
  }
  int find(int a) {
    if (a != par[a]) par[a] = find(par[a]);
    return par[a];
  }
  void join(int a, int b) { par[find(a)] = find(b); }
};
struct V {
  vector<pair<int, int> > outs;
  int nins = 0;
};
vector<int> euler_walk(vector<V>& nodes, int nedges, int src = 0) {
  int c = 0;
  for (auto& n : nodes) c += abs(n.nins - (int)(n.outs).size());
  if (c > 2) return {};
  vector<vector<pair<int, int> >::iterator> its;
  for (auto& n : nodes) its.push_back(n.outs.begin());
  vector<bool> eu(nedges);
  vector<int> ret, s = {src};
  while (!s.empty()) {
    int x = s.back();
    auto &it = its[x], end = nodes[x].outs.end();
    while (it != end && eu[it->second]) ++it;
    if (it == end) {
      ret.push_back(x);
      s.pop_back();
    } else {
      s.push_back(it->first);
      eu[it->second] = true;
    }
  }
  if ((int)(ret).size() != nedges + 1) ret.clear();
  reverse(ret.begin(), ret.end());
  return ret;
}
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  long long n, s;
  cin >> n >> s;
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  vector<int> sa = a;
  sort(sa.begin(), sa.end());
  int g = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] != sa[i]) {
      g++;
    }
  }
  map<int, int> cc;
  for (int i = 0; i < n; i++) {
    if (cc.find(a[i]) == cc.end()) {
      int t = cc.size();
      cc[a[i]] = t;
    }
  }
  for (int i = 0; i < n; i++) {
    a[i] = cc[a[i]];
    sa[i] = cc[sa[i]];
  }
  vector<vector<pair<int, int> > > edges(cc.size() + 1);
  UF uf(cc.size());
  vector<int> notstupid(cc.size(), 0);
  int edgetotal = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] != sa[i]) {
      uf.join(a[i], sa[i]);
      edges[a[i]].push_back({sa[i], edgetotal++});
      notstupid[a[i]] = notstupid[sa[i]] = 1;
    }
  }
  for (int i = 0; i < cc.size(); i++) {
    if (uf.find(i) == i && notstupid[i]) {
      edges[cc.size()].push_back({i, edgetotal++});
      edges[i].push_back({cc.size(), edgetotal++});
    }
  }
  vector<V> nodes(cc.size() + 1);
  for (int i = 0; i < edges.size(); i++) {
    nodes[i].outs = edges[i];
    for (auto x : edges[i]) {
      nodes[x.first].nins++;
    }
  }
  vector<int> cycle = euler_walk(nodes, edgetotal, cc.size());
  vector<vector<int> > cycles;
  vector<int> cur;
  for (int x : cycle) {
    if (x == cc.size()) {
      if (cur.size() > 0) {
        cycles.push_back(cur);
        cur.clear();
      }
    } else {
      cur.push_back(x);
    }
  }
  map<pair<int, int>, vector<int> > q;
  map<pair<int, int>, int> curnum;
  for (int i = 0; i < n; i++) {
    if (a[i] != sa[i]) {
      q[{a[i], sa[i]}].push_back(i);
      curnum[{a[i], sa[i]}] = 0;
    }
  }
  vector<vector<int> > edge_idx;
  for (vector<int> z : cycles) {
    vector<int> realcycle;
    for (int i = 0; i + 1 < z.size(); i++) {
      pair<int, int> f = {z[i], z[i + 1]};
      realcycle.push_back(q[f][curnum[f]] + 1);
      curnum[f]++;
    }
    reverse(realcycle.begin(), realcycle.end());
    edge_idx.push_back(realcycle);
  }
  if (g > s) {
    cout << -1 << '\n';
    return 0;
  }
  if (s <= g + 2 || edge_idx.size() <= 2) {
  } else {
    int v = s - g;
    v = min(v, (int)edge_idx.size());
    vector<vector<int> > newe;
    vector<int> c1;
    vector<int> c2;
    for (int j = 0; j < v; j++) {
      for (int x : edge_idx[j]) {
        c1.push_back(x);
      }
      c2.push_back(edge_idx[j][0]);
    }
    reverse(c2.begin(), c2.end());
    newe.push_back(c1);
    newe.push_back(c2);
    for (int j = v; j < edge_idx.size(); j++) {
      newe.push_back(edge_idx[j]);
    }
    edge_idx = newe;
  }
  cout << edge_idx.size() << '\n';
  for (int i = 0; i < edge_idx.size(); i++) {
    vector<int> realcycle = edge_idx[i];
    cout << realcycle.size() << '\n';
    for (int x : realcycle) {
      cout << x << " ";
    }
    cout << '\n';
  }
}
