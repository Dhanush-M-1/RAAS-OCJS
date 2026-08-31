#include <bits/stdc++.h>
using namespace std;
struct IO {
  char buf[(1 << 20)], *p1, *p2;
  char pbuf[(1 << 20)], *pp;
  IO() : p1(buf), p2(buf), pp(pbuf) {}
  inline char gc() {
    return getchar();
    if (p1 == p2) p2 = (p1 = buf) + fread(buf, 1, (1 << 20), stdin);
    return p1 == p2 ? ' ' : *p1++;
  }
  inline bool blank(char ch) {
    return ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t';
  }
  template <class T>
  inline void read(T &x) {
    register double tmp = 1;
    register bool sign = 0;
    x = 0;
    register char ch = gc();
    for (; !(ch >= '0' && ch <= '9'); ch = gc())
      if (ch == '-') sign = 1;
    for (; (ch >= '0' && ch <= '9'); ch = gc()) x = x * 10 + (ch - '0');
    if (ch == '.')
      for (ch = gc(); (ch >= '0' && ch <= '9'); ch = gc())
        tmp /= 10.0, x += tmp * (ch - '0');
    if (sign) x = -x;
  }
  inline void read(char *s) {
    register char ch = gc();
    for (; blank(ch); ch = gc())
      ;
    for (; !blank(ch); ch = gc()) *s++ = ch;
    *s = 0;
  }
  inline void read(char &c) {
    for (c = gc(); blank(c); c = gc())
      ;
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
} io;
const int mod = 1e9 + 7;
const int mo = 998244353;
const int N = 1e6 + 5;
int n, m, x, Mx, father[N], md[N], siz[N], dep[N];
vector<int> h[N];
inline void dfs(int u) {
  int sz = (int)h[u].size() - 1;
  for (int i = (0); i <= (sz); i++) {
    int v = h[u][i];
    if (v == father[u]) continue;
    dep[v] = dep[u] + 1;
    dfs(v);
  }
}
inline void dfs1(int u) {
  int sz = (int)h[u].size() - 1;
  md[u] = 1e9;
  if (u != 1 && !sz) md[u] = dep[u];
  for (int i = (0); i <= (sz); i++) {
    int v = h[u][i];
    if (v == father[u]) continue;
    dfs1(v);
    md[u] = min(md[u], md[v]);
  }
}
inline void dfs2(int u) {
  int sz = (int)h[u].size() - 1;
  if (u != 1 && !sz) siz[u] = 1;
  for (int i = (0); i <= (sz); i++) {
    int v = h[u][i];
    if (v == father[u]) continue;
    dfs2(v);
    if (md[v] - dep[u] <= m) siz[u] += siz[v], siz[v] = 0;
  }
}
inline int dfs3(int u) {
  int sz = (int)h[u].size() - 1;
  int mx = 0;
  for (int i = (0); i <= (sz); i++) {
    int v = h[u][i];
    if (v == father[u]) continue;
    mx = max(mx, dfs3(v));
  }
  return siz[u] + mx;
}
int main() {
  io.read(n), io.read(m);
  for (int i = (2); i <= (n); i++)
    io.read(father[i]), h[father[i]].push_back(i), h[i].push_back(father[i]);
  dfs(1);
  dfs1(1);
  dfs2(1);
  int sz = (int)h[1].size() - 1;
  for (int i = (0); i <= (sz); i++) Mx = max(Mx, dfs3(h[1][i]));
  io.write(siz[1] + Mx), puts("");
  return 0;
}
