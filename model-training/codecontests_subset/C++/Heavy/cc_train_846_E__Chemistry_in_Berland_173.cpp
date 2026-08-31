#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
int n;
long long b[100000], a[100000];
vector<pair<int, int> > adj[100000];
long long dfs(int u) {
  long long ret = b[u] - a[u];
  for (auto v : adj[u]) {
    long long res = dfs(v.first);
    if (res < 0) {
      res = -res;
      if (res > INF / v.second)
        ret = -INF;
      else {
        ret = ret - res * v.second;
        ret = max(ret, -INF);
      }
    } else
      ret = ret + res;
  }
  return ret;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) scanf("%lld", &b[i]);
  for (int i = 0; i < n; i++) scanf("%lld", &a[i]);
  for (int i = 0; i < n - 1; i++) {
    int x;
    long long k;
    scanf("%d %lld", &x, &k);
    int u = x - 1;
    int v = i + 1;
    adj[u].push_back({v, k});
  }
  long long res = dfs(0);
  if (res >= 0)
    puts("YES");
  else
    puts("NO");
  return 0;
}
