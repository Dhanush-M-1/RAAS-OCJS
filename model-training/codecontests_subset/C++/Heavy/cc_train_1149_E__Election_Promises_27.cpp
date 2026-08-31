#include <bits/stdc++.h>
using namespace std;
int read() {
  bool f = 1;
  int x = 0;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = 0;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 3) + (x << 1) - 48 + c;
    c = getchar();
  }
  return f ? x : x * -1;
}
char cr[200];
int tt;
inline void print(register int x, register char k = '\n') {
  if (!x) putchar('0');
  if (x < 0) putchar('-'), x = -x;
  while (x) cr[++tt] = x % 10 + '0', x /= 10;
  while (tt) putchar(cr[tt--]);
  putchar(k);
}
const int maxn = 2e5 + 7;
vector<int> e[maxn];
queue<int> q;
int a[maxn], mex[maxn], nim[maxn], n, m;
int vis[maxn], wh[maxn];
int d[maxn];
bool dfs(int u) {
  vis[u] = -1;
  for (int v : e[u]) {
    if (vis[v] == -1) return 0;
    if (vis[v] == 0)
      if (!dfs(v)) return 0;
  }
  vis[u] = 1;
  q.push(u);
  return 1;
}
signed main() {
  n = read();
  m = read();
  for (int i = 1; i <= n; i++) {
    a[i] = read();
  }
  for (int i = 1; i <= m; i++) {
    int u = read(), v = read();
    e[u].push_back(v);
  }
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) dfs(i);
  }
  for (int i = 1; i <= n; i++) {
    int u = q.front();
    q.pop();
    mex[u] = 1;
    for (int v : e[u]) wh[mex[v]] = 1;
    while (wh[mex[u]]) {
      mex[u]++;
    }
    nim[mex[u]] ^= a[u];
    for (int v : e[u]) wh[mex[v]] = 0;
  }
  bool f = 0;
  int tmp = 0;
  for (int i = n; i; i--) {
    if (nim[i]) {
      f = 1;
      tmp = i;
      break;
    }
  }
  if (!f) {
    puts("LOSE");
    return 0;
  }
  puts("WIN");
  for (int u = 1; u <= n; u++) {
    if (mex[u] == tmp && (a[u] ^ nim[tmp]) < a[u]) {
      a[u] = nim[mex[u]] ^= a[u];
      d[mex[u]] = 1;
      for (int v : e[u]) {
        if (nim[mex[v]] && !d[mex[v]]) {
          a[v] = nim[mex[v]] ^= a[v];
          d[mex[v]] = 1;
        }
      }
      for (int i = 1; i <= n; i++) {
        print(a[i], ' ');
      }
      return 0;
    }
  }
  return 0;
}
