#include <bits/stdc++.h>
char ch;
inline void read(int &x) {
  x = 0;
  ch = getchar();
  while (ch <= 32) ch = getchar();
  while (ch > 32) {
    x = x * 10 + ch - 48;
    ch = getchar();
  };
};
int n;
struct edge {
  edge *next;
  int y;
};
edge *se[3005], e[3005 * 2], *etot = e;
inline void addedge(int x, int y) {
  *++etot = (edge){se[x], y};
  se[x] = etot;
};
int fa[3005];
inline int getfa(int x) { return fa[x] ? fa[x] = getfa(fa[x]) : x; };
inline bool merge(int x, int y) {
  x = getfa(x);
  y = getfa(y);
  if (x == y) return false;
  fa[x] = y;
  return true;
};
int _y, _top, cyclen;
int _stack[3005];
bool isoncyc[3005];
inline void dfs(int x, int last) {
  if (x == _y) {
    cyclen = _top;
    while (_top) isoncyc[_stack[_top--]] = true;
    return;
  };
  edge *te = se[x];
  while (te) {
    int ty = te->y;
    if (ty ^ last) {
      _stack[++_top] = ty;
      dfs(ty, x);
      if (cyclen) return;
      --_top;
    };
    te = te->next;
  };
};
inline void findcyc(int x, int y) {
  _y = y;
  _top = 1;
  _stack[1] = x;
  dfs(x, 0);
};
bool v[3005];
int tot;
int A, B;
double ans;
inline void dfs(int x) {
  v[x] = true;
  ++tot;
  A += isoncyc[x];
  if (A <= 1) {
    ans += 1.0 / tot;
  } else {
    tot += cyclen - A;
    ans +=
        0.5 * (1.0 / tot + (A - 2.0) / ((tot + 0.0) * (tot - A + 2.0)) +
               (cyclen - A + 0.0) / ((tot + 0.0) * (tot - cyclen + A + 0.0)));
    tot -= cyclen - A;
  };
  edge *te = se[x];
  while (te) {
    int ty = te->y;
    if (!v[ty]) {
      dfs(ty);
    };
    te = te->next;
  };
  v[x] = false;
  --tot;
  A -= isoncyc[x];
};
inline void solve() {
  int i;
  for (i = 1; i <= n; i++) {
    dfs(i);
  };
};
int main() {
  read(n);
  int i;
  for (i = 1; i <= n; i++) {
    int x, y;
    read(x);
    read(y);
    ++x;
    ++y;
    if (!merge(x, y)) {
      findcyc(x, y);
    };
    addedge(x, y);
    addedge(y, x);
  };
  solve();
  printf("%.10lf\n", ans);
}
