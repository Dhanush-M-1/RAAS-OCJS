#include <bits/stdc++.h>
using namespace std;
int a[1008], b[1008], vis[1008];
int main() {
  int t, m, n, i, j, k, l;
  scanf("%d", &n);
  scanf("%d", &m);
  memset(vis, 0, sizeof(vis));
  a[0] = 0;
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  vector<int> v;
  v.clear();
  for (i = 1; i <= m; i++) {
    scanf("%d", &b[i]);
    j = b[i];
    if (!vis[j]) v.push_back(j);
    vis[j] = 1;
  }
  long long ans = 0;
  for (i = 1; i <= n; i++) {
    if (!vis[i]) v.push_back(i);
  }
  vector<int> vv;
  for (i = v.size() - 1; i >= 0; i--) vv.push_back(v[i]);
  v = vv;
  for (i = 1; i <= m; i++) {
    k = b[i];
    for (j = v.size() - 1; j >= 0; j--) {
      if (v[j] == k) break;
      ans += a[v[j]];
    }
    v[j] = 0;
    v.push_back(k);
  }
  cout << ans << "\n";
  return 0;
}
