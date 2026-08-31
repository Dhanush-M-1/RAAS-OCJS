#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, d, l, t, r, a[6000], b[6000], w[6000][4];
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    a[i] = 1000000000;
    b[i] = 0;
  }
  bool flag = true;
  for (int i = 1; i <= m; i++) {
    cin >> t >> l >> r >> d;
    w[i][0] = t;
    w[i][1] = l;
    w[i][2] = r;
    w[i][3] = d;
    if (t == 1) {
      for (int k = l; k <= r; k++) {
        a[k] += d;
        b[k] -= d;
      }
    } else {
      bool f = 0;
      for (int k = l; k <= r; k++)
        if (a[k] >= d) {
          a[k] = d;
          f = 1;
        }
      if (f == 0) flag = false;
    }
  }
  if (!flag) {
    cout << "NO";
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    a[i] += b[i];
    b[i] = a[i];
  }
  for (int i = 1; i <= m; i++) {
    if (w[i][0] == 1) {
      for (int k = w[i][1]; k <= w[i][2]; k++) b[k] += w[i][3];
    } else {
      int max = b[w[i][1]];
      for (int k = w[i][1] + 1; k <= w[i][2]; k++)
        if (b[k] > max) max = b[k];
      if (max != w[i][3]) {
        flag = false;
        break;
      }
    }
  }
  if (!flag) {
    cout << "NO";
    return 0;
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << a[i] << " ";
  return 0;
}
