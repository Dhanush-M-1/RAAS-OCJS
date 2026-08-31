#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 9;
long long sum, a[N], b[N], x[N], k[N];
vector<pair<long long, long long> > g[N];
bool flag = 1;
inline long long read() {
  long long s = 1, a = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') s = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    a = a * 10 + ch - '0';
    ch = getchar();
  }
  return s * a;
}
inline void dfs(int u) {
  for (auto e : g[u]) {
    int k = e.first, v = e.second;
    dfs(v);
    if (b[v] > 0)
      b[u] += b[v];
    else {
      double w = 1.0 * b[v] * k;
      if (b[u] + w < -sum) flag = 0;
      b[u] += b[v] * k;
    }
  }
}
int main() {
  int n = read();
  for (int i = 1; i <= n; i++) b[i] = read(), sum += b[i];
  for (int i = 1; i <= n; i++) a[i] = read(), b[i] -= a[i];
  for (int i = 2; i <= n; i++) {
    int x = read(), k = read();
    g[x].push_back(make_pair(k, i));
  }
  dfs(1);
  return 0 * puts(flag & (b[1] >= 0) ? "YES" : "NO");
}
