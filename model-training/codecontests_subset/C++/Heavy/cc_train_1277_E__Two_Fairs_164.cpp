#include <bits/stdc++.h>
using namespace std;
long long n, m, a, b;
vector<long long> v[1000006];
vector<bool> v1, v2;
void dfs1(long long node) {
  v1[node] = true;
  for (auto x : v[node]) {
    if (v1[x]) continue;
    dfs1(x);
  }
  return;
}
void dfs2(long long node) {
  v2[node] = true;
  for (auto x : v[node]) {
    if (v2[x]) continue;
    dfs2(x);
  }
  return;
}
int main() {
  long long tc;
  cin >> tc;
  while (tc--) {
    cin >> n >> m >> a >> b;
    v1.clear();
    v2.clear();
    for (long long i = 0; i <= n + 5; i++) v[i].clear();
    for (long long i = 0; i <= n + 5; i++) v1.push_back(false);
    for (long long i = 0; i <= n + 5; i++) v2.push_back(false);
    while (m--) {
      long long x, y;
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    v1[b] = true;
    dfs1(a);
    v2[a] = true;
    dfs2(b);
    long long x1, x2, res;
    x1 = x2 = 0LL;
    for (long long i = 1; i <= n; i++) {
      if (v1[i] && v2[i]) continue;
      if (v1[i]) x1++;
      if (v2[i]) x2++;
    }
    res = x1 * x2;
    cout << res << endl;
  }
  return 0;
}
