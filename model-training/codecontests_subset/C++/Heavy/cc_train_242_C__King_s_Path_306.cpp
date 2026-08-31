#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
set<pair<int, int>> segments;
const pair<int, int> dirs[] = {{-1, 0}, {1, 0},   {0, 1},  {0, -1},
                               {1, 1},  {-1, -1}, {1, -1}, {-1, 1}};
int bfs(pair<int, int> s, pair<int, int> d) {
  map<pair<int, int>, int> level;
  queue<pair<int, int>> Q;
  level[s] = 0;
  Q.push(s);
  while (!Q.empty()) {
    auto p = Q.front();
    Q.pop();
    if (p == d) return level[d];
    for (auto d : dirs) {
      int r = p.first + d.first;
      int c = p.second + d.second;
      if (!segments.count({r, c})) continue;
      if (level.count({r, c}) == 1) continue;
      level[{r, c}] = level[p] + 1;
      Q.emplace(r, c);
    }
  }
  return -1;
}
int main() {
  pair<int, int> start, dest;
  cin >> start.first >> start.second >> dest.first >> dest.second;
  int n;
  cin >> n;
  while (n--) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int c = a; c <= b; c++) {
      segments.emplace(r, c);
    }
  }
  int moves = bfs(start, dest);
  cout << moves << endl;
  return 0;
}
