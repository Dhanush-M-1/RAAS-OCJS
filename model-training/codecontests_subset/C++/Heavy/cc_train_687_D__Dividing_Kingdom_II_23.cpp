#include <bits/stdc++.h>
using namespace std;
int par[1001], r[1001], p[1001];
int n, m, q;
vector<pair<int, pair<int, int> > > segt[2 * 1000 * 999];
multiset<pair<int, pair<int, int> > > mu;
void up(int node, int l, int r, int in, pair<int, pair<int, int> > v) {
  segt[node].push_back(v);
  if (l == r) return;
  int m = (l + r) / 2;
  if (in <= m)
    up(2 * node + 1, l, m, in, v);
  else
    up(2 * node + 2, m + 1, r, in, v);
}
void qu(int node, int l, int r, int s, int e) {
  if (l > e || r < s) return;
  if (l >= s && r <= e) {
    mu.insert(segt[node].begin(), segt[node].end());
    return;
  }
  int m = (l + r) / 2;
  qu(2 * node + 1, l, m, s, e);
  qu(2 * node + 2, m + 1, r, s, e);
}
pair<int, int> find(int f) {
  if (par[par[f]] != par[f]) {
    int x = p[f];
    pair<int, int> y = find(par[f]);
    p[f] = (x ^ y.second);
    par[f] = y.first;
  }
  return make_pair(par[f], p[f]);
}
int mer(int f, int s) {
  pair<int, int> pf = find(f), ps = find(s);
  if (pf.first == ps.first) {
    if (pf.second == ps.second) return 0;
    return 1;
  } else {
    if (r[pf.first] >= r[ps.first]) {
      par[ps.first] = pf.first;
      p[ps.first] = ((ps.second ^ 1) ^ (pf.second));
      if (r[pf.first] == r[ps.first]) r[pf.first]++;
    } else {
      par[pf.first] = ps.first;
      p[pf.first] = ((pf.second ^ 1) ^ ps.second);
    }
    return 2;
  }
}
vector<pair<int, pair<int, int> > > v1;
void init(int node, int l, int ri) {
  sort((segt[node]).begin(), (segt[node]).end());
  for (int j = 0; j < n; ++j) {
    par[j] = j;
    r[j] = 1;
    p[j] = 0;
  }
  for (int i = segt[node].size() - 1; i >= 0; --i) {
    int ch = mer(segt[node][i].second.first, segt[node][i].second.second);
    if (ch == 0) {
      v1.push_back(segt[node][i]);
      break;
    } else if (ch == 2) {
      v1.push_back(segt[node][i]);
    }
  }
  reverse((v1).begin(), (v1).end());
  segt[node].clear();
  for (int i = 0; i < v1.size(); ++i) segt[node].push_back(v1[i]);
  v1.clear();
  if (l == ri) return;
  int m = (l + ri) / 2;
  init(2 * node + 1, l, m);
  init(2 * node + 2, m + 1, ri);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> q;
  for (int i = 0; i < m; ++i) {
    int f, s, w;
    cin >> f >> s >> w;
    f--;
    s--;
    up(0, 0, m - 1, i, make_pair(w, make_pair(f, s)));
  }
  init(0, 0, m - 1);
  for (int i = 0; i < q; ++i) {
    mu.clear();
    int f, s;
    cin >> f >> s;
    f--;
    s--;
    for (int j = 0; j < n; ++j) {
      par[j] = j;
      r[j] = 1;
      p[j] = 0;
    }
    qu(0, 0, m - 1, f, s);
    int v = -1;
    for (auto it = (--mu.end()); 1; --it) {
      if (mer((*it).second.first, (*it).second.second) == 0) {
        v = (*it).first;
        break;
      }
      if (it == mu.begin()) break;
    }
    cout << v << '\n';
  }
  return (0);
}
