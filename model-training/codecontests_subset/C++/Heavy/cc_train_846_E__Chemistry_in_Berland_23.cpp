#include <bits/stdc++.h>
using namespace std;
const int N = 5e5 + 15;
const long long inf = -4e18;
long long value[N];
vector<pair<int, long long> > adj[N];
long long convert(long long x, long long k) {
  if (x >= 0) return x;
  if (abs(x) <= abs(inf) / k) {
    return x * k;
  } else {
    return inf;
  }
}
long long add(long long x, long long y) { return max(x + y, inf); }
long long dfs(int node) {
  long long &ret = value[node];
  for (pair<int, long long> edge : adj[node]) {
    ret = add(ret, convert(dfs(edge.first), edge.second));
  }
  return ret;
}
void solve() {
  int n;
  scanf("%d ", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%lld ", &value[i]);
  }
  for (int i = 1; i <= n; ++i) {
    long long a;
    scanf("%lld ", &a);
    value[i] -= a;
  }
  for (int i = 2; i <= n; ++i) {
    int p;
    long long w;
    scanf("%d %lld ", &p, &w);
    adj[p].push_back({i, w});
  }
  if (dfs(1) >= 0) {
    printf("YES\n");
  } else {
    printf("NO\n");
  }
}
int main() {
  solve();
  return 0;
}
