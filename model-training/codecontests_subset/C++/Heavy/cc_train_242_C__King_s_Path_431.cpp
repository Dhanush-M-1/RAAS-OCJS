#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const long long INF = 2e18;
const int N = 521234;
int n, m;
map<pair<int, int>, int> mp;
int r[N], a[N], b[N];
struct Edge {
  int v, next;
} edge[N * 2];
int tot;
int head[N];
void init() {
  tot = 0;
  memset(head, -1, sizeof(head));
}
int mx[8] = {0, 1, -1, 0, 1, 1, -1, -1};
int my[8] = {1, 0, 0, -1, 1, -1, 1, -1};
void addedge(int u, int v) {
  edge[tot].v = v;
  edge[tot].next = head[u];
  head[u] = tot++;
}
void add(int x, int y) {
  int u = mp[pair<int, int>(x, y)];
  for (int i = 0; i < 8; ++i) {
    int tx = x + mx[i];
    int ty = y + my[i];
    int v = mp[pair<int, int>(tx, ty)];
    if (v) addedge(u, v);
  }
}
int vis[N];
int bfs(int x) {
  memset(vis, 0, sizeof(vis));
  queue<pair<int, int> > q;
  while (!q.empty()) q.pop();
  q.push(pair<int, int>(x, 0));
  vis[x] = 1;
  int ans = 0;
  while (!q.empty()) {
    pair<int, int> p = q.front();
    q.pop();
    if (p.first == 2) return p.second;
    for (int i = head[p.first]; i != -1; i = edge[i].next) {
      if (vis[edge[i].v]) continue;
      vis[edge[i].v] = 1;
      q.push(pair<int, int>(edge[i].v, p.second + 1));
    }
  }
  return -1;
}
int main() {
  int x1, y1, x2, y2;
  while (scanf("%d%d%d%d", &x1, &y1, &x2, &y2) != EOF) {
    int i, j;
    scanf("%d", &n);
    mp.clear();
    init();
    m = 0;
    mp[pair<int, int>(x1, y1)] = ++m;
    mp[pair<int, int>(x2, y2)] = ++m;
    for (i = 0; i < n; ++i) {
      scanf("%d%d%d", &r[i], &a[i], &b[i]);
      for (j = a[i]; j <= b[i]; ++j)
        if (!mp[pair<int, int>(r[i], j)]) mp[pair<int, int>(r[i], j)] = ++m;
    }
    add(x1, y1);
    add(x2, y2);
    for (i = 0; i < n; ++i) {
      for (j = a[i]; j <= b[i]; ++j) {
        add(r[i], j);
      }
    }
    int ans = bfs(1);
    printf("%d\n", ans);
  }
}
