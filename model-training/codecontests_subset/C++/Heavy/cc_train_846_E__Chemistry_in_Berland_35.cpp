#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
vector<int> g[N];
long long a[N], b[N], k[N];
bool check(long long x, long long y) {
  if (x > 1e18 / y) return false;
  return true;
}
long long dfs(int v) {
  long long tot = b[v] - a[v];
  for (int u : g[v]) {
    tot += dfs(u);
    if (abs(tot) > 1e18) {
      cout << "NO" << '\n';
      exit(0);
    }
  }
  if (tot >= 0) return tot;
  if (!check(-tot, k[v])) {
    cout << "NO" << '\n';
    exit(0);
  }
  tot *= k[v];
  return tot;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> b[i];
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (int i = 2; i <= n; i++) {
    int par;
    cin >> par >> k[i];
    g[par].push_back(i);
  }
  k[1] = 1;
  if (dfs(1) >= 0) {
    cout << "YES" << '\n';
  } else {
    cout << "NO" << '\n';
  }
  return 0;
}
