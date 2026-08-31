#include <bits/stdc++.h>
using namespace std;
const int N = 3e3 + 5;
int read() {
  int x = 0, f = 1;
  char ch;
  while (!isdigit(ch = getchar())) (ch == '-') && (f = -f);
  for (x = ch ^ 48; isdigit(ch = getchar());
       x = (x << 3) + (x << 1) + (ch ^ 48))
    ;
  return x * f;
}
template <class T>
T Abs(T a) {
  return a > 0 ? a : -a;
}
template <class T>
T Max(T a, T b) {
  return a > b ? a : b;
}
template <class T>
T Min(T a, T b) {
  return a < b ? a : b;
}
struct Edge {
  int to;
  Edge *nxt;
  Edge(int to, Edge *nxt) : to(to), nxt(nxt) {}
} * head[N];
void add(int x, int y) { head[x] = new Edge(y, head[x]); }
double ans;
int n, m, top, tot, is[N], cir[N], sta[N], dep[N], vis[N], bel[N], fa[N][15];
void dfs(int x, int f) {
  dep[x] = dep[f] + 1;
  for (Edge *i = head[x]; i; i = i->nxt) {
    if (i->to == f) continue;
    dfs(i->to, x);
  }
}
void solve1() {
  for (int i = 1; i <= n; ++i) {
    dfs(i, 0);
    for (int j = 1; j <= n; ++j) ans += 1.0 / dep[j];
  }
  printf("%.7f\n", ans);
}
bool findcir(int x, int f) {
  if (vis[x]) {
    int y;
    do {
      y = sta[top--];
      is[y] = 1;
      cir[++tot] = y;
    } while (y != x);
    return 1;
  }
  sta[++top] = x;
  vis[x] = 1;
  for (Edge *i = head[x]; i; i = i->nxt) {
    if (i->to != f && findcir(i->to, x)) return 1;
  }
  vis[x] = 0;
  top--;
  return 0;
}
void dfs(int x, int f, int c) {
  bel[x] = c;
  fa[x][0] = f;
  dep[x] = dep[f] + 1;
  for (int i = 1; i <= 14; ++i) fa[x][i] = fa[fa[x][i - 1]][i - 1];
  for (Edge *i = head[x]; i; i = i->nxt) {
    if (i->to != f && !is[i->to]) dfs(i->to, x, c);
  }
}
int Lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 14; ~i; --i)
    if (dep[fa[x][i]] >= dep[y]) x = fa[x][i];
  if (x == y) return x;
  for (int i = 14; ~i; --i)
    if (fa[x][i] != fa[y][i]) x = fa[x][i], y = fa[y][i];
  return fa[x][0];
}
int Dis(int x, int y) { return dep[x] + dep[y] - dep[Lca(x, y)] * 2 + 1; }
void solve2() {
  findcir(1, 0);
  for (int i = 1; i <= tot; ++i) dfs(cir[i], 0, i);
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) {
      if (bel[i] == bel[j])
        ans += 1.0 / Dis(i, j);
      else {
        int x = dep[i] + dep[j], y = Abs(bel[i] - bel[j]) - 1, z = tot - 2 - y;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  }
  printf("%.7f\n", ans);
}
int main() {
  n = read();
  m = n;
  for (int i = 1, x, y; i <= n; ++i)
    x = read() + 1, y = read() + 1, add(x, y), add(y, x);
  if (m == n - 1)
    return solve1(), 0;
  else
    return solve2(), 0;
  fclose(stdin);
  fclose(stdout);
  return 0;
}
