#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  char a[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) cin >> a[i][j];
  }
  int w, x, y, z, cnt = 0, ans[4];
  w = a[0][1];
  x = a[1][0];
  y = a[n - 1][n - 2];
  z = a[n - 2][n - 1];
  if (w == x) {
    if (y == z) {
      if (w == y) {
        cnt = 2;
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;
        ans[3] = 0;
      }
    } else {
      if (w == y) {
        cnt++;
        ans[0] = n - 1;
        ans[1] = n - 2;
      } else if (w == z) {
        cnt++;
        ans[0] = n - 2;
        ans[1] = n - 1;
      }
    }
  } else {
    if (y == z) {
      if (w == y) {
        cnt++;
        ans[0] = 0;
        ans[1] = 1;
      } else if (x == y) {
        cnt++;
        ans[0] = 1;
        ans[1] = 0;
      }
    } else {
      cnt++;
      ans[0] = 1;
      ans[1] = 0;
      x = w;
      if (x == y) {
        cnt++;
        ans[2] = n - 1;
        ans[3] = n - 2;
      } else if (x == z) {
        cnt++;
        ans[2] = n - 2;
        ans[3] = n - 1;
      }
    }
  }
  cout << cnt << endl;
  cnt *= 2;
  for (int i = 0; i < cnt; i += 2) {
    cout << ans[i] + 1 << " " << ans[i + 1] + 1;
    cout << endl;
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
