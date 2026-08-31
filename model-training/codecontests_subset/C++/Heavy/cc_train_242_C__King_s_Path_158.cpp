#include <bits/stdc++.h>
const double eps = 1e-11;
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
using namespace std;
const int maxn = 1000000000;
int sx, sy, ex, ey;
set<pair<int, int> > mySet;
map<pair<int, int>, int> myMap;
bool judge(int x, int y) {
  if (x >= 1 && x <= 1000000000 && y >= 1 && y <= 1000000000) return true;
  return false;
}
int bfs() {
  queue<pair<int, int> > Q;
  Q.push(make_pair(sx, sy));
  myMap[make_pair(sx, sy)] = 0;
  pair<int, int> pre, cur;
  while (!Q.empty()) {
    pre = Q.front();
    Q.pop();
    if (pre.first == ex && pre.second == ey) return myMap[pre];
    for (int k = 0; k < (8); k++) {
      cur.first = pre.first + dx[k];
      cur.second = pre.second + dy[k];
      if (judge(cur.first, cur.second) && mySet.find(cur) != mySet.end()) {
        if (myMap.find(cur) != myMap.end()) continue;
        myMap[cur] = myMap[pre] + 1;
        Q.push(cur);
      }
    }
  }
  return -1;
}
void solve() {
  int sol = bfs();
  printf("%d\n", sol);
}
int main() {
  while (scanf("%d%d%d%d", &sx, &sy, &ex, &ey) == 4) {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < (n); i++) {
      int r, x, y;
      scanf("%d%d%d", &r, &x, &y);
      for (int i = (x); i < (y + 1); i++) {
        mySet.insert(make_pair(r, i));
      }
    }
    solve();
  }
  return 0;
}
