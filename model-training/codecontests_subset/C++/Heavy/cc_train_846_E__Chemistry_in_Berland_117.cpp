#include <bits/stdc++.h>
using namespace std;
const double PI = atan(1) * 4;
const int oo = 1000000000;
const int N = 1000010;
int n, p[N];
vector<int> g[N];
long long a[N], b[N], k[N];
double val[N];
void dfs(int u) {
  for (int i = 0; i < g[u].size(); ++i) {
    int v = g[u][i];
    dfs(v);
    if (val[v] < 0) {
      val[u] += (double)k[v] * val[v];
    } else {
      val[u] += val[v];
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%lld", &b[i]);
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%lld", &a[i]);
    val[i] = b[i] - a[i];
  }
  for (int i = 2; i <= n; ++i) {
    scanf("%d%lld", &p[i], &k[i]);
    g[p[i]].push_back(i);
  }
  dfs(1);
  if (val[1] >= 0) {
    puts("YES");
  } else {
    puts("NO");
  }
  return 0;
}
