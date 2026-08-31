#include <bits/stdc++.h>
using namespace std;
int n, m;
int a[5002][5002];
int q[5002][4];
int v[5002], t[5002];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) v[i] = 1e9;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d%d", q[i], q[i] + 1, q[i] + 2, q[i] + 3);
    for (int j = 1; j <= n; j++) {
      if (q[i][0] == 1 && q[i][1] <= j && j <= q[i][2]) {
        a[i][j] = a[i - 1][j] + q[i][3];
      } else {
        a[i][j] = a[i - 1][j];
      }
    }
    if (q[i][0] == 2) {
      for (int j = q[i][1]; j <= q[i][2]; j++) {
        v[j] = min(v[j], q[i][3] - a[i][j]);
      }
    }
  }
  for (int i = 1; i <= n; i++)
    if (v[i] == 1e9) v[i] = 1e9;
  for (int i = 1; i <= n; i++) {
    t[i] = v[i];
  }
  bool ans = true;
  for (int i = 1; i <= m; i++) {
    if (q[i][0] == 1) {
      for (int j = q[i][1]; j <= q[i][2]; j++) {
        t[j] += q[i][3];
      }
    } else {
      int ma = -1e9;
      for (int j = q[i][1]; j <= q[i][2]; j++) {
        ma = max(ma, t[j]);
      }
      if (ma != q[i][3]) {
        ans = false;
        break;
      }
    }
  }
  if (ans) {
    cout << "YES\n";
    for (int i = 1; i <= n; i++) printf("%d ", v[i]);
  } else {
    cout << "NO";
  }
}
