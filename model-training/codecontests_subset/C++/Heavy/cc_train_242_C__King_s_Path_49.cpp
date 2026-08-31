#include <bits/stdc++.h>
using namespace std;
int const MAX = 999999999;
class Point {
 public:
  int x, y;
  Point(int _x = 0, int _y = 0) { x = _x, y = _y; }
  bool operator<(const Point &p) const {
    if (y == p.y) return x < p.x;
    return y < p.y;
  }
  bool operator==(const Point &p) const { return x == p.x && y == p.y; }
};
class hasher {
 public:
  unsigned operator()(const Point p) const {
    hash<int> h;
    return h(p.x) + h(p.y);
  }
};
Point s, t;
unordered_map<Point, int, hasher> ma;
int m, r, a, b;
int dir[8][2] = {0, 1, 0, -1, 1, 0, -1, 0, 1, 1, 1, -1, -1, 1, -1, -1};
int main() {
  scanf("%d%d%d%d", &s.x, &s.y, &t.x, &t.y);
  scanf("%d", &m);
  while (m--) {
    scanf("%d%d%d", &r, &a, &b);
    Point p(r, a);
    while (p.y <= b) {
      ma[p] = MAX;
      p.y++;
    }
  }
  Point p;
  queue<Point> que;
  que.push(s);
  unordered_map<Point, int, hasher>::iterator it, it2;
  it = ma.find(s);
  it->second = 0;
  while (!que.empty()) {
    p = que.front();
    que.pop();
    it = ma.find(p);
    for (int i = 0; i < 8; i++) {
      Point q(p.x + dir[i][0], p.y + dir[i][1]);
      it2 = ma.find(q);
      if (it2 != ma.end() && it2->second > it->second + 1) {
        it2->second = it->second + 1;
        que.push(it2->first);
      }
    }
  }
  it = ma.find(t);
  if (it->second == MAX)
    printf("-1\n");
  else
    printf("%d\n", it->second);
  return 0;
}
