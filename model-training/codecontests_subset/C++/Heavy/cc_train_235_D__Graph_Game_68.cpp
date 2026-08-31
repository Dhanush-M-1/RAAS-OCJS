#include <bits/stdc++.h>
using namespace std;
namespace Fread {
const int MAXN = 1 << 20;
char buffer[MAXN], *S, *T;
inline char getchar() {
  if (S == T) {
    T = (S = buffer) + fread(buffer, 1, MAXN, stdin);
    if (S == T) return EOF;
  }
  return *S++;
}
}  // namespace Fread
inline int read() {
  int f = 1, x = 0;
  char ch = Fread::getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = Fread::getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = Fread::getchar();
  }
  return x * f;
}
inline long long readll() {
  long long f = 1, x = 0;
  char ch = Fread::getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = Fread::getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = Fread::getchar();
  }
  return x * f;
}
const int MAXN = 3005;
struct EDGE {
  int nxt, to;
} edge[MAXN << 1];
int head[MAXN], tot;
inline void add_edge(int u, int v) {
  edge[++tot].nxt = head[u];
  edge[tot].to = v;
  head[u] = tot;
}
int n, sta[MAXN], top, cir[MAXN], c;
bool vis[MAXN], flag, incir[MAXN];
void dfs1(int u, int frm) {
  vis[u] = 1;
  sta[++top] = u;
  for (int i = head[u]; i; i = edge[i].nxt) {
    int v = edge[i].to;
    if (v == frm) continue;
    if (vis[v]) {
      int t = -1;
      for (int j = 1; j <= top; ++j)
        if (sta[j] == v) {
          t = j;
          break;
        }
      assert(t != -1);
      for (int j = t; j <= top; ++j) cir[++c] = sta[j];
      flag = 1;
      return;
    }
    dfs1(v, u);
    if (flag) return;
  }
  --top;
}
int fa[MAXN], d[MAXN], rt;
vector<int> tr[MAXN];
void dfs2(int u) {
  tr[rt].push_back(u);
  for (int i = head[u]; i; i = edge[i].nxt) {
    int v = edge[i].to;
    if (v == fa[u] || incir[v]) continue;
    fa[v] = u;
    d[v] = d[u] + 1;
    dfs2(v);
  }
}
double ans;
void dfs3(int u, int frm, int dep) {
  for (int i = head[u]; i; i = edge[i].nxt) {
    int v = edge[i].to;
    if (incir[u] && incir[v]) continue;
    if (v == frm) continue;
    ans += 1.0 / (dep + 1);
    dfs3(v, u, dep + 1);
  }
}
int main() {
  n = read();
  for (int i = 1, u, v; i <= n; ++i)
    u = read() + 1, v = read() + 1, add_edge(u, v), add_edge(v, u);
  dfs1(1, 0);
  assert(flag);
  for (int i = 1; i <= c; ++i) incir[cir[i]] = 1;
  for (int i = 1; i <= c; ++i) {
    fa[cir[i]] = 0;
    rt = cir[i];
    dfs2(cir[i]);
  }
  ans = n;
  for (int i = 1; i <= n; ++i) {
    dfs3(i, 0, 1);
  }
  for (int i = 1; i <= c; ++i) {
    for (int j = 0; j < (int)tr[cir[i]].size(); ++j) {
      int u = tr[cir[i]][j];
      for (int k = 1; k <= c; ++k)
        if (k != i) {
          int dis1 = max(i, k) - min(i, k), dis2 = c - dis1;
          for (int l = 0; l < (int)tr[cir[k]].size(); ++l) {
            int v = tr[cir[k]][l];
            ans += 1.0 / (d[u] + d[v] + dis1 + 1);
            ans += 1.0 / (d[u] + d[v] + dis2 + 1);
            ans -= 1.0 / (d[u] + d[v] + c);
          }
        }
    }
  }
  cout << setiosflags(ios::fixed) << setprecision(10) << ans << endl;
  return 0;
}
