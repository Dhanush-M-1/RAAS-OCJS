#include <bits/stdc++.h>
using namespace std;
int read() {
  char c = getchar();
  int x = 0;
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - 48, c = getchar();
  return x;
}
int n, m;
const int _ = 2e5 + 7;
int val[_], v[_];
vector<int> E[_];
int deg[_];
int st[_], top;
int q[_], h[_];
bool used[_];
int main() {
  n = read(), m = read();
  for (int i = 1; i <= n; ++i) v[i] = read();
  for (int i = 1; i <= m; ++i) {
    int u = read(), v = read();
    E[u].push_back(v);
    deg[v]++;
  }
  int l = 1, r = 0;
  for (int i = 1; i <= n; ++i)
    if (!deg[i]) q[++r] = i;
  while (l <= r) {
    int x = q[l++];
    st[++top] = x;
    for (int i = 0; i < (int)E[x].size(); ++i) {
      int y = E[x][i];
      deg[y]--;
      if (!deg[y]) q[++r] = y;
    }
  }
  while (top) {
    int x = st[top];
    top--;
    for (int i = 0; i < (int)E[x].size(); ++i) {
      int y = E[x][i];
      used[val[y]] = 1;
    }
    for (int i = 0; i <= m; ++i) {
      if (used[i]) continue;
      val[x] = i;
      break;
    }
    for (int i = 0; i < (int)E[x].size(); ++i) {
      int y = E[x][i];
      used[val[y]] = 0;
    }
  }
  int tag = 0;
  for (int i = 1; i <= n; ++i) h[val[i]] ^= v[i];
  for (int i = 0; i <= m; ++i) tag |= h[i];
  if (!tag) return puts("LOSE"), 0;
  puts("WIN");
  int mx = 0;
  for (int i = 0; i <= m; ++i) {
    if (h[i]) mx = i;
  }
  for (int u = 1; u <= n; ++u) {
    if (val[u] == mx && (h[mx] ^ v[u]) < v[u]) {
      v[u] = h[mx] ^ v[u];
      h[mx] = 0;
      for (int i = 0; i < (int)E[u].size(); ++i) {
        int y = E[u][i];
        if (h[val[y]]) {
          v[y] = h[val[y]] ^ v[y];
          h[val[y]] = 0;
        }
      }
      break;
    }
  }
  for (int i = 1; i <= n; ++i) printf("%d%c", v[i], " \n"[i == n]);
  return 0;
}
