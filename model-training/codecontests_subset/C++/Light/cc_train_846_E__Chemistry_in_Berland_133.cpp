#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e5 + 10;
vector<pair<long long, long long> > g[MAXN];
long long a[MAXN], b[MAXN], sum;
void dfs(long long v, long long p = -1, long long x = -1) {
  for (pair<long long, long long> u : g[v]) dfs(u.first, v, u.second);
  if (a[v] < b[v] and p != -1) {
    if ((b[v] - a[v]) * x > sum) return;
    a[p] -= (b[v] - a[v]) * x;
    a[v] = b[v];
  } else if (p != -1) {
    long long k = (a[v] - b[v]);
    a[p] += k;
    a[v] -= k;
  }
}
int32_t main() {
  ios::sync_with_stdio(false);
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  for (long long i = 0; i < n; i++) cin >> b[i];
  long long TMP = 0;
  for (long long i = 1; i < n; i++) {
    long long v, k;
    cin >> v >> k;
    TMP = max(TMP, k);
    v--;
    g[v].push_back({i, k});
  }
  dfs(0);
  for (long long i = 0; i < n; i++)
    if (a[i] < b[i]) {
      cout << "NO" << endl;
      return 0;
    }
  cout << "YES" << endl;
  return 0;
}
