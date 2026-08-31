#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T &x) {
  int f = 0;
  x = 0;
  char ch = getchar();
  for (; !isdigit(ch); ch = getchar()) f |= (ch == '-');
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  if (f) x = -x;
}
const int N = 200005;
int h[N], q[N], dp[N], in[N], f[N], vis[N];
int n, m, l, r, u, v, p;
vector<int> e[N];
int main() {
  read(n), read(m), p = n;
  for (int i = (1); i <= (n); i++) read(h[i]);
  for (int i = (1); i <= (m); i++) read(u), read(v), e[u].push_back(v), in[v]++;
  for (int i = (1); i <= (n); i++)
    if (!in[i]) q[r++] = i;
  for (int u = q[l++]; l <= r; u = q[l++])
    for (auto v : e[u])
      if (!(--in[v])) q[r++] = v;
  for (int i = (n - 1); i >= (0); i--) {
    int u = q[i];
    for (auto v : e[u]) vis[dp[v]] = 1;
    while (vis[dp[u]]) dp[u]++;
    for (auto v : e[u]) vis[dp[v]] = 0;
    f[dp[u]] ^= h[u];
  }
  while (p >= 0 && !f[p]) p--;
  if (p == -1) return puts("LOSE"), 0;
  for (int u = (1); u <= (n); u++)
    if (dp[u] == p && (h[u] ^ f[p]) < h[u]) {
      h[u] ^= f[p], f[p] = 0;
      for (auto v : e[u]) h[v] ^= f[dp[v]], f[dp[v]] = 0;
    }
  puts("WIN");
  for (int i = (1); i <= (n); i++) printf("%d ", h[i]);
  return 0;
}
