#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  return x * f;
}
long long n, tot = 1, ans, m, k;
long long head[400005], d[400005], pr[400005], v[400005], vi[400005],
    vdel[400005], num[400005];
struct node {
  long long u, v;
} g[400005];
struct ed {
  long long next, to;
} e[400005 * 2];
void ad(long long x, long long y) {
  e[++tot].to = y;
  e[tot].next = head[x];
  head[x] = tot;
}
void del(long long x) {
  if (vdel[x]) return;
  ans--;
  vdel[x] = 1;
  for (int i = head[x]; i; i = e[i].next) {
    int tt = e[i].to;
    bool flag = 0;
    if (d[tt] >= k) flag = 1;
    if (vi[i]) continue;
    d[tt]--;
    if (flag && d[tt] < k) del(tt);
  }
}
void dfs(long long x) {
  v[x] = 1;
  ans++;
  for (int i = head[x]; i; i = e[i].next) {
    int tt = e[i].to;
    if (v[tt] || vi[i]) continue;
    dfs(tt);
  }
  if (d[x] < k) del(x);
}
int main() {
  n = read(), m = read(), k = read();
  for (int i = 1; i <= m; i++) {
    g[i].u = read(), g[i].v = read();
    num[i] = tot + 1;
    ad(g[i].u, g[i].v);
    ad(g[i].v, g[i].u);
    d[g[i].u]++;
    d[g[i].v]++;
  }
  for (int i = 1; i <= n; i++) {
    if (!v[i]) dfs(i);
  }
  for (int i = m; i >= 1; i--) {
    pr[i] = ans;
    long long u = g[i].u, v = g[i].v;
    vi[num[i]] = vi[num[i] ^ 1] = 1;
    if (d[u] >= k && d[v] >= k) {
      d[u]--;
      d[v]--;
      if (d[u] < k) del(u);
      if (d[v] < k) del(v);
    } else if (d[u] >= k)
      d[v]--;
    else if (d[v] >= k)
      d[u]--;
  }
  for (int i = 1; i <= m; i++) cout << pr[i] << endl;
  return 0;
}
