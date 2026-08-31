#include <bits/stdc++.h>
using namespace std;
void add(long long &a, long long b) {
  if (a == 1e18) return;
  a += b;
  if (a > 1e18) a = 1e18;
}
long long mult(long long a, long long b) {
  if (a == 1e18) return 1e18;
  if (1e18 / b < a) return 1e18;
  a *= b;
  if (a > 1e18) return 1e18;
  return a;
}
int n;
long long b[100010], a[100010];
int par[100010], k[100010];
vector<int> ch[100010];
long long need[100010], excess[100010];
void dfs(int u) {
  for (int v : ch[u]) {
    dfs(v);
    excess[u] += excess[v];
    add(need[u], mult(need[v], k[v]));
  }
  if (b[u] < a[u]) {
    add(need[u], a[u] - b[u]);
  } else {
    excess[u] += b[u] - a[u];
  }
  long long amt = min(need[u], excess[u]);
  add(need[u], -amt);
  excess[u] -= amt;
}
int main() {
  ios::sync_with_stdio(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> b[i];
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 2; i <= n; i++) {
    cin >> par[i] >> k[i];
    ch[par[i]].push_back(i);
  }
  dfs(1);
  cout << (need[1] == 0 ? "YES" : "NO") << '\n';
}
