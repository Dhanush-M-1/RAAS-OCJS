#include <bits/stdc++.h>
using namespace std;
void output(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x == 0) {
    putchar('0');
    return;
  }
  int a[20], num = 0;
  while (x) a[++num] = x % 10, x /= 10;
  while (num > 0) putchar('0' + a[num--]);
}
inline long long getInt() {
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  int flag = 1;
  if (c == '-') flag = -1, c = getchar();
  long long x = 0;
  while (isdigit(c)) {
    x = (x * 10) + (c - '0');
    c = getchar();
  }
  if (flag == -1) return -x;
  return x;
}
const int mod = 1000000007;
const int N = 100005;
struct node {
  int v, next;
  long long w;
};
node edges[N << 1];
int head[N], e;
void add(int u, int v, int w) {
  edges[e].v = v;
  edges[e].w = w;
  edges[e].next = head[u];
  head[u] = e++;
}
int n, m;
long long p1[N], p2[N], s[N];
int dep[N];
int fa[N][20];
long long lenFromRoot[N];
void DFS(int u, int pre) {
  fa[u][0] = pre;
  s[u] = 1;
  int i;
  for (i = head[u]; i != -1; i = edges[i].next) {
    int v = edges[i].v;
    long long w = edges[i].w;
    if (v == pre) continue;
    dep[v] = dep[u] + 1;
    lenFromRoot[v] = (lenFromRoot[u] + w) % mod;
    DFS(v, u);
    p2[u] += p2[v] + 2 * w % mod * p1[v] % mod + w * w % mod * s[v] % mod;
    p2[u] %= mod;
    p1[u] += p1[v] + s[v] * w % mod;
    p1[u] %= mod;
    s[u] += s[v];
  }
}
long long f[N];
long long pp2[N], pp1[N], ss[N];
long long ppp2[N], ppp1[N], sss[N];
void dfs(int u, int pre) {
  f[u] = p2[u];
  int i;
  for (i = head[u]; i != -1; i = edges[i].next) {
    int v = edges[i].v;
    long long w = edges[i].w;
    if (v == pre) continue;
    pp2[v] =
        p2[u] - (p2[v] + 2 * w % mod * p1[v] % mod + w * w % mod * s[v] % mod);
    pp1[v] = p1[u] - p1[v] - s[v] * w % mod;
    ss[v] = n - s[v];
    p2[v] += pp2[v] + 2 * w % mod * pp1[v] % mod + w * w % mod * ss[v] % mod;
    p2[v] %= mod;
    p1[v] += pp1[v] + (n - s[v]) * w % mod;
    p1[v] %= mod;
    dfs(v, u);
  }
}
int getLca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  int x = dep[u] - dep[v];
  int i;
  for (i = 0; i < 20; i++)
    if (x & (1 << i)) u = fa[u][i];
  if (u == v) return v;
  for (i = 19; i >= 0; i--)
    if (fa[u][i] && fa[v][i] && fa[u][i] != fa[v][i]) {
      u = fa[u][i];
      v = fa[v][i];
    }
  return fa[u][0];
}
long long calLen(int u, int v) {
  int i;
  for (i = head[u]; i != -1; i = edges[i].next) {
    if (edges[i].v == v) return edges[i].w;
  }
}
long long cal1(int u, int v, int lca) {
  long long a = ppp2[u];
  if (1 == v) {
    return f[u];
  }
  long long c = 0;
  long long w = calLen(v, fa[v][0]);
  w += lenFromRoot[u] - lenFromRoot[v];
  w %= mod;
  c += pp2[v] + 2 * w % mod * pp1[v] % mod + w * w % mod * ss[v] % mod;
  c %= mod;
  long long b = f[u] - a - c;
  b %= mod;
  if (b < 0) b += mod;
  return 2 * (a + b) - f[u];
}
long long cal2(int u, int v, int lca) {
  long long L = lenFromRoot[u] + lenFromRoot[v] - 2 * lenFromRoot[lca];
  L %= mod;
  long long a = 0;
  a += ppp2[v] + 2 * L % mod * ppp1[v] % mod + L * L % mod * sss[v] % mod;
  a %= mod;
  return 2 * a - f[u];
}
int main() {
  n = getInt();
  memset(head, -1, sizeof(head));
  int i;
  for (i = 1; i < n; i++) {
    int u = getInt();
    int v = getInt();
    int w = getInt();
    add(u, v, w);
    add(v, u, w);
  }
  DFS(1, 0);
  for (i = 1; i <= n; i++) {
    ppp2[i] = p2[i];
    ppp1[i] = p1[i];
    sss[i] = s[i];
  }
  dfs(1, 0);
  int j;
  for (j = 1; j < 20; j++)
    for (i = 1; i <= n; i++) {
      fa[i][j] = fa[fa[i][j - 1]][j - 1];
    }
  m = getInt();
  while (m--) {
    int u = getInt();
    int v = getInt();
    int lca = getLca(u, v);
    long long ans;
    if (lca == v)
      ans = cal1(u, v, lca);
    else
      ans = cal2(u, v, lca);
    ans %= mod;
    if (ans < 0) ans += mod;
    printf("%d\n", (int)ans);
  }
}
