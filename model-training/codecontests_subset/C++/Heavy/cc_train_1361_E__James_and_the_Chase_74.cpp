#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 7;
bool fl[N];
vector<int> v[N];
int t, n, m, tot, p[N], fa[N], da[N], db[N], vac[N], vat[N], dep[N];
inline int read() {
  int num = 0;
  char t = '+', g = getchar();
  while (g < 48 || 57 < g) t = g, g = getchar();
  while (47 < g && g < 58)
    num = (num << 1) + (num << 3) + g - 48, g = getchar();
  if (t == '-') return -num;
  return num;
}
inline void dfs(int u) {
  da[u] = db[u] = ++tot;
  for (int i = 0; i < v[u].size(); i++) {
    int x = v[u][i];
    if (!fa[x]) fa[x] = u, dep[x] = dep[u] + 1, dfs(x), db[u] = db[x];
  }
}
inline void dft(int u) {
  vat[u] = -1;
  for (int i = 0; i < v[u].size(); i++) {
    int x = v[u][i];
    if (fa[x] == u) {
      dft(x), vac[u] += vac[x];
      if (vat[u] == -1)
        vat[u] = vat[x];
      else if (dep[vat[x]] <= dep[vat[u]])
        vat[u] = vat[x];
    } else if (vat[u] == -1)
      vat[u] = v[u][i];
    else if (dep[v[u][i]] <= dep[vat[u]])
      vat[u] = v[u][i];
  }
  if (vac[u] >= 2) fl[u] = 0;
}
inline void dfq(int u) {
  if (vac[u] <= 1) fl[u] |= fl[vat[u]];
  for (int i = 0; i < v[u].size(); i++) {
    int x = v[u][i];
    if (fa[x] == u) dfq(x);
  }
}
inline bool solve(int u) {
  tot = 0, dep[u] = 0;
  for (int i = 1; i <= n; i++) fa[i] = 0, fl[i] = 0, vac[i] = 0;
  fa[u] = -1, dfs(u);
  for (int i = 1; i <= n; i++)
    for (int c = 0; c < v[i].size(); c++) {
      int x = v[i][c];
      if ((!(da[x] <= da[i] && da[i] <= db[x])) && (fa[x] != i)) return false;
      if (fa[x] != i) {
        vac[i]++, vac[x]--;
      }
    }
  fl[u] = 1, dft(u), dfq(u);
  int cnt = 0;
  for (int i = 1; i <= n; i++)
    if (fl[i]) cnt++;
  if (cnt <= ((n - 1) / 5))
    puts("-1");
  else {
    for (int i = 1; i <= n; i++)
      if (fl[i]) printf("%d ", i);
    putchar('\n');
  }
  return true;
}
int main() {
  srand(19260817), t = read();
  int g = 0;
  while (t--) {
    n = read(), m = read(), g++;
    int a, b;
    bool fs = 0;
    for (int i = 1; i <= n; i++) v[i].resize(0), p[i] = i;
    for (int i = 1; i <= m; i++) {
      a = read(), b = read(), v[a].push_back(b);
    }
    random_shuffle(p + 1, p + n + 1);
    for (int i = 1; i <= min(100, n); i++)
      if (solve(p[i])) {
        fs = 1;
        break;
      }
    if (!fs) puts("-1");
  }
}
