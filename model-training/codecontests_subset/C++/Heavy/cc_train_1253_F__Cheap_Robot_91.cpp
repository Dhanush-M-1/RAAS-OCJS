#include <bits/stdc++.h>
using namespace std;
int n, m, k, q;
vector<pair<int, int> > gr[100007];
int LCA[100007][19];
long long mx[100007][19];
int lvl[100007];
vector<pair<int, long long> > v[100007];
long long opt[100007];
int ori[100007];
struct tuhla {
  int vertex;
  long long dist;
  int origin;
  tuhla() { vertex = dist = origin = 0; }
  tuhla(int _vertex, long long _dist, int _origin) {
    vertex = _vertex;
    dist = _dist;
    origin = _origin;
  }
  bool operator<(tuhla other) const { return (dist > other.dist); }
};
priority_queue<struct tuhla> pq;
struct edge {
  int x, y;
  long long cost;
  edge() { x = y = cost = 0; }
  edge(int _x, int _y, long long _cost) {
    x = _x;
    y = _y;
    cost = _cost;
  }
  bool operator<(edge other) const { return (cost < other.cost); }
};
vector<struct edge> srt;
void dijkstra() {
  for (int i = 1; i <= k; ++i) {
    pq.push(tuhla(i, 0, i));
    opt[i] = 0;
    ori[i] = i;
  }
  for (int i = k + 1; i <= n; ++i) {
    opt[i] = -1;
  }
  while (pq.empty() == false) {
    tuhla aux = pq.top();
    pq.pop();
    if (opt[aux.vertex] != aux.dist) {
      continue;
    }
    if (ori[aux.vertex] != aux.origin) {
      continue;
    }
    int sz = gr[aux.vertex].size();
    for (int i = 0; i < sz; ++i) {
      int h = gr[aux.vertex][i].first;
      int c = gr[aux.vertex][i].second;
      if (opt[h] == -1 || opt[h] > aux.dist + c) {
        opt[h] = aux.dist + c;
        ori[h] = aux.origin;
        pq.push(tuhla(h, opt[h], ori[h]));
      }
    }
  }
}
int prv[100007];
int rnk[100007];
int find(int x) {
  if (prv[x] == -1) {
    return x;
  }
  int y = find(prv[x]);
  prv[x] = y;
  return y;
}
void unite(edge aux) {
  int k1 = find(aux.x);
  int k2 = find(aux.y);
  if (k1 != k2) {
    v[aux.x].push_back({aux.y, aux.cost});
    v[aux.y].push_back({aux.x, aux.cost});
    if (rnk[k1] >= rnk[k2]) {
      if (rnk[k1] == rnk[k2]) {
        ++rnk[k1];
      }
      prv[k2] = k1;
    } else {
      prv[k1] = k2;
    }
  }
}
void dfs(int vertex, int lst) {
  for (int i = 1; i < 19; ++i) {
    LCA[vertex][i] = LCA[LCA[vertex][i - 1]][i - 1];
    mx[vertex][i] = max(mx[vertex][i - 1], mx[LCA[vertex][i - 1]][i - 1]);
  }
  int sz = v[vertex].size();
  for (int i = 0; i < sz; ++i) {
    if (v[vertex][i].first == lst) {
      continue;
    }
    LCA[v[vertex][i].first][0] = vertex;
    mx[v[vertex][i].first][0] = v[vertex][i].second;
    lvl[v[vertex][i].first] = lvl[vertex] + 1;
    dfs(v[vertex][i].first, vertex);
  }
}
long long f(int x, int y) {
  long long ret = 0;
  for (int i = 19 - 1; i >= 0; --i) {
    if (lvl[x] - (1 << i) >= lvl[y]) {
      ret = max(ret, mx[x][i]);
      x = LCA[x][i];
    }
    if (lvl[y] - (1 << i) >= lvl[x]) {
      ret = max(ret, mx[y][i]);
      y = LCA[y][i];
    }
  }
  for (int i = 19 - 1; i >= 0; --i) {
    if (LCA[x][i] != LCA[y][i]) {
      ret = max(ret, mx[x][i]);
      x = LCA[x][i];
      ret = max(ret, mx[y][i]);
      y = LCA[y][i];
    }
  }
  if (x != y) {
    ret = max(ret, mx[x][0]);
    ret = max(ret, mx[y][0]);
  }
  return ret;
}
void input() {
  cin >> n >> m >> k >> q;
  for (int i = 1; i <= m; ++i) {
    int x, y, z;
    cin >> x >> y >> z;
    gr[x].push_back({y, z});
    gr[y].push_back({x, z});
  }
}
void solve() {
  dijkstra();
  for (int i = 1; i <= n; ++i) {
    int sz = gr[i].size();
    for (int j = 0; j < sz; ++j) {
      int h = gr[i][j].first;
      int c = gr[i][j].second;
      if (ori[h] != ori[i] && ori[h] < ori[i]) {
        srt.push_back(edge(ori[h], ori[i], opt[i] + opt[h] + c));
      }
    }
  }
  sort(srt.begin(), srt.end());
  for (int i = 1; i <= n; ++i) {
    prv[i] = -1;
  }
  int sz = srt.size();
  for (int i = 0; i < sz; ++i) {
    unite(srt[i]);
  }
  dfs(1, -1);
  while (q--) {
    int x, y;
    cin >> x >> y;
    cout << f(x, y) << "\n";
  }
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  input();
  solve();
  return 0;
}
