#include <bits/stdc++.h>
using namespace std;
const int _max = 3e5 + 10;
int p[_max];
vector<int> G[_max];
vector<bool> vis(_max);
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) scanf("%d", p + i);
  int u, v;
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &u, &v);
    G[u].push_back(v);
  }
  vis[p[n - 1]] = 1;
  int ans = 0, cnt = 1;
  for (int i = n - 2; i >= 0; i--) {
    int cnt2 = 0;
    vector<int>& viG = G[p[i]];
    for (int j = 0; j < viG.size(); j++)
      if (vis[viG[j]]) cnt2++;
    if (cnt2 == cnt)
      ans++;
    else {
      vis[p[i]] = 1;
      cnt++;
    }
  }
  printf("%d", ans);
  return 0;
}
