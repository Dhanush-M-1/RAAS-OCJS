#include <bits/stdc++.h>
using namespace std;
int main() {
  int x0, y0, x1, y1;
  cin >> x0 >> y0 >> x1 >> y1;
  int n;
  cin >> n;
  multimap<int, pair<long long int, long long int> > sections;
  for (long long int i = 0; i < n; i++) {
    int r, a, b;
    cin >> r >> a >> b;
    sections.insert(make_pair(r, make_pair(a, b)));
  }
  map<pair<long long int, long long int>, bool> visited;
  map<pair<long long int, long long int>, int> dist;
  pair<long long int, long long int> start = make_pair(x0, y0);
  pair<long long int, long long int> target = make_pair(x1, y1);
  queue<pair<long long int, long long int> > que;
  que.push(start);
  visited[start] = true;
  dist[start] = 0;
  int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
  int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
  while (que.size()) {
    pair<long long int, long long int> cur = que.front();
    que.pop();
    if (cur == target) {
      break;
    };
    for (long long int i = 0; i < 8; i++) {
      long long int nr = cur.first + dy[i];
      long long int nc = cur.second + dx[i];
      bool ok = false;
      if (visited[make_pair(nr, nc)]) continue;
      auto range = sections.equal_range(nr);
      for (auto it = range.first; it != range.second; it++) {
        pair<long long int, long long int> sec = it->second;
        if (nc <= sec.second && nc >= sec.first) {
          ok = true;
          break;
        }
      }
      if (ok) {
        visited[make_pair(nr, nc)] = true;
        dist[make_pair(nr, nc)] = dist[cur] + 1;
        que.push(make_pair(nr, nc));
      }
    }
  }
  if (dist.find(target) == dist.end()) {
    cout << -1 << endl;
  } else {
    cout << dist[target] << endl;
  }
}
