#include <bits/stdc++.h>
using namespace std;
int INF = 2000000000;
double EPS = 1e-8;
int dist(int x0, int y0, int x1, int y1) {
  return max(x0, x1) - min(x0, x1) + max(y0, y1) - min(y0, y1);
}
int dx[8] = {0, 0, 1, -1, 1, -1, 1, -1};
int dy[8] = {1, -1, 0, 0, 1, -1, -1, 1};
struct P {
  int c, y, x;
  P(int c, int y, int x) : c(c), y(y), x(x) {}
  bool operator<(const P &p) const { return c > p.c; }
};
int main() {
  int x0, y0, x1, y1;
  scanf("%d %d %d %d", &y0, &x0, &y1, &x1);
  if (dist(y0, x0, y1, x1) > 100000) {
    puts("-1");
    return 0;
  }
  int n;
  scanf("%d", &n);
  vector<int> r(n), a(n), b(n);
  int h = INF, H = 0, w = INF, W = 0;
  for (int i = 0; i < n; ++i) {
    scanf("%d %d %d", &r[i], &a[i], &b[i]);
    w = min(w, a[i]);
    W = max(W, b[i]);
    h = min(h, r[i]);
    H = max(H, r[i]);
  }
  map<int, map<int, bool> > s;
  for (int i = 0; i < n; ++i) {
    for (int j = a[i]; j < b[i] + 1; ++j) s[r[i] - h][j - w] = 1;
  }
  y0 -= h, x0 -= w, y1 -= h, x1 -= w;
  priority_queue<P> q;
  q.push(P(0, y0, x0));
  while (!q.empty()) {
    P p = q.top();
    q.pop();
    if (p.y == y1 && p.x == x1) {
      printf("%d\n", p.c);
      return 0;
    }
    for (int i = 0; i < 8; ++i) {
      int ny = p.y + dy[i];
      int nx = p.x + dx[i];
      if (ny >= 0 && ny <= H - h && nx >= 0 && nx <= W - w) {
        if (s[ny][nx]) {
          q.push(P(p.c + 1, ny, nx));
          s[ny][nx] = 0;
        }
      }
    }
  }
  puts("-1");
  return 0;
}
