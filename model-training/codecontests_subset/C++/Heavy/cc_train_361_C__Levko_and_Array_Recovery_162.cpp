#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:36777216")
using namespace std;
int n, m, ans[5555], a[5555], t[5555], l[5555], r[5555], d[5555];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) ans[i] = 1000000000;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &d[i]);
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += d[i];
    else
      for (int j = l[i]; j <= r[i]; j++) ans[j] = min(ans[j], d[i] - a[j]);
  }
  memset(a, 0, sizeof(a));
  bool FLAG = true;
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += d[i];
    if (t[i] == 2) {
      int mx = -1000000000;
      for (int j = l[i]; j <= r[i]; j++) mx = max(mx, ans[j] + a[j]);
      if (mx != d[i]) FLAG = false;
    }
  }
  if (FLAG) {
    cout << "YES\n";
    for (int i = 1; i <= n; i++) cout << ans[i] << ' ';
    cout << endl;
  } else
    cout << "NO\n";
}
