#include <bits/stdc++.h>
#pragma GCC optimize("O2")
long long inf = 1LL << 31;
long long mod = 1000000007;
using namespace std;
vector<int> a, b;
vector<vector<int> > g;
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  a.resize(n);
  b.assign(n + 1, 0);
  g.resize(n + 1);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    g[u].push_back(v);
  }
  int ans = 1;
  b[a[n - 1]]++;
  for (int i = n - 2; i >= 0; i--) {
    int cur = a[i];
    int bad = ans;
    for (int j = 0; j < g[cur].size(); j++) {
      int pre = g[cur][j];
      bad -= b[pre];
    }
    if (bad) ans++, b[cur]++;
  }
  printf("%d", n - ans);
  return 0;
}
