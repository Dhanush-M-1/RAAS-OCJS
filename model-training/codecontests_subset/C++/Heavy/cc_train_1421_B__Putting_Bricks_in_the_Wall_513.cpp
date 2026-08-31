#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  for (int p = 1; p <= t; p++) {
    int n, z;
    cin >> n;
    vector<vector<int>> grid(n, vector<int>(n, 0));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char c;
        cin >> c;
        if ((i == 0 && j == 0) || (i == n - 1 && j == n - 1)) {
          continue;
        }
        grid[i][j] = c - 48;
      }
    }
    int ans = 0, p1x = -1, p1y = -1, p2x = -1, p2y = -1, x1 = grid[0][1],
        x2 = grid[1][0], x3 = grid[n - 2][n - 1], x4 = grid[n - 1][n - 2];
    if (x1 == 0 && x2 == 0) {
      if (x3 == 0 && x4 == 0) {
        ans = 2;
        p1x = 0, p1y = 1, p2x = 1, p2y = 0;
      } else if (x3 == 1 && x4 == 1) {
        ans = 0;
      } else if (x3 == 1 && x4 == 0) {
        ans = 1;
        p1x = n - 1, p1y = n - 2;
      } else if (x3 == 0 && x4 == 1) {
        ans = 1;
        p1x = n - 2, p1y = n - 1;
      }
    } else if (x1 == 1 && x2 == 1) {
      if (x3 == 0 && x4 == 0) {
        ans = 0;
      } else if (x3 == 1 && x4 == 1) {
        ans = 2;
        p1x = 0, p1y = 1, p2x = 1, p2y = 0;
      } else if (x3 == 1 && x4 == 0) {
        ans = 1;
        p1x = n - 2, p1y = n - 1;
      } else if (x3 == 0 && x4 == 1) {
        ans = 1;
        p1x = n - 1, p1y = n - 2;
      }
    } else if (x1 == 1 && x2 == 0) {
      if (x3 == 0 && x4 == 0) {
        ans = 1;
        p1x = 1, p1y = 0;
      } else if (x3 == 1 && x4 == 1) {
        ans = 1;
        p1x = 0, p1y = 1;
      } else if (x3 == 1 && x4 == 0) {
        ans = 2;
        p1x = 0, p1y = 1, p2x = n - 1, p2y = n - 2;
      } else if (x3 == 0 && x4 == 1) {
        ans = 2;
        p1x = 0, p1y = 1, p2x = n - 2, p2y = n - 1;
      }
    } else if (x1 == 0 && x2 == 1) {
      if (x3 == 0 && x4 == 0) {
        ans = 1;
        p1x = 0, p1y = 1;
      } else if (x3 == 1 && x4 == 1) {
        ans = 1;
        p1x = 1, p1y = 0;
      } else if (x3 == 1 && x4 == 0) {
        ans = 2;
        p1x = 0, p1y = 1, p2x = n - 2, p2y = n - 1;
      } else if (x3 == 0 && x4 == 1) {
        ans = 2;
        p1x = 0, p1y = 1, p2x = n - 1, p2y = n - 2;
      }
    }
    cout << ans << endl;
    if (ans == 0)
      ;
    else if (ans == 1) {
      cout << p1x + 1 << " " << p1y + 1 << endl;
    } else {
      cout << p1x + 1 << " " << p1y + 1 << endl
           << p2x + 1 << " " << p2y + 1 << endl;
    }
  }
  return 0;
}
