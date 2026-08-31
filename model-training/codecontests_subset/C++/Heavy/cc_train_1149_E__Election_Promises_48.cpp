#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  register long long x = 0, f = 1;
  register char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = 0;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + (ch ^ '0');
    ch = getchar();
  }
  return f ? x : -x;
}
const int N = 2e5 + 5;
int n, m, id[N], vis[N];
long long h[N], sum[N];
vector<int> E[N];
void dfs(int u) {
  for (int v : E[u])
    if (!id[v]) dfs(v);
  for (int v : E[u]) vis[id[v]] = 1;
  for (id[u] = 1; vis[id[u]]; ++id[u])
    ;
  sum[id[u]] ^= h[u];
  for (int v : E[u]) vis[id[v]] = 0;
}
int main() {
  n = read(), m = read();
  for (int i = (1), _ed = (n); i <= _ed; ++i) h[i] = read();
  for (int i = (1), _ed = (m); i <= _ed; ++i) {
    int u = read(), v = read();
    E[u].push_back(v);
  }
  for (int i = (1), _ed = (n); i <= _ed; ++i)
    if (!id[i]) dfs(i);
  int p = 0;
  for (int i = (n), _ed = (1); i >= _ed; --i)
    if (sum[i]) {
      p = i;
      break;
    }
  if (!p)
    return puts("LOSE"), 0;
  else
    puts("WIN");
  int rt = 0;
  for (int i = (1), _ed = (n); i <= _ed; ++i) {
    if (id[i] ^ p) continue;
    if (h[i] > (h[i] ^ sum[p])) {
      rt = i;
      break;
    }
  }
  h[rt] = h[rt] ^ sum[p], sum[p] = 0;
  for (int v : E[rt]) {
    if (!sum[id[v]]) continue;
    h[v] = h[v] ^ sum[id[v]], sum[id[v]] = 0;
  }
  for (int i = (1), _ed = (n); i <= _ed; ++i)
    printf("%lld%c", h[i], " \n"[i == n]);
  return 0;
}
