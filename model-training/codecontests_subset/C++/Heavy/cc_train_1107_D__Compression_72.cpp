#include <bits/stdc++.h>
using namespace std;
const int MAXN = 6e3;
int n;
int A[MAXN][MAXN];
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int ii = 1; ii <= n; ii++) {
    string row;
    cin >> row;
    for (int jj = 0; jj < row.size(); jj++) {
      int v =
          row[jj] >= '0' && row[jj] <= '9' ? row[jj] - '0' : row[jj] - 'A' + 10;
      for (int kk = jj * 4 + 4; kk >= jj * 4 + 1; kk--) {
        if (v & 1) A[ii][kk] = 1;
        v >>= 1;
      }
    }
  }
  for (int ii = 1; ii <= n; ii++) {
    for (int jj = 1; jj <= n; jj++) {
      if (ii == 1)
        A[ii][jj] += A[ii][jj - 1];
      else if (jj == 1)
        A[ii][jj] += A[ii - 1][jj];
      else
        A[ii][jj] += A[ii - 1][jj] + A[ii][jj - 1] - A[ii - 1][jj - 1];
    }
  }
  int ans = 1;
  for (int x = 1; x <= n; x++) {
    if (n % x) continue;
    bool flag = true;
    for (int ii = 1; ii <= n / x; ii++) {
      for (int jj = 1; jj <= n / x; jj++) {
        int x1 = (ii - 1) * x + 1, y1 = (jj - 1) * x + 1, x2 = ii * x,
            y2 = jj * x;
        int area =
            A[x2][y2] - A[x2][y1 - 1] - A[x1 - 1][y2] + A[x1 - 1][y1 - 1];
        if (area != 0 && area != (x2 - x1 + 1) * (y2 - y1 + 1)) flag = false;
      }
    }
    if (flag) ans = x;
  }
  cout << ans << endl;
}
