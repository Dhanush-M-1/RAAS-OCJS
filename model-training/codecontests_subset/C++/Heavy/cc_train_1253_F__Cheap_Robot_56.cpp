#include <bits/stdc++.h>
using namespace std;
long long int dist[100005];
long long int n, m, k, q, ind[100005], parent[100005], depth[100005],
    maxi[100005][25], parent2[100005][25], sol[300005];
vector<pair<int, int> > v[100005];
vector<pair<int, long long int> > v2[100005];
set<pair<long long int, int> > s;
map<pair<int, int>, long long int> m1;
vector<pair<int, pair<int, int> > > e;
vector<pair<long long int, pair<int, int> > > e2;
set<int> s1[100005];
void dijkstra() {
  for (int i = 0; i < n; i++) {
    dist[i] = 1e18;
    if (i < k) {
      dist[i] = 0;
      ind[i] = i;
    }
    s.insert(make_pair(dist[i], i));
  }
  while (!s.empty()) {
    long long int d = (*s.begin()).first, x = (*s.begin()).second;
    s.erase(s.begin());
    for (int i = 0; i < v[x].size(); i++) {
      if (d + v[x][i].second < dist[v[x][i].first]) {
        ind[v[x][i].first] = ind[x];
        s.erase(make_pair(dist[v[x][i].first], v[x][i].first));
        dist[v[x][i].first] = d + v[x][i].second;
        s.insert(make_pair(dist[v[x][i].first], v[x][i].first));
      }
    }
  }
}
int find_par(int x) {
  if (x == parent[x]) return x;
  int par = find_par(parent[x]);
  parent[x] = par;
  return par;
}
void spoji(int x, int y, long long int a) {
  x = find_par(x);
  y = find_par(y);
  if (x == y) return;
  if (depth[x] == depth[y]) depth[x] += 1;
  if (depth[x] > depth[y])
    parent[y] = x;
  else
    parent[x] = y;
  if (s1[x].size() > s1[y].size()) {
    for (set<int>::iterator it = s1[y].begin(); it != s1[y].end(); it++) {
      if (s1[x].find(*it) != s1[x].end()) sol[*it] = a;
      s1[x].insert(*it);
    }
    s1[y].clear();
    if (x != parent[y]) swap(s1[x], s1[y]);
  } else {
    for (set<int>::iterator it = s1[x].begin(); it != s1[x].end(); it++) {
      if (s1[y].find(*it) != s1[y].end()) sol[*it] = a;
      s1[y].insert(*it);
    }
    s1[x].clear();
    if (y != parent[x]) swap(s1[x], s1[y]);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; i++) {
    int a, b, w;
    cin >> a >> b >> w;
    v[a - 1].push_back(make_pair(b - 1, w));
    v[b - 1].push_back(make_pair(a - 1, w));
    e.push_back(make_pair(w, make_pair(a - 1, b - 1)));
  }
  dijkstra();
  for (int i = 0; i < m; i++) {
    int x = e[i].second.first, y = e[i].second.second;
    if (ind[x] == ind[y]) continue;
    if (m1[make_pair(ind[x], ind[y])] == 0 or
        dist[x] + e[i].first + dist[y] < m1[make_pair(ind[x], ind[y])]) {
      m1[make_pair(ind[x], ind[y])] = dist[x] + e[i].first + dist[y];
      m1[make_pair(ind[y], ind[x])] = dist[x] + e[i].first + dist[y];
    }
  }
  for (int i = 0; i < m; i++) {
    int x = e[i].second.first, y = e[i].second.second;
    if (ind[x] == ind[y] or m1[make_pair(ind[x], ind[y])] == 0) continue;
    e2.push_back(
        make_pair(m1[make_pair(ind[x], ind[y])], make_pair(ind[x], ind[y])));
    m1[make_pair(ind[x], ind[y])] = 0;
    m1[make_pair(ind[y], ind[x])] = 0;
  }
  sort(e2.begin(), e2.end());
  for (int i = 0; i < k; i++) parent[i] = i;
  for (int i = 0; i < q; i++) {
    int a, b;
    cin >> a >> b;
    s1[ind[a - 1]].insert(i);
    s1[ind[b - 1]].insert(i);
  }
  for (int i = 0; i < e2.size(); i++) {
    int x = e2[i].second.first, y = e2[i].second.second;
    if (find_par(x) == find_par(y)) continue;
    spoji(x, y, e2[i].first);
  }
  for (int i = 0; i < q; i++) {
    cout << sol[i] << "\n";
  }
  return 0;
}
