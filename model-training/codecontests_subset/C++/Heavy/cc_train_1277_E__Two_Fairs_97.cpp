#include <bits/stdc++.h>
using namespace std;
char buf[1 << 20], *_ = buf, *__ = buf;
template <class T>
inline bool read(T &x) {
  x = 0;
  char c = (_ == __ && (__ = (_ = buf) + fread(buf, 1, 1 << 20, stdin), _ == __)
                ? EOF
                : *_++);
  bool f = 0;
  while (c < 48 || c > 57) {
    if (c == EOF) return 0;
    f ^= (c == '-'),
        c = (_ == __ &&
                     (__ = (_ = buf) + fread(buf, 1, 1 << 20, stdin), _ == __)
                 ? EOF
                 : *_++);
  }
  while (47 < c && c < 58)
    x = (x << 3) + (x << 1) + (c ^ 48),
    c = (_ == __ && (__ = (_ = buf) + fread(buf, 1, 1 << 20, stdin), _ == __)
             ? EOF
             : *_++);
  if (f) x = -x;
  return 1;
}
template <class T>
inline bool read(T &a, T &b) {
  return read(a) && read(b);
}
template <class T>
inline bool read(T &a, T &b, T &c) {
  return read(a) && read(b) && read(c);
}
const long long MAXN = 2e5 + 8, mod = 1e9 + 7, inf = 0x3f3f3f3f;
struct E {
  int y, nt;
} e[MAXN * 20];
int head[MAXN], cnt;
inline void add(int x, int y) {
  e[++cnt].y = y;
  e[cnt].nt = head[x];
  head[x] = cnt;
}
int low[MAXN], dfn[MAXN], tarcnt, root;
bool cut[MAXN];
int vb;
long long na, nb;
long long n, m, a, b;
int tarjan(int x) {
  int siz = 1;
  if (x == b) vb = 1;
  low[x] = dfn[x] = ++tarcnt;
  int flag = 0;
  for (int i = head[x]; i; i = e[i].nt) {
    int y = e[i].y;
    if (!dfn[y]) {
      int tmp = tarjan(y);
      siz += tmp;
      if (x == root && vb) {
        vb = 0;
        siz -= tmp;
      }
      low[x] = min(low[x], low[y]);
      if (low[y] >= dfn[x]) {
        flag++;
        if (x ^ root || flag > 1) {
          cut[x] = 1;
          if (x == b) nb += tmp;
        }
      }
    } else
      low[x] = min(low[x], dfn[y]);
  }
  return siz;
}
int main() {
  srand(666);
  int t;
  read(t);
  while (t--) {
    read(n, m), read(a, b);
    tarcnt = cnt = 0;
    na = nb = 0;
    for (int i = 0; i <= n; ++i) {
      head[i] = 0;
      low[i] = 0;
      dfn[i] = 0;
      cut[i] = 0;
    }
    for (int i = 0, x, y; i < m; ++i) {
      read(x, y);
      add(x, y);
      add(y, x);
    }
    na = tarjan(root = a);
    if (!cut[a] || !cut[b]) {
      puts("0");
      continue;
    }
    long long ans = nb * (na - 1);
    printf("%I64d\n", ans);
  }
  return 0;
}
