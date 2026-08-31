#include <bits/stdc++.h>
using namespace std;
int n;
int cnt = 0, st[3010] = {0};
struct line {
  int to, next;
} a[6010];
inline void add(int &x, int &y) {
  a[++cnt].to = y;
  a[cnt].next = st[x];
  st[x] = cnt;
}
int vis[3010], check = 0, st_p, cir_size;
stack<int> ge;
void dfs(int x, int fa) {
  ge.push(x);
  vis[x] = 1;
  for (int i = st[x]; i; i = a[i].next) {
    if (vis[a[i].to] && a[i].to != fa) {
      st_p = a[i].to;
      check = 1;
      return;
    } else if (!vis[a[i].to]) {
      dfs(a[i].to, x);
    }
    if (check) return;
  }
  ge.pop();
}
int in_cir[3010], pl[3010];
int depth, dep[3010], anc[3010][20], root[3001];
void dfs2(int &rt, int x) {
  root[x] = rt;
  for (int i = st[x]; i; i = a[i].next) {
    if (!in_cir[a[i].to] && a[i].to ^ anc[x][0]) {
      anc[a[i].to][0] = x;
      dep[a[i].to] = dep[x] + 1;
      dfs2(rt, a[i].to);
    }
  }
}
inline void get_anc() {
  for (int i = 1; i <= depth; i++) {
    for (int j = 1; j <= n; j++) {
      anc[j][i] = anc[anc[j][i - 1]][i - 1];
    }
  }
}
inline int get_lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  int tmp1 = dep[x] - dep[y], tmp2 = 0, ret = 0;
  ret += tmp1;
  while (tmp1) {
    if (tmp1 & 1) x = anc[x][tmp2];
    tmp1 >>= 1;
    tmp2++;
  }
  if (x == y) return ret + 1;
  ret += 2;
  for (int i = depth; i >= 0; i--) {
    if (anc[x][i] ^ anc[y][i]) {
      ret += 2 * pow(2, i);
      x = anc[x][i];
      y = anc[y][i];
    }
  }
  return ret + 1;
}
int roun[3001];
double ans = 0.0;
int main() {
  ios::sync_with_stdio(0);
  cin >> n;
  depth = log2(n) + 1;
  n++;
  for (int i = 1; i ^ n; i++) {
    int x, y;
    cin >> x >> y;
    x++, y++;
    add(x, y);
    add(y, x);
  }
  dfs(1, 0);
  while (true) {
    in_cir[ge.top()] = 1;
    cir_size++;
    pl[ge.top()] = cir_size;
    roun[cir_size] = ge.top();
    if (ge.top() == st_p) break;
    ge.pop();
  }
  for (int i = 1; i <= cir_size; i++) {
    dep[roun[i]] = 0;
    dfs2(roun[i], roun[i]);
  }
  get_anc();
  for (int i = 1; i ^ n; i++) {
    for (int j = 1; j ^ n; j++) {
      if (root[i] == root[j]) {
        ans += 1.0 / get_lca(i, j);
      } else {
        int x = max(pl[root[i]], pl[root[j]]),
            y = min(pl[root[i]], pl[root[j]]);
        int x2 = dep[i] + 1, y2 = dep[j] + 1;
        ans += 1.0 / (x2 + y2 + x - y - 1) +
               1.0 / (x2 + y2 + cir_size - x + y - 1) -
               1.0 / (x2 + y2 + cir_size - 2);
      }
    }
  }
  printf("%.10lf", ans);
}
