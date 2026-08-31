#include <bits/stdc++.h>
using namespace std;
vector<long long> tree[200009], ans;
long long sz[200009];
void dfs(long long u, long long p) {
  for (long long i = 0; i < tree[u].size(); i++) {
    long long nd = tree[u][i];
    if (nd == p) continue;
    dfs(nd, u);
  }
  if (sz[u] % 2 != 0 || sz[u] == 0) return;
  ans.push_back(u);
  sz[u] = 0;
  for (long long i = 0; i < tree[u].size(); i++) {
    long long nd = tree[u][i];
    sz[nd]--;
    if (sz[nd] == 0) ans.push_back(nd);
  }
}
void dfs2(long long u, long long p) {
  if (sz[u] % 2 == 0 && sz[u] != 0) {
    ans.push_back(u);
    sz[u] = 0;
    for (long long i = 0; i < tree[u].size(); i++) {
      long long nd = tree[u][i];
      sz[nd]--;
      if (sz[nd] == 0) ans.push_back(nd);
    }
  }
  for (long long i = 0; i < tree[u].size(); i++) {
    long long nd = tree[u][i];
    if (nd == p) continue;
    dfs2(nd, u);
  }
}
int main() {
  long long n;
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long u;
    scanf("%lld", &u);
    if (u == 0) continue;
    tree[u].push_back(i);
    tree[i].push_back(u);
  }
  if (n == 1) {
    cout << "YES" << endl << 1 << endl;
    return 0;
  }
  for (long long i = 1; i <= n; i++) sz[i] = tree[i].size();
  dfs(1, 0);
  dfs2(1, 0);
  if (ans.size() != n) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  for (long long i = 0; i < ans.size(); i++) printf("%lld\n", ans[i]);
  return 0;
}
