#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18 + 7;
const int maxN = 1e5 + 5;
int n, m, k, q, a, b, w;
set<pair<long long, long long> > s;
vector<pair<long long, long long> > graph[maxN], newGraph[maxN];
long long cost[maxN];
int parent[maxN], ranga[maxN];
vector<pair<long long, pair<long long, long long> > > edges;
int pre[maxN], treeSize[maxN];
bool vis[maxN];
int counter = 0;
pair<long long, long long> P[18][maxN];
void dijkstra() {
  for (int i = (k + 1); i <= (n); ++i) {
    cost[i] = inf;
    s.insert(pair<long long, long long>(cost[i], i));
  }
  for (int i = (1); i <= ((k)); ++i) {
    cost[i] = 0;
    s.insert(pair<long long, long long>(cost[i], i));
  }
  while (!s.empty()) {
    pair<long long, long long> p = *s.begin();
    s.erase(s.begin());
    for (auto x : graph[p.second]) {
      if (cost[x.first] > cost[p.second] + x.second) {
        s.erase(s.find(pair<long long, long long>(cost[x.first], x.first)));
        cost[x.first] = cost[p.second] + x.second;
        s.insert(pair<long long, long long>(cost[x.first], x.first));
      }
    }
  }
}
int find(int x) {
  if (parent[x] != x) {
    parent[x] = find(parent[x]);
  }
  return parent[x];
}
void Union(int x, int y) {
  int fx = find(x);
  int fy = find(y);
  if (fy == fx) return;
  if (ranga[fx] < ranga[fy]) {
    swap(fx, fy);
  }
  parent[fy] = fx;
  if (ranga[fy] == ranga[fx]) ranga[fx]++;
}
bool children(int u, int v) {
  return (pre[u] >= pre[v] && pre[u] < pre[v] + treeSize[v]);
}
int lca(int u, int v) {
  if (children(u, v)) return v;
  if (children(v, u)) return u;
  int i = u, j = 18 - 1;
  while (j >= 0) {
    if (children(v, P[j][i].first))
      j--;
    else
      i = P[j][i].first;
  }
  return P[0][i].first;
}
void dfs(int v) {
  counter++;
  pre[v] = counter;
  for (auto i : newGraph[v]) {
    int to = i.first;
    long long cost = i.second;
    if (!vis[to]) {
      P[0][to] = pair<long long, long long>(v, cost);
      vis[to] = true;
      dfs(to);
    }
  }
  treeSize[v] = counter + 1 - pre[v];
}
long long getMax(int a, int x) {
  int cnt = 0;
  long long maxim = 0;
  while (a != x) {
    while (children(P[cnt][a].first, x) && P[cnt][a].first != x) {
      cnt++;
    }
    if (children(x, P[cnt][a].first) && x != P[cnt][a].first) cnt--;
    maxim = max(maxim, P[cnt][a].second);
    a = P[cnt][a].first;
    cnt = 0;
  }
  return maxim;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n >> m >> k >> q;
  for (int i = (0); i <= ((m)-1); ++i) {
    cin >> a >> b >> w;
    graph[a].push_back(pair<long long, long long>(b, w));
    graph[b].push_back(pair<long long, long long>(a, w));
  }
  dijkstra();
  for (int i = (1); i <= ((n)); ++i) {
    parent[i] = i;
    ranga[i] = 0;
    for (auto x : graph[i]) {
      if (i < x.first) {
        edges.push_back(pair<long long, pair<long long, long long> >(
            cost[i] + cost[x.first] + x.second,
            pair<long long, long long>(i, x.first)));
      }
    }
  }
  sort(edges.begin(), edges.end());
  for (auto p : edges) {
    long long cost = p.first;
    int x = p.second.first;
    int y = p.second.second;
    if (find(x) != find(y)) {
      Union(x, y);
      newGraph[x].push_back(pair<long long, long long>(y, cost));
      newGraph[y].push_back(pair<long long, long long>(x, cost));
    }
  }
  for (int i = 0; i < 18; i++)
    for (int j = 0; j <= n; j++) P[i][j] = pair<long long, long long>(0, 0);
  vis[1] = true;
  dfs(1);
  P[0][1] = pair<long long, long long>(1, 0);
  for (int i = 1; i < 18; i++) {
    for (int j = 1; j <= n; j++) {
      pair<long long, long long> half = P[i - 1][j];
      P[i][j].first = P[i - 1][half.first].first;
      P[i][j].second = max(half.second, P[i - 1][half.first].second);
    }
  }
  for (int i = (0); i <= ((q)-1); ++i) {
    cin >> a >> b;
    int x = lca(a, b);
    cout << max(getMax(a, x), getMax(b, x)) << endl;
  }
  return 0;
}
