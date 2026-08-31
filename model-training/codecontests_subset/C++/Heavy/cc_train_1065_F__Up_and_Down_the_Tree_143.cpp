#include <bits/stdc++.h>
using namespace std;
namespace IO {
char buf[1 << 21], *p1 = buf, *p2 = buf;
char getch() {
  return p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1 << 21, stdin), p1 == p2)
             ? EOF
             : *p1++;
}
template <typename T>
void read(T &x) {
  char ch = getch();
  int fl = 1;
  x = 0;
  while (ch > '9' || ch < '0') {
    if (ch == '-') fl = -1;
    ch = getch();
  }
  while (ch <= '9' && ch >= '0') {
    x = x * 10 + ch - 48;
    ch = getch();
  }
  x *= fl;
}
template <typename T, typename... Args>
void read(T &x, Args &...args) {
  read(x);
  read(args...);
}
}  // namespace IO
using namespace IO;
int n, K;
int son[1000010], bro[1000010];
int dm[1000010], dep[1000010];
int f[1000010], ans[1000010];
void dfs(int u, int d) {
  dep[u] = d;
  dm[u] = 0x3f3f3f3f;
  if (!son[u]) dm[u] = d;
  for (int v = son[u]; v; v = bro[v]) dfs(v, d + 1), dm[u] = min(dm[u], dm[v]);
}
void dp(int u) {
  if (!son[u]) f[u] = 1;
  for (int v = son[u]; v; v = bro[v]) {
    dp(v);
    if (dm[v] - dep[u] <= K) f[u] += f[v], f[v] = 0;
  }
}
void dfs2(int u) {
  for (int v = son[u]; v; v = bro[v]) dfs2(v), ans[u] = max(ans[u], ans[v]);
  ans[u] += f[u];
}
int main() {
  read(n, K);
  for (int i = 2; i <= n; i++) {
    int fa;
    read(fa);
    bro[i] = son[fa];
    son[fa] = i;
  }
  dfs(1, 1);
  dp(1);
  dfs2(1);
  printf("%d\n", ans[1]);
  return 0;
}
