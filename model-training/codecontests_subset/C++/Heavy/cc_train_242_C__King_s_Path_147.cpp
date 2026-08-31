#include <bits/stdc++.h>
using namespace std;
set<pair<int, int> > allowed;
int bfs(pair<int, int> start, pair<int, int> end) {
  queue<pair<int, int> > q;
  pair<int, int> cur;
  int level = 0;
  q.push(start);
  allowed.erase(start);
  while (q.size()) {
    int sz = q.size();
    for (auto i = 0; i < (sz); i++) {
      cur = q.front();
      q.pop();
      if (cur == end) {
        return level;
      }
      if (allowed.find({cur.first, cur.second + 1}) != allowed.end()) {
        q.push({cur.first, cur.second + 1});
        allowed.erase({cur.first, cur.second + 1});
      }
      if (allowed.find({cur.first, cur.second - 1}) != allowed.end()) {
        q.push({cur.first, cur.second - 1});
        allowed.erase({cur.first, cur.second - 1});
      }
      if (allowed.find({cur.first + 1, cur.second + 1}) != allowed.end()) {
        q.push({cur.first + 1, cur.second + 1});
        allowed.erase({cur.first + 1, cur.second + 1});
      }
      if (allowed.find({cur.first + 1, cur.second}) != allowed.end()) {
        q.push({cur.first + 1, cur.second});
        allowed.erase({cur.first + 1, cur.second});
      }
      if (allowed.find({cur.first + 1, cur.second - 1}) != allowed.end()) {
        q.push({cur.first + 1, cur.second - 1});
        allowed.erase({cur.first + 1, cur.second - 1});
      }
      if (allowed.find({cur.first - 1, cur.second + 1}) != allowed.end()) {
        q.push({cur.first - 1, cur.second + 1});
        allowed.erase({cur.first - 1, cur.second + 1});
      }
      if (allowed.find({cur.first - 1, cur.second}) != allowed.end()) {
        q.push({cur.first - 1, cur.second});
        allowed.erase({cur.first - 1, cur.second});
      }
      if (allowed.find({cur.first - 1, cur.second - 1}) != allowed.end()) {
        q.push({cur.first - 1, cur.second - 1});
        allowed.erase({cur.first - 1, cur.second - 1});
      }
    }
    level++;
  }
  return -1;
}
int main() {
  int sx, sy, ex, ey;
  cin >> sx >> sy >> ex >> ey;
  int a0;
  cin >> a0;
  for (auto i = 0; i < (a0); i++) {
    int r, a, b;
    cin >> r >> a >> b;
    for (int i = a; i <= b; i++) {
      allowed.insert({r, i});
    }
  }
  cout << bfs({sx, sy}, {ex, ey});
}
