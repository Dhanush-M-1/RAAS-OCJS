#include <bits/stdc++.h>
using namespace std;
int n, m, ans[6001], tmp[6001], mi[6001], ord[6001][4];
int main() {
  cin >> n >> m;
  int l, r, c, t;
  for (int i = 0; i < n; i++) mi[i] = 1000000007;
  for (int i = 0; i < m; i++) {
    cin >> t >> l >> r >> c;
    l--;
    ord[i][0] = t, ord[i][1] = l, ord[i][2] = r, ord[i][3] = c;
    if (t == 1)
      for (int j = l; j < r; j++) tmp[j] += c;
    else
      for (int j = l; j < r; j++) mi[j] = min(mi[j], c - tmp[j]);
  }
  for (int i = 0; i < n; i++) {
    ans[i] = mi[i];
    if (mi[i] == 1000000007) ans[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    t = ord[i][0], l = ord[i][1], r = ord[i][2], c = ord[i][3];
    if (t == 1)
      for (int j = l; j < r; j++) mi[j] += c;
    else {
      int mx = -1000000007;
      for (int j = l; j < r; j++) mx = max(mx, mi[j]);
      if (mx != c) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 0; i < n; i++) cout << ans[i] << ' ';
  return 0;
}
