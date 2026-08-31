#include <bits/stdc++.h>
using namespace std;
const int dx[] = {1, 1, 1, -1, -1, -1, 0, 0};
const int dy[] = {1, 0, -1, 1, 0, -1, 1, -1};
int x0, yy0, x1, yy1, n;
struct point {
  int x, y;
  friend bool operator<(const point &a, const point &b) {
    if (a.x == b.x) return a.y < b.y;
    return a.x < b.x;
  }
} p[100001];
map<point, int> d;
map<point, bool> bo;
queue<point> q;
point s, t;
int main(int argc, char *argv[]) {
  scanf("%d%d%d%d", &s.x, &s.y, &t.x, &t.y);
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    int r, a, b;
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; ++j) {
      point x;
      x.x = r;
      x.y = j;
      d[x] = -1;
    }
  }
  d[s] = 0;
  bo[s] = 1;
  q.push(s);
  while (!q.empty()) {
    point x = q.front();
    q.pop();
    bo[x] = 0;
    for (int i = 0; i < 8; ++i) {
      point u;
      u.x = x.x + dx[i];
      u.y = x.y + dy[i];
      if (d[u] == -1) {
        d[u] = d[x] + 1;
        if (!bo[u]) {
          q.push(u);
          bo[u] = 1;
        }
      }
    }
  }
  cout << d[t] << endl;
  return 0;
}
