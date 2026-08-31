#include <bits/stdc++.h>
using namespace std;
int n, tot;
const int N = 3005;
int head[N], to[N << 1], nt[N << 1];
inline int read() {
  int res = 0;
  char ch = getchar();
  bool XX = false;
  for (; !isdigit(ch); ch = getchar()) (ch == '-') && (XX = true);
  for (; isdigit(ch); ch = getchar()) res = (res << 3) + (res << 1) + (ch ^ 48);
  return XX ? -res : res;
}
void add(int f, int t) {
  to[++tot] = t;
  nt[tot] = head[f];
  head[f] = tot;
}
namespace solve2 {
int top, tot;
double ans;
int in[N], zhan[N], cir[N], incir[N], belong[N], f[N][15], dep[N];
int findcir(int x, int fa) {
  if (in[x]) {
    int t;
    do {
      t = zhan[top--];
      incir[t] = 1;
      cir[++tot] = t;
    } while (x != t);
    return 1;
  }
  zhan[++top] = x;
  in[x] = 1;
  for (int i = head[x]; i; i = nt[i])
    if (to[i] != fa && findcir(to[i], x)) return 1;
  in[x] = 0;
  --top;
  return 0;
}
void dfs(int x, int fa, int c) {
  belong[x] = c;
  f[x][0] = fa;
  dep[x] = dep[fa] + 1;
  for (int i = 1; i < 15; ++i) f[x][i] = f[f[x][i - 1]][i - 1];
  for (int i = head[x]; i; i = nt[i])
    if (!incir[to[i]] && to[i] != fa) dfs(to[i], x, c);
}
int LCA(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 14; i >= 0; --i)
    if (dep[f[x][i]] >= dep[y]) x = f[x][i];
  if (x == y) return x;
  for (int i = 14; i >= 0; --i)
    if (f[x][i] != f[y][i]) x = f[x][i], y = f[y][i];
  return f[x][0];
}
int Dis(int x, int y) { return dep[x] + dep[y] - 2 * dep[LCA(x, y)] + 1; }
int jue(int x) { return x > 0 ? x : -x; }
void work() {
  findcir(1, 0);
  for (int i = 1; i <= tot; ++i) dfs(cir[i], 0, i);
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j) {
      if (belong[i] == belong[j])
        ans += 1.0 / Dis(i, j);
      else {
        int x = dep[i] + dep[j], y = jue(belong[i] - belong[j]) - 1,
            z = tot - 2 - y;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  printf("%0.7f", ans);
}
}  // namespace solve2
int main() {
  cin >> n;
  for (int i = 1, x, y; i <= n; ++i) {
    x = read() + 1;
    y = read() + 1;
    add(x, y);
    add(y, x);
  }
  solve2::work();
  fclose(stdin);
  fclose(stdout);
  return 0;
}
