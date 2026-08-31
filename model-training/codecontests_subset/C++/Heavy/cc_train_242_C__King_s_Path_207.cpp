#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int dx[10] = {0, 0, 1, 1, -1, -1, 1, -1};
int dy[10] = {1, -1, 1, -1, 1, -1, 0, 0};
struct point {
  int x, y;
  bool operator<(const point &p) const {
    if (x == p.x) return y < p.y;
    return x < p.x;
  }
  point(int xx = 0, int yy = 0) {
    x = xx;
    y = yy;
  }
};
map<point, int> vk;
map<point, int> vis;
struct node {
  int x, y;
  int step;
} st;
int x0, shduiqy, x1, sdjqwie, n, ans;
void bfs() {
  queue<node> que;
  point gk;
  gk.x = x0, gk.y = shduiqy;
  vis[gk] = 1;
  st.x = x0, st.y = shduiqy;
  st.step = 0;
  que.push(st);
  ans = -1;
  while (!que.empty()) {
    node k = que.front();
    que.pop();
    if (k.x == x1 && k.y == sdjqwie) {
      ans = k.step;
      break;
    }
    for (int i = 0; i < 8; i++) {
      int xx = k.x + dx[i];
      int yy = k.y + dy[i];
      gk.x = xx, gk.y = yy;
      if (vk[gk] && vis[gk] == 0) {
        node kk;
        kk.x = xx, kk.y = yy;
        kk.step = k.step + 1;
        vis[gk] = 1;
        que.push(kk);
      }
    }
  }
  printf("%d\n", ans);
}
int main() {
  scanf("%d%d%d%d", &x0, &shduiqy, &x1, &sdjqwie);
  scanf("%d", &n);
  int g, l, r;
  for (int i = 1; i <= n; i++) {
    point gk;
    scanf("%d%d%d", &g, &l, &r);
    for (int i = l; i <= r; i++) vk[point(g, i)] = 1;
  }
  bfs();
}
