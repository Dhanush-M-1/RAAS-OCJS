#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  int w[500 + 11];
  int day[1011];
  bool vis[511];
  memset(vis, false, sizeof(vis));
  vector<int> L;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 1; i <= m; i++) {
    scanf("%d", &day[i]);
    if (!vis[day[i]]) {
      vis[day[i]] = true;
      L.push_back(day[i]);
    }
  }
  int ans = 0;
  for (int i = 1; i <= m; i++) {
    for (int j = 0; j < L.size(); j++) {
      if (day[i] == L[j]) {
        L.erase(L.begin() + j);
        L.insert(L.begin(), day[i]);
        break;
      } else
        ans += w[L[j]];
    }
  }
  printf("%d\n", ans);
  return 0;
}
