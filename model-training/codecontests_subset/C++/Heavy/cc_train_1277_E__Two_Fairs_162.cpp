#include <bits/stdc++.h>
using namespace std;
const long long N = 200009;
long long n, m, a, b;
vector<long long> graph[N];
void dfs(long long cur, long long blocked, unordered_set<long long>& seen) {
  seen.insert(cur);
  for (long long child : graph[cur]) {
    if (child != blocked && !seen.count(child)) {
      dfs(child, blocked, seen);
    }
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    for (long long i = 1; i <= n; ++i) graph[i].clear();
    unordered_set<long long> froma, fromb;
    for (long long i = 0; i < m; ++i) {
      long long u, v;
      cin >> u >> v;
      graph[u].push_back(v);
      graph[v].push_back(u);
    }
    dfs(a, b, froma);
    dfs(b, a, fromb);
    long long x = 0;
    for (long long fa : froma) {
      if (!fromb.count(fa)) x++;
    }
    long long y = fromb.size() - (froma.size() - x);
    cout << (x - 1) * (y - 1) << '\n';
  }
  return 0;
}
