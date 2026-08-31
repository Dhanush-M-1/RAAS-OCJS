#include <bits/stdc++.h>
using namespace std;
int n, m;
int p[300005];
vector<int> G[300005];
int in[300005];
int ans;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &p[i]);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    G[u].push_back(v);
  }
  in[p[n]] = 1;
  int ct2 = 1;
  for (int i = n - 1; i >= 1; i--) {
    int u = p[i];
    int ct = 0;
    for (auto v : G[u]) {
      if (in[v]) ct++;
    }
    if (ct == ct2) {
      ans++;
    } else {
      in[u] = 1;
      ct2++;
    }
  }
  printf("%d\n", ans);
}
