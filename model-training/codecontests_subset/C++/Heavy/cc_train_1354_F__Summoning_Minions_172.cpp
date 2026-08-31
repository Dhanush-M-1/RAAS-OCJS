#include <bits/stdc++.h>
#pragma GCC optimize(3, "Ofast", "inline")
#pragma GCC target("avx")
using namespace std;
inline char gc() {
  static char buf[1 << 16], *p1 = buf, *p2 = buf;
  if (p1 == p2) {
    p2 = (p1 = buf) + fread(buf, 1, 1 << 16, stdin);
    if (p2 == p1) return EOF;
  }
  return *p1++;
}
template <class t>
inline t read(t &x) {
  char c = gc();
  bool f = 0;
  x = 0;
  while (!isdigit(c)) f |= c == '-', c = gc();
  while (isdigit(c)) x = (x << 1) + (x << 3) + (c ^ 48), c = gc();
  if (f) x = -x;
  return x;
}
template <class t>
inline void write(t x) {
  if (x < 0)
    putchar('-'), write(-x);
  else {
    if (x > 9) write(x / 10);
    putchar('0' + x % 10);
  }
}
const int N = 205, M = 1e4 + 5, P = 80;
int en = 1, mc, mf, h[N], dis[N], n, k, ans[P];
bool v[N];
struct edge {
  int n, v, f, w;
} e[M << 1];
struct fafafa {
  int fa, id;
} pre[N];
void add(int x, int y, int f, int w) {
  e[++en] = (edge){h[x], y, f, w};
  h[x] = en;
}
bool spfa(int s, int t) {
  memset(v, 0, sizeof v);
  memset(pre, 0, sizeof pre);
  memset(dis, 0x3f, sizeof dis);
  queue<int> q;
  q.push(s);
  v[s] = 1;
  dis[s] = 0;
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    for (int i = h[x]; i; i = e[i].n) {
      int y = e[i].v;
      if (e[i].f && dis[x] + e[i].w < dis[y]) {
        dis[y] = dis[x] + e[i].w;
        pre[y] = (fafafa){x, i};
        if (!v[y]) {
          v[y] = 1;
          q.push(y);
        }
      }
    }
    v[x] = 0;
  }
  return dis[t] ^ 0x3f3f3f3f;
}
void mcmf(int s, int t) {
  while (spfa(s, t)) {
    int flow = INT_MAX;
    for (int i = t; i ^ s; i = pre[i].fa) flow = min(flow, e[pre[i].id].f);
    for (int i = t; i ^ s; i = pre[i].fa) {
      e[pre[i].id].f -= flow;
      e[pre[i].id ^ 1].f += flow;
    }
    mf += flow;
    mc += flow * dis[t];
  }
}
void exadd(int x, int y, int f, int w) {
  add(x, y, f, w);
  add(y, x, 0, -w);
}
void doit() {
  read(n);
  read(k);
  for (int i = 1; i <= n; i++) exadd(0, i, 1, 0), exadd(i + n, n * 2 + 1, 1, 0);
  for (int i = 1, a, b; i <= n; i++) {
    read(a);
    read(b);
    for (int j = 1, val; j <= n; j++) {
      if (j < k)
        val = a + (j - 1) * b;
      else if (j < n)
        val = (k - 1) * b;
      else
        val = a + (k - 1) * b;
      exadd(i, j + n, 1, -val);
    }
  }
  mcmf(0, n * 2 + 1);
  write(k + (n - k) * 2);
  puts("");
  for (int x = 1; x <= n; x++)
    for (int i = h[x]; i; i = e[i].n) {
      int y = e[i].v;
      if (y <= n) continue;
      if (!e[i].f) ans[y - n] = x;
    }
  for (int i = 1; i <= n; i++) {
    write(ans[i]);
    putchar(' ');
    if (i >= k && i < n) write(-ans[i]), putchar(' ');
  }
  puts("");
  en = 1;
  mc = mf = 0;
  for (int i = 0; i <= n * 2 + 1; i++) h[i] = 0;
}
signed main() {
  int t;
  read(t);
  while (t--) doit();
}
