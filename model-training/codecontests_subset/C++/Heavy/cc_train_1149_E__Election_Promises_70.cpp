#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch - '0' < 0 || ch - '0' > 9) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch - '0' >= 0 && ch - '0' <= 9) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, m, top, mx;
int head[200010], nxt[200010], to[200010], tot;
void add(int u, int v) {
  tot++;
  nxt[tot] = head[u];
  head[u] = tot;
  to[tot] = v;
}
long long a[200010], val[200010];
int deg[200010], p[200010], vis[200010], id[200010];
queue<int> q;
void top_sort() {
  for (int i = 1; i <= n; i++)
    if (!deg[i]) q.push(i);
  while (q.size()) {
    int now = q.front();
    q.pop();
    p[++top] = now;
    for (int i = head[now]; i; i = nxt[i]) {
      deg[to[i]]--;
      if (!deg[to[i]]) q.push(to[i]);
    }
  }
  for (int i = n; i >= 1; i--) {
    int x = p[i];
    for (int j = head[x]; j; j = nxt[j]) vis[id[to[j]]] = 1;
    while (vis[id[x]]) id[x]++;
    val[id[x]] ^= a[x];
    mx = max(mx, id[x]);
    for (int j = head[x]; j; j = nxt[j]) vis[id[to[j]]] = 0;
  }
}
int main() {
  n = read();
  m = read();
  for (int i = 1; i <= n; i++) a[i] = read();
  for (int i = 1; i <= m; i++) {
    int q = read(), w = read();
    add(q, w);
    deg[w]++;
  }
  top_sort();
  int pos = -1;
  for (int i = 0; i <= mx; i++)
    if (val[i]) pos = i;
  if (pos == -1) return puts("LOSE"), 0;
  puts("WIN");
  for (int i = 1; i <= n; i++) {
    if (id[i] == pos) {
      if ((val[id[i]] ^ a[i]) > a[i]) continue;
      a[i] ^= val[id[i]];
      val[id[i]] = 0;
      for (int j = head[i]; j; j = nxt[j])
        a[to[j]] ^= val[id[to[j]]], val[id[to[j]]] = 0;
    }
  }
  for (int i = 1; i <= n; i++) printf("%lld ", a[i]);
  puts("");
  return 0;
}
