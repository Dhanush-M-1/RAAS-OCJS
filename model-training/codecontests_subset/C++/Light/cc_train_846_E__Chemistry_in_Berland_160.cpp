#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll oo = 1e18;
const int N = 100005;
vector<pair<int, int>> g[N];
int n;
ll b[N], a[N];
ll dfs(int u) {
  ll me = b[u] - a[u];
  for (auto [v, k] : g[u]) {
    ll tmp = dfs(v);
    if (tmp < 0) {
      if (-tmp > oo / k) {
        printf("NO\n");
        exit(0);
      }
      tmp *= k;
    }
    me += tmp;
    if (abs(me) >= oo) {
      printf("NO\n");
      exit(0);
    }
  }
  return me;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", b + i);
  for (int i = 1; i <= n; i++) scanf("%lld", a + i);
  for (int i = 2; i <= n; i++) {
    int x, k;
    scanf("%d %d", &x, &k);
    g[x].emplace_back(i, k);
  }
  printf("%s\n", dfs(1) >= 0 ? "YES" : "NO");
}
