#include <bits/stdc++.h>
using namespace std;
struct data {
  int y, z, nxt;
} e[600010];
struct edge {
  int x, y;
  long long z;
} a[300010];
struct qwq {
  long long dis;
  int x;
};
struct que {
  int x, y, id;
} b[300010];
vector<que> v[200010];
bool operator<(const qwq &u, const qwq &v) { return u.dis > v.dis; }
long long ans[300010];
long long dis[200010];
int siz[200010];
int head[200010];
bool vis[200010];
int f[200010];
priority_queue<qwq> q;
int n, m, k, Q, cnt;
void add(int x, int y, long long z) {
  cnt++;
  e[cnt].y = y;
  e[cnt].z = z;
  e[cnt].nxt = head[x];
  head[x] = cnt;
}
bool cmp(edge x, edge y) { return x.z < y.z; }
int find(int x) { return x != f[x] ? f[x] = find(f[x]) : x; }
void dijkstra() {
  for (int i = 1; i <= k; i++) {
    q.push((qwq){0, i});
    dis[i] = 0;
  }
  while (!q.empty()) {
    qwq x = q.top();
    q.pop(), vis[x.x] = 0;
    for (int i = head[x.x]; i; i = e[i].nxt) {
      int y = e[i].y, z = e[i].z;
      if (dis[y] > dis[x.x] + z) {
        dis[y] = dis[x.x] + z;
        if (!vis[y]) {
          q.push((qwq){dis[y], y});
          vis[y] = true;
        }
      }
    }
  }
}
int main() {
  int x, y, z;
  scanf("%d%d%d%d", &n, &m, &k, &Q);
  for (int i = 1; i <= n; i++) {
    dis[i] = 1e17;
    f[i] = i, siz[i] = 1;
  }
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%lld", &a[i].x, &a[i].y, &a[i].z);
    add(a[i].x, a[i].y, a[i].z);
    add(a[i].y, a[i].x, a[i].z);
  }
  dijkstra();
  for (int i = 1; i <= m; i++) a[i].z += dis[a[i].x] + dis[a[i].y];
  sort(a + 1, a + m + 1, cmp);
  for (int i = 1; i <= Q; i++) {
    b[i].id = i;
    scanf("%d%d", &b[i].x, &b[i].y);
    v[b[i].x].push_back(b[i]);
    v[b[i].y].push_back(b[i]);
  }
  for (int i = 1; i <= m; i++) {
    int x = a[i].x, y = a[i].y;
    long long z = a[i].z;
    int fx = find(x), fy = find(y);
    if (fx == fy) continue;
    if (siz[fx] < siz[fy]) swap(fx, fy);
    f[fy] = fx, siz[fx] += siz[fy];
    for (int j = 0; j < v[fy].size(); j++) {
      if (find(v[fy][j].x) == find(v[fy][j].y) && !ans[v[fy][j].id])
        ans[v[fy][j].id] = z;
      else
        v[fx].push_back(v[fy][j]);
    }
  }
  for (int i = 1; i <= Q; i++) printf("%lld\n", ans[i]);
}
