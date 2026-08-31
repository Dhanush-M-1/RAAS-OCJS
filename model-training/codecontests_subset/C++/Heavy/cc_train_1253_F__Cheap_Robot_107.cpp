#include <bits/stdc++.h>
using namespace std;
struct tree_edge {
  int u, v;
  long long w;
  bool friend operator<(tree_edge i, tree_edge j) { return i.w < j.w; }
} edg[100039 * 3];
struct point {
  int u, v;
  long long w;
  bool friend operator<(point i, point j) { return i.w > j.w; }
} stp;
struct edge {
  int to, next;
  long long w;
} grap[100039 << 3], tree[100039 << 1];
int n, m, k, q, tot[2], head[2][100039], fro[100039], fa[100039], dep[100039],
    gra[100039][17];
long long dis[100039], mx[100039][17];
priority_queue<point> que;
void add(edge net[], int s, int u, int v, long long w) {
  net[++tot[s]] = (edge){v, head[s][u], w}, head[s][u] = tot[s];
  net[++tot[s]] = (edge){u, head[s][v], w}, head[s][v] = tot[s];
}
void dijkstra() {
  que.push((point){0, 0, 0});
  while (!que.empty()) {
    stp = que.top(), que.pop();
    if (dis[stp.v] == dis[n + 1]) {
      dis[stp.v] = stp.w;
      fro[stp.v] = (stp.v <= k ? stp.v : fro[stp.u]);
      for (int a = head[0][stp.v]; a; a = grap[a].next) {
        if (dis[grap[a].to] == dis[n + 1]) {
          que.push((point){stp.v, grap[a].to, stp.w + grap[a].w});
        }
      }
    }
  }
}
int find(int k) { return fa[k] == k ? k : fa[k] = find(fa[k]); }
void dfs(int pos) {
  dep[pos] = dep[gra[pos][0]] + 1;
  for (int a = 1, b = 2; b <= dep[pos]; a++, b <<= 1) {
    gra[pos][a] = gra[gra[pos][a - 1]][a - 1];
    mx[pos][a] = max(mx[pos][a - 1], mx[gra[pos][a - 1]][a - 1]);
  }
  for (int a = head[1][pos]; a; a = tree[a].next) {
    if (tree[a].to != gra[pos][0]) {
      gra[tree[a].to][0] = pos;
      mx[tree[a].to][0] = tree[a].w;
      dfs(tree[a].to);
    }
  }
}
long long get_ans(int u, int v) {
  long long res = 0;
  if (dep[u] < dep[v]) swap(u, v);
  for (int a = 16; ~a; a--) {
    if (dep[gra[u][a]] >= dep[v]) {
      res = max(res, mx[u][a]);
      u = gra[u][a];
    }
  }
  if (u == v) return res;
  for (int a = 16; ~a; a--) {
    if (gra[u][a] != gra[v][a]) {
      res = max(res, mx[u][a]), u = gra[u][a];
      res = max(res, mx[v][a]), v = gra[v][a];
    }
  }
  res = max(res, mx[u][0]);
  res = max(res, mx[v][0]);
  return res;
}
int main() {
  memset(dis, 63, sizeof(dis));
  scanf("%d%d%d%d", &n, &m, &k, &q);
  for (int a = 1, b, c, d; a <= m; a++) {
    scanf("%d%d%d", &b, &c, &d);
    add(grap, 0, b, c, d);
  }
  for (int a = 1; a <= k; a++) {
    add(grap, 0, 0, a, 0);
  }
  dijkstra();
  for (int a = 1; a <= n; a++) {
    for (int b = head[0][a]; b; b = grap[b].next) {
      if (grap[b].to && b % 2) {
        edg[b / 2 + 1].u = fro[a], edg[b / 2 + 1].v = fro[grap[b].to];
        edg[b / 2 + 1].w = dis[a] + grap[b].w + dis[grap[b].to];
      }
    }
    fa[a] = a;
  }
  sort(edg + 1, edg + m + 1);
  for (int a = 1, b, c; a <= m; a++) {
    b = find(edg[a].u), c = find(edg[a].v);
    if (b != c) {
      add(tree, 1, edg[a].u, edg[a].v, edg[a].w);
      fa[c] = b;
    }
  }
  dep[0] = -1, dfs(1);
  for (int a = 1, b, c; a <= q; a++) {
    scanf("%d%d", &b, &c);
    printf("%I64d\n", get_ans(b, c));
  }
  return 0;
}
