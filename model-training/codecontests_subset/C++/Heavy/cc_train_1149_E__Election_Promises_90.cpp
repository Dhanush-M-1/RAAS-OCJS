#include <bits/stdc++.h>
using namespace std;
const long long N = 200005;
long long ver[N << 1], nxt[N << 1], head[N], deg[N], tot;
long long h[N], st[N], vis[N << 1], id[N], t[N << 1], Max, top, n, m;
queue<long long> q;
inline long long read() {
  long long x = 0, ff = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') ff = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 1) + (x << 3) + (ch ^ 48);
    ch = getchar();
  }
  return x * ff;
}
void add(long long x, long long y) {
  ver[++tot] = y;
  nxt[tot] = head[x];
  head[x] = tot;
  deg[y]++;
}
signed main() {
  n = read();
  m = read();
  for (long long i = 1; i <= n; i++) h[i] = read();
  for (long long i = 1; i <= m; i++) {
    long long u, v;
    u = read();
    v = read();
    add(u, v);
  }
  for (long long i = 1; i <= n; i++)
    if (!deg[i]) q.push(i);
  while (q.size()) {
    long long x = q.front();
    q.pop();
    st[++top] = x;
    for (long long i = head[x]; i; i = nxt[i]) {
      long long y = ver[i];
      deg[y]--;
      if (!deg[y]) q.push(y);
    }
  }
  for (long long i = top; i >= 1; i--) {
    long long now = st[i];
    for (long long j = head[now]; j; j = nxt[j]) vis[id[ver[j]]] = 1;
    for (long long nw = 0;; nw++) {
      if (!vis[nw]) {
        id[now] = nw;
        break;
      }
    }
    t[id[now]] ^= h[now];
    Max = max(Max, id[now]);
    for (long long j = head[now]; j; j = nxt[j]) vis[id[ver[j]]] = 0;
  }
  long long maxx = -1;
  for (long long i = 0; i <= Max; i++) {
    if (t[i]) maxx = max(maxx, i);
  }
  if (maxx == -1) {
    puts("LOSE");
    return 0;
  }
  for (long long i = 1; i <= n; i++) {
    if (id[i] == maxx && (t[id[i]] ^ h[i]) < h[i]) {
      h[i] ^= t[id[i]];
      for (long long j = head[i]; j; j = nxt[j]) {
        long long y = ver[j];
        if (t[id[y]]) {
          h[y] ^= t[id[y]];
          t[id[y]] = 0;
        }
      }
      break;
    }
  }
  puts("WIN");
  for (long long i = 1; i <= n; i++) printf("%lld ", h[i]);
  return 0;
}
