#include <bits/stdc++.h>
using namespace std;
inline long long in() {
  long long x;
  scanf("%lld", &x);
  return x;
}
set<pair<int, int>> vis;
set<pair<int, int>> points;
map<pair<int, int>, int> dis;
map<pair<int, int>, vector<pair<int, int>>> adj;
int level = -1;
pair<int, int> start, last;
bool pre(pair<int, int> x) { return points.find(x) != points.end(); }
void sh(pair<int, int> x) {}
void bfs(pair<int, int> u) {
  queue<pair<int, int>> q;
  q.push(u);
  queue<pair<int, int>> temp;
  while (!q.empty()) {
    pair<int, int> v = q.front();
    if (v == last) {
      level = dis[v];
      return;
    }
    sh(v);
    vis.insert(v);
    q.pop();
    for (pair<int, int> p : adj[v]) {
      if (vis.find(p) == vis.end()) {
        q.push(p);
        vis.insert(p);
        dis[p] = dis[v] + 1;
      }
    }
  }
}
void solve() {
  long long x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  start = make_pair(x1, y1);
  last = make_pair(x2, y2);
  dis[start] = 0;
  int k;
  cin >> k;
  while (k--) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (int c = a; c <= b; c++) {
      pair<int, int> p = make_pair(r, c);
      if (points.find(p) == points.end()) points.insert(p);
    }
  }
  for (pair<int, int> p : points) {
    int r = p.first, c = p.second;
    if (pre(make_pair(r - 1, c))) adj[p].push_back(make_pair(r - 1, c));
    if (pre(make_pair(r + 1, c))) adj[p].push_back(make_pair(r + 1, c));
    if (pre(make_pair(r, c - 1))) adj[p].push_back(make_pair(r, c - 1));
    if (pre(make_pair(r, c + 1))) adj[p].push_back(make_pair(r, c + 1));
    if (pre(make_pair(r - 1, c - 1))) adj[p].push_back(make_pair(r - 1, c - 1));
    if (pre(make_pair(r + 1, c + 1))) adj[p].push_back(make_pair(r + 1, c + 1));
    if (pre(make_pair(r + 1, c - 1))) adj[p].push_back(make_pair(r + 1, c - 1));
    if (pre(make_pair(r - 1, c + 1))) adj[p].push_back(make_pair(r - 1, c + 1));
  }
  bfs(start);
  cout << level << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int t = 1;
  while (t--) solve();
  cout << "\n\n";
  return 0;
}
