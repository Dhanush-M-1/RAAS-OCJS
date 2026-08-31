#include <bits/stdc++.h>
namespace input {
const int size = 1 << 24;
char buf[size], *p1, *p2;
template <class type>
void inline read(type &a) {
  int c = (p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, size, stdin), p1 == p2)
               ? EOF
               : *p1++);
  for (; !(c >= '0' && c <= '9');
       c = (p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, size, stdin), p1 == p2)
                ? EOF
                : *p1++))
    ;
  for (a = 0; (c >= '0' && c <= '9'); a *= 10, a += c ^ 48,
      c = (p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, size, stdin), p1 == p2)
               ? EOF
               : *p1++))
    ;
}
};  // namespace input
namespace output {
const int size = 1 << 24;
char d[20], puf[size], *p = puf;
template <class type>
void inline write(type a, char c = '\n') {
  int s = 0;
  d[0] = 0;
  for (; a; d[s++] = a % 10, a /= 10)
    ;
  for (s = s ? s : 1; s;
       (*p++ = d[--s] + 48,
       p - puf == size ? (fwrite(puf, 1, p - puf, stdout), p = puf) : 0))
    ;
  (*p++ = c, p - puf == size ? (fwrite(puf, 1, p - puf, stdout), p = puf) : 0);
}
};  // namespace output
using namespace std;
using namespace input;
using namespace output;
const int nsz = 1e5, msz = 3e5, lgsz = 17;
const long long inf = 0x3f3f3f3f3f3f3f3f;
bool vis[nsz + 5];
int n, m, k, q, rt = 1, fm[nsz + 5];
int t, pr[nsz + 5], dep[nsz + 5], siz[nsz + 5], hs[nsz + 5], top[nsz + 5],
    id[nsz + 5];
long long dis[nsz + 5], w[nsz + 5];
struct edge {
  int nxt, fm, to;
  long long w;
  edge(int nxt = 0, int fm = 0, int to = 0, long long w = 0) {
    this->nxt = nxt, this->fm = fm, this->to = to, this->w = w;
  }
  bool inline operator<(const edge oth) const { return this->w < oth.w; }
};
struct graph {
  int sz, hd[nsz + 5];
  edge e[2 * msz + 5];
  void inline connect(int u, int v, long long w) {
    e[++sz] = edge(hd[u], u, v, w), hd[u] = sz;
    e[++sz] = edge(hd[v], v, u, w), hd[v] = sz;
  }
};
graph g, tr;
bool inline cmp(pair<long long, int> a, pair<long long, int> b) {
  return a.first > b.first;
}
struct heap {
  int sz;
  pair<long long, int> h[msz + 5];
  heap() { sz = 0; }
  void inline push(pair<long long, int> e) {
    h[sz++] = e;
    push_heap(h, h + sz, cmp);
  }
  pair<long long, int> inline get() {
    pop_heap(h, h + sz, cmp);
    return h[--sz];
  }
};
heap h;
struct union_find {
  int pr[nsz + 5];
  void inline init() {
    for (int u = 1; u <= k; ++u) {
      pr[u] = u;
    }
  }
  int qry(int u) { return pr[u] == u ? u : pr[u] = qry(pr[u]); }
  bool inline unite(int u, int v) {
    int pu = qry(u), pv = qry(v);
    if (pu == pv) return 0;
    pr[pv] = pu;
    return 1;
  }
};
union_find uf;
struct sparse_table {
  int lg[nsz + 5];
  long long st[nsz + 5][lgsz + 5];
  void inline init() {
    for (int i = 1; i <= n; ++i) {
      lg[i] = lg[i >> 1] + 1;
      st[id[i]][0] = w[i];
    }
    for (int k = 1; k <= lg[n]; ++k) {
      for (int u = 1; u <= n; ++u) {
        if (u + (1 << k) - 1 > n) break;
        int p = u + (1 << (k - 1));
        st[u][k] = max(st[u][k - 1], st[p][k - 1]);
      }
    }
  }
  long long inline qry(int l, int r) {
    int k = lg[r - l + 1] - 1, len = 1 << k;
    return max(st[l][k], st[r - len + 1][k]);
  }
};
sparse_table st;
void inline dijkstra() {
  memset(vis, 0, sizeof(vis));
  memset(dis, inf, sizeof(dis));
  for (int u = 1; u <= k; ++u) {
    fm[u] = u;
    h.push(make_pair(dis[u] = 0, u));
  }
  for (; h.sz;) {
    int u = h.get().second;
    for (int i = g.hd[u]; i; i = g.e[i].nxt) {
      int v = g.e[i].to;
      long long w = g.e[i].w;
      if (vis[v]) continue;
      if (dis[v] > dis[u] + w) {
        fm[v] = fm[u];
        h.push(make_pair(dis[v] = dis[u] + w, v));
      }
    }
  }
}
void inline kruskal() {
  for (int i = 1; i <= g.sz; ++i) {
    int u = g.e[i].fm, v = g.e[i].to;
    g.e[i].w += dis[u] + dis[v];
  }
  sort(g.e + 1, g.e + g.sz + 1);
  uf.init();
  for (int i = 1; i <= g.sz; ++i) {
    int u = fm[g.e[i].fm], v = fm[g.e[i].to];
    long long w = g.e[i].w;
    if (uf.unite(u, v)) {
      tr.connect(u, v, w);
    }
  }
}
void dfs1(int u = rt) {
  siz[u] = 1;
  for (int i = tr.hd[u]; i; i = tr.e[i].nxt) {
    int v = tr.e[i].to;
    long long w = tr.e[i].w;
    if (v == pr[u]) continue;
    pr[v] = u;
    ::w[v] = w;
    dep[v] = dep[u] + 1;
    dfs1(v);
    siz[u] += siz[v];
    if (siz[hs[u]] < siz[v]) {
      hs[u] = v;
    }
  }
}
void dfs2(int u = rt, int tp = rt) {
  id[u] = ++t;
  top[u] = tp;
  if (!hs[u]) return;
  dfs2(hs[u], tp);
  for (int i = tr.hd[u]; i; i = tr.e[i].nxt) {
    int v = tr.e[i].to;
    if (v == pr[u] || v == hs[u]) continue;
    dfs2(v, v);
  }
}
long long inline qry(int u, int v) {
  long long res = 0;
  for (; top[u] != top[v]; v = pr[top[v]]) {
    if (dep[top[u]] > dep[top[v]]) {
      swap(u, v);
    }
    res = max(res, st.qry(id[top[v]], id[v]));
  }
  if (dep[u] > dep[v]) {
    swap(u, v);
  }
  if (id[u] + 1 <= id[v]) {
    res = max(res, st.qry(id[u] + 1, id[v]));
  }
  return res;
}
void inline init() {
  dijkstra();
  kruskal();
  dfs1();
  dfs2();
  st.init();
}
int main() {
  read(n), read(m), read(k), read(q);
  for (int i = 1; i <= m; ++i) {
    int u, v, w;
    read(u), read(v), read(w);
    g.connect(u, v, w);
  }
  init();
  for (int i = 1; i <= q; ++i) {
    int u, v;
    read(u), read(v);
    write(qry(u, v));
  }
  (fwrite(puf, 1, p - puf, stdout), p = puf);
}
