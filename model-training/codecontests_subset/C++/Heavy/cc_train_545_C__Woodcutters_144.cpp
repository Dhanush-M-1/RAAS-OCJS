#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, i, j;
  cin >> n;
  long long int a[n][2], ans[n][3][2];
  for (i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
    for (j = 0; j < 6; j++) ans[i][j / 2][j % 2] = 0;
  }
  ans[0][0][0] = 1;
  ans[0][0][1] = a[0][0];
  for (i = 1; i < n; i++) {
    for (j = 0; j < 3; j++) {
      if (a[i][0] - a[i][1] > ans[i - 1][j][1]) {
        if (ans[i - 1][j][0] + 1 > ans[i][0][0]) {
          ans[i][0][0] = ans[i - 1][j][0] + 1;
          ans[i][0][1] = a[i][0];
        }
      } else {
        if (ans[i - 1][j][0] > ans[i][0][0]) {
          ans[i][0][0] = ans[i - 1][j][0];
          ans[i][0][1] = a[i][0];
        }
      }
      ans[i][1][0] = max(ans[i - 1][j][0], ans[i][1][0]);
      ans[i][1][1] = a[i][0];
      if (a[i][0] > ans[i - 1][j][1] &&
          ((i < n - 1 && a[i][0] + a[i][1] < a[i + 1][0]) || i == n - 1)) {
        if (ans[i - 1][j][0] + 1 > ans[i][2][0]) {
          ans[i][2][0] = ans[i - 1][j][0] + 1;
          ans[i][2][1] = a[i][0] + a[i][1];
        }
      } else {
        if (ans[i - 1][j][0] > ans[i][2][0]) {
          ans[i][2][0] = ans[i - 1][j][0];
          ans[i][2][1] = a[i][0];
        }
      }
    }
  }
  cout << max(ans[n - 1][0][0], max(ans[n - 1][1][0], ans[n - 1][2][0]));
  return 0;
}
