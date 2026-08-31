#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long INFL = 0x3f3f3f3f3f3f3f3fLL;
struct Edge {
  int src, dst;
  int weight;
  Edge(int src_, int dst_, int weight_)
      : src(src_), dst(dst_), weight(weight_) {}
  Edge(int dst_, int weight_) : src(-2), dst(dst_), weight(weight_) {}
};
bool operator<(const Edge &e, const Edge &f) {
  return e.weight != f.weight ? e.weight > f.weight : e.dst < f.dst;
}
void dijkstra(const vector<vector<Edge> > &g, int start, vector<int> &dist) {
  int n = g.size();
  dist.assign(n, INF);
  dist[start] = 0;
  vector<int> prev(n, -1);
  priority_queue<Edge> q;
  for (q.push(Edge(-2, start, 0)); !q.empty();) {
    Edge e = q.top();
    q.pop();
    if (prev[e.dst] != -1) continue;
    prev[e.dst] = e.src;
    for (typeof((g[e.dst]).begin()) f = ((g[e.dst]).begin());
         f != (g[e.dst]).end(); ++f) {
      if (dist[f->dst] > e.weight + f->weight) {
        dist[f->dst] = e.weight + f->weight;
        q.push(Edge(f->src, f->dst, e.weight + f->weight));
      }
    }
  }
}
int main() {
  int n;
  int x0, y0, x1, y1;
  vector<pair<int, pair<int, int> > > v;
  cin >> y0 >> x0 >> y1 >> x1;
  cin >> n;
  for (int(i) = 0; (i) < (int)(n); ++(i)) {
    int o, a, b;
    cin >> o >> a >> b;
    v.push_back(make_pair((o), (make_pair((a), (b)))));
  }
  sort((v).begin(), (v).end());
  map<pair<int, int>, int> m;
  int t = 0;
  static const int dy[4] = {0, -1, -1, -1}, dx[4] = {-1, 0, -1, 1};
  vector<vector<Edge> > g;
  for (typeof((v).begin()) i = ((v).begin()); i != (v).end(); ++i) {
    for (int(j) = (int)(i->second.first); (j) <= (int)(i->second.second);
         ++(j)) {
      if (m.count(make_pair((i->first), (j)))) continue;
      int q = m[make_pair((i->first), (j))] = t++;
      g.push_back(vector<Edge>());
      for (int(d) = 0; (d) < (int)(4); ++(d))
        if (m.count(make_pair((i->first + dy[d]), (j + dx[d])))) {
          g[q].push_back(
              Edge(q, m[make_pair((i->first + dy[d]), (j + dx[d]))], 1));
        }
    }
  }
  vector<vector<Edge> > gg(t);
  for (int(i) = 0; (i) < (int)(t); ++(i))
    for (typeof((g[i]).begin()) j = ((g[i]).begin()); j != (g[i]).end(); ++j) {
      gg[j->src].push_back(Edge(j->src, j->dst, 1));
      gg[j->dst].push_back(Edge(j->dst, j->src, 1));
    }
  int r = -1;
  if (!m.count(make_pair((y0), (x0))))
    r = -999;
  else if (!m.count(make_pair((y1), (x1))))
    r = -999;
  else {
    vector<int> d;
    dijkstra(gg, m[make_pair((y0), (x0))], d);
    r = d[m[make_pair((y1), (x1))]];
    if (r == INF) r = -1;
  }
  cout << r << endl;
  return 0;
}
