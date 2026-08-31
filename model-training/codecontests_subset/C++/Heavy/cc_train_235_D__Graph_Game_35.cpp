#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T read() {
  register T sum = 0;
  register char cc = getchar();
  int sym = 1;
  while (cc != '-' && (cc > '9' || cc < '0')) cc = getchar();
  if (cc == '-') sym = -1, cc = getchar();
  sum = sum * 10 + cc - '0';
  cc = getchar();
  while (cc >= '0' && cc <= '9') sum = sum * 10 + cc - '0', cc = getchar();
  return sym * sum;
}
template <typename T>
inline T read(T &a) {
  a = read<T>();
  return a;
}
template <typename T, typename... Others>
inline void read(T &a, Others &...b) {
  a = read(a);
  read(b...);
}
struct Edge {
  int v;
  Edge *next;
  Edge(int a = 0, Edge *b = NULL) {
    v = a;
    next = b;
  }
} * head[3010];
int n, cnt, tp, sta[3010], in[3010], cir[3010], dep[3010], vis[3010], rnk[3010],
    col[3010];
double ans;
bool dfs1(int k, int fa) {
  sta[++tp] = k;
  vis[k] = true;
  for (Edge *i = head[k]; i != NULL; i = i->next) {
    if (i->v == fa) continue;
    if (vis[i->v]) {
      int x = 0;
      while (tp && x != i->v) {
        x = sta[tp--];
        cir[++cnt] = x;
        rnk[x] = cnt;
        in[x] = true;
      }
      return true;
    }
    if (dfs1(i->v, k)) return true;
  }
  vis[k] = false;
  tp -= 1;
  return false;
}
void dfs2(int k, int fa, int rt) {
  col[k] = rt;
  dep[k] = dep[fa] + 1;
  for (Edge *i = head[k]; i != NULL; i = i->next)
    if (i->v != fa && !in[i->v]) dfs2(i->v, k, rt);
}
void dfs3(int k, int fa, int dis) {
  ans += 1. / dis;
  for (Edge *i = head[k]; i != NULL; i = i->next)
    if (i->v != fa && (i->v == col[k] || !in[i->v])) dfs3(i->v, k, dis + 1);
}
int main() {
  read(n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    read(x, y);
    x += 1, y += 1;
    head[x] = new Edge(y, head[x]);
    head[y] = new Edge(x, head[y]);
  }
  dfs1(1, 0);
  for (int i = 1; i <= cnt; i++) dfs2(cir[i], 0, cir[i]);
  for (int i = 1; i <= n; i++) {
    dfs3(i, 0, 1);
    for (int j = 1; j <= n; j++) {
      if (col[i] == col[j]) continue;
      ans += 1. / (dep[i] + dep[j] + abs(rnk[col[i]] - rnk[col[j]]) - 1);
      ans += 1. / (dep[i] + dep[j] + cnt - abs(rnk[col[i]] - rnk[col[j]]) - 1);
      ans -= 1. / (dep[i] + dep[j] + cnt - 2);
    }
  }
  printf("%.10lf\n", ans);
  return 0;
}
