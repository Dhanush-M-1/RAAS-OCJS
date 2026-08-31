#include <bits/stdc++.h>
const int mo = (int)1e9 + 7;
const int N = (int)1e5 + 5, logN = 17;
int n, q;
struct node;
struct edge {
  node *ed;
  edge *next;
  int w;
} E[N << 1], *newE = E;
struct data {
  long long sum2, sum, cnt;
  data operator*(long long t) {
    t %= mo;
    return (data){(sum2 + 2 * t * sum % mo + t * t % mo * cnt % mo) % mo,
                  (sum + t * cnt % mo) % mo, cnt};
  }
  void operator+=(const data &t) {
    (sum2 += t.sum2) %= mo;
    (sum += t.sum) %= mo;
    (cnt += t.cnt) %= mo;
  }
  void operator-=(const data &t) {
    (sum2 -= t.sum2) %= mo;
    (sum -= t.sum) %= mo;
    (cnt -= t.cnt) %= mo;
  }
};
struct node {
  edge *son;
  node *pa[logN];
  int dep;
  long long depth;
  data s, a;
  void dfs() {
    for (int j = 1; j < logN; j++) pa[j] = pa[j - 1]->pa[j - 1];
    s.cnt = 1;
    for (edge *e = son; e; e = e->next)
      if (e->ed != pa[0]) {
        e->ed->pa[0] = this;
        e->ed->dep = dep + 1;
        e->ed->depth = depth + e->w;
        e->ed->dfs();
        s += e->ed->s * e->w;
      }
  }
  void dfs2(data now) {
    now += s;
    a = now;
    for (edge *e = son; e; e = e->next)
      if (e->ed != pa[0]) {
        now -= e->ed->s * e->w;
        e->ed->dfs2(now * e->w);
        now += e->ed->s * e->w;
      }
  }
} V[N];
node *lca(node *u, node *v) {
  for (int j = logN - 1; j >= 0; j--)
    if (u->pa[j]->dep >= v->dep) u = u->pa[j];
  for (int j = logN - 1; j >= 0; j--)
    if (v->pa[j]->dep >= u->dep) v = v->pa[j];
  for (int j = logN - 1; j >= 0; j--)
    if (u->pa[j] != v->pa[j]) u = u->pa[j], v = v->pa[j];
  if (u == v) return u;
  return u->pa[0];
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int x, y, w;
    scanf("%d%d%d", &x, &y, &w);
    *newE = (edge){V + y, V[x].son, w}, V[x].son = newE++;
    *newE = (edge){V + x, V[y].son, w}, V[y].son = newE++;
  }
  for (int j = 0; j < logN; j++) V[1].pa[j] = V + 1;
  V[1].dfs();
  V[1].dfs2((data){0, 0, 0});
  scanf("%d", &q);
  while (q--) {
    int x, y;
    scanf("%d%d", &x, &y);
    node *w = lca(V + x, V + y);
    long long d = V[x].depth + V[y].depth - w->depth * 2;
    data a = V[y].s * d;
    if (w == V + y) {
      data c = V[y].a;
      c -= V[y].s;
      a = V[x].a;
      a -= c * d;
    }
    data b = V[x].a;
    b -= a;
    a -= b;
    printf("%I64d\n", (a.sum2 + mo) % mo);
  }
}
