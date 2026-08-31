#include <bits/stdc++.h>
int n, m, s, v, ans;
bool occ[111];
int main() {
  scanf("%d%d", &n, &m);
  ans = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &s);
    for (int j = 0; j < s; j++) {
      scanf("%d", &v);
      if (!occ[v]) ans++;
      occ[v] = true;
    }
  }
  printf("%s\n", ans < m ? "NO" : "YES");
  return 0;
}
