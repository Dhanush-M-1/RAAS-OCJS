#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T read(register T& t) {
  register T f = 1;
  register char ch = getchar();
  t = 0;
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -f;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') t = t * 10 + ch - '0', ch = getchar();
  t *= f;
  return t;
}
template <typename T, typename... Args>
inline void read(T& t, Args&... args) {
  read(t);
  read(args...);
}
const long long p = 998244353;
inline long long power(register long long x, register long long k = p - 2) {
  register long long re = 1;
  for (; k; k >>= 1, x = x * x % p)
    if (k & 1) re = re * x % p;
  return re;
}
int n;
int head[3005], to[6006], ne[6006], total = 1;
inline void add(int a, int b) {
  total++;
  to[total] = b;
  ne[total] = head[a];
  head[a] = total;
}
vector<int> col;
bool vis[3005];
int st[3005], st_top;
int del_e;
void dfs(int now, int fa) {
  if (col.size()) return;
  st[++st_top] = now;
  vis[now] = 1;
  for (int i = head[now]; i; i = ne[i])
    if (to[i] != fa) {
      if (vis[to[i]]) {
        while (st_top > 0 && st[st_top] != to[i])
          col.push_back(st[st_top]), st_top--;
        col.push_back(to[i]);
        del_e = i;
        return;
      }
      dfs(to[i], now);
      if (col.size()) return;
    }
  st_top--;
}
int fa[3005], son[3005];
int deep[3005], size[3005];
int top[3005];
void dfs1(int now) {
  deep[now] = deep[fa[now]] + 1;
  size[now] = 1;
  for (int i = head[now]; i; i = ne[i])
    if (to[i] != fa[now]) {
      if (i == del_e || (i ^ 1) == del_e) continue;
      fa[to[i]] = now;
      dfs1(to[i]);
      size[now] += size[to[i]];
      if (size[to[i]] > size[son[now]]) son[now] = to[i];
    }
}
void dfs2(int now, int topf) {
  top[now] = topf;
  if (son[now]) dfs2(son[now], topf);
  for (int i = head[now]; i; i = ne[i])
    if (to[i] != fa[now] && to[i] != son[now])
      if (i != del_e && (i ^ 1) != del_e) dfs2(to[i], to[i]);
}
bool inc[3005];
vector<int> sol[3005];
void dfs3(int now, int fa, int id) {
  sol[id].push_back(now);
  for (int i = head[now]; i; i = ne[i])
    if (to[i] != fa && inc[to[i]] == 0) dfs3(to[i], now, id);
}
double ans = 0;
inline int lca(int x, int y) {
  while (top[x] != top[y]) {
    if (deep[top[x]] < deep[top[y]]) swap(x, y);
    x = fa[top[x]];
  }
  if (deep[x] < deep[y]) return x;
  return y;
}
inline int dis(int x, int y) {
  return deep[x] + deep[y] - deep[lca(x, y)] * 2 + 1;
}
int bel[3005];
int disoc[3005], disoc_top;
int main() {
  read(n);
  for (int i = 1, x, y; i <= n; i++) read(x, y), x++, y++, add(x, y), add(y, x);
  dfs(1, 1);
  dfs1(1);
  dfs2(1, 1);
  for (int i : col) inc[i] = 1;
  for (int i : col) dfs3(i, i, i);
  for (int i : col)
    for (int j : sol[i]) bel[j] = i;
  for (int i : col) disoc[i] = ++disoc_top;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (bel[i] == bel[j]) {
        ans += 1.0 / dis(i, j);
        continue;
      }
      int x = dis(i, bel[i]) + dis(j, bel[j]);
      int y = abs(disoc[bel[i]] - disoc[bel[j]]) - 1;
      int z = col.size() - y - 2;
      ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
    }
  printf("%.10lf\n", ans);
  return 0;
}
