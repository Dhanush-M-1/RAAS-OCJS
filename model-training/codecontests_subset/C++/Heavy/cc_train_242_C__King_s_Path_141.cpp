#include <bits/stdc++.h>
using namespace std;
inline long long in() {
  long long x;
  scanf("%lld", &x);
  return x;
}
set<pair<int, int>> vis;
set<pair<int, int>> points;
map<pair<int, int>, vector<pair<int, int>>> adj;
int level = -1;
pair<int, int> start, last;
bool pre(pair<int, int> x) { return points.find(x) != points.end(); }
void bfs(pair<int, int> u) {
  vis.insert(u);
  if (u == last) {
    level = 0;
    return;
  }
  int l = 0;
  queue<pair<int, int>> q;
  q.push(u);
  queue<pair<int, int>> temp;
  while (!q.empty()) {
    pair<int, int> v = q.front();
    if (v == last) {
      level = l;
      break;
    }
    q.pop();
    for (pair<int, int> p : adj[v]) {
      if (vis.find(p) == vis.end()) {
        vis.insert(p);
        temp.push(p);
      }
    }
    if (q.empty()) {
      l++;
      swap(temp, q);
    }
  }
}
void solve() {
  long long x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  start = make_pair(x1, y1);
  last = make_pair(x2, y2);
  int k;
  cin >> k;
  while (k--) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (int c = a; c <= b; c++) {
      points.insert(make_pair(r, c));
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
