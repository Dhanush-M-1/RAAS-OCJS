#include <bits/stdc++.h>
using namespace std;
struct v {
  int x, y, s;
} t, e;
pair<int, int> p;
set<pair<int, int> > S;
queue<v> q;
int d[8][2] = {1, 0, 1, 1, 0, 1, -1, 1, -1, 0, -1, -1, 0, -1, 1, -1};
int main() {
  int i, j, k, x1, y1, x2, y2, n, a, b, r;
  scanf("%d%d%d%d%d", &x1, &y1, &x2, &y2, &n);
  while (n--) {
    scanf("%d%d%d", &r, &a, &b);
    for (i = a; i <= b; i++) S.insert(pair<int, int>(r, i));
  }
  t.x = x1;
  t.y = y1;
  t.s = 0;
  q.push(t);
  S.erase(pair<int, int>(x1, y1));
  while (!q.empty()) {
    t = q.front();
    q.pop();
    for (i = 0; i < 8; i++) {
      e.x = t.x + d[i][0];
      e.y = t.y + d[i][1];
      e.s = t.s + 1;
      if (e.x == x2 && e.y == y2) {
        printf("%d\n", e.s);
        return 0;
      }
      if (S.find(pair<int, int>(e.x, e.y)) != S.end()) {
        S.erase(pair<int, int>(e.x, e.y));
        e.s = t.s + 1;
        q.push(e);
      }
    }
  }
  printf("-1\n");
  return 0;
}
