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
int n, m;
vector<int> to[200005];
int deg[200005];
int st[200005], st_top;
int id[200005];
long long xum[200005];
long long h[200005];
int main() {
  read(n, m);
  for (int i = 1; i <= n; i++) read(h[i]);
  for (int i = 1, x, y; i <= m; i++) read(x, y), deg[y]++, to[x].push_back(y);
  queue<int> q;
  for (int i = 1; i <= n; i++)
    if (deg[i] == 0) q.push(i);
  while (q.size()) {
    int now = q.front();
    q.pop();
    st[++st_top] = now;
    for (int i : to[now]) {
      deg[i]--;
      if (deg[i] == 0) q.push(i);
    }
  }
  static bool vis[200005];
  for (int tp = n; tp >= 1; tp--) {
    int i = st[tp];
    for (int j : to[i]) vis[id[j]] = 1;
    while (vis[id[i]]) id[i]++;
    for (int j : to[i]) vis[id[j]] = 0;
    xum[id[i]] ^= h[i];
  }
  int pos = -1;
  for (int i = 0; i <= n; i++)
    if (xum[i]) pos = i;
  if (pos == -1) return printf("LOSE\n"), 0;
  for (int i = 1; i <= n; i++)
    if (id[i] == pos) {
      int tp = xum[pos] ^ h[i];
      if (tp >= h[i]) continue;
      h[i] = tp;
      xum[pos] = 0;
      for (int j : to[i])
        if (xum[id[j]]) {
          h[j] = xum[id[j]] ^ h[j];
          xum[id[j]] = 0;
        }
      break;
    }
  printf("WIN\n");
  for (int i = 1; i <= n; i++) printf("%lld ", h[i]);
  return 0;
}
