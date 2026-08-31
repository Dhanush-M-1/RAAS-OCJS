#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<vector<int>> a(n + 1, vector<int>(n + 1));
  for (int i = 1; i <= n; ++i) {
    string second;
    cin >> second;
    char c;
    int y = 0;
    for (int j = 1; j <= n; j += 4) {
      c = second[y];
      ++y;
      if (c == '0') {
        a[i][j] = 0;
        a[i][j + 1] = 0;
        a[i][j + 2] = 0;
        a[i][j + 3] = 0;
      } else if (c == '1') {
        a[i][j] = 0;
        a[i][j + 1] = 0;
        a[i][j + 2] = 0;
        a[i][j + 3] = 1;
      } else if (c == '2') {
        a[i][j] = 0;
        a[i][j + 1] = 0;
        a[i][j + 2] = 1;
        a[i][j + 3] = 0;
      } else if (c == '3') {
        a[i][j] = 0;
        a[i][j + 1] = 0;
        a[i][j + 2] = 1;
        a[i][j + 3] = 1;
      } else if (c == '4') {
        a[i][j] = 0;
        a[i][j + 1] = 1;
        a[i][j + 2] = 0;
        a[i][j + 3] = 0;
      } else if (c == '5') {
        a[i][j] = 0;
        a[i][j + 1] = 1;
        a[i][j + 2] = 0;
        a[i][j + 3] = 1;
      } else if (c == '6') {
        a[i][j] = 0;
        a[i][j + 1] = 1;
        a[i][j + 2] = 1;
        a[i][j + 3] = 0;
      } else if (c == '7') {
        a[i][j] = 0;
        a[i][j + 1] = 1;
        a[i][j + 2] = 1;
        a[i][j + 3] = 1;
      } else if (c == '8') {
        a[i][j] = 1;
        a[i][j + 1] = 0;
        a[i][j + 2] = 0;
        a[i][j + 3] = 0;
      } else if (c == '9') {
        a[i][j] = 1;
        a[i][j + 1] = 0;
        a[i][j + 2] = 0;
        a[i][j + 3] = 1;
      } else if (c == 'A') {
        a[i][j] = 1;
        a[i][j + 1] = 0;
        a[i][j + 2] = 1;
        a[i][j + 3] = 0;
      } else if (c == 'B') {
        a[i][j] = 1;
        a[i][j + 1] = 0;
        a[i][j + 2] = 1;
        a[i][j + 3] = 1;
      } else if (c == 'C') {
        a[i][j] = 1;
        a[i][j + 1] = 1;
        a[i][j + 2] = 0;
        a[i][j + 3] = 0;
      } else if (c == 'D') {
        a[i][j] = 1;
        a[i][j + 1] = 1;
        a[i][j + 2] = 0;
        a[i][j + 3] = 1;
      } else if (c == 'E') {
        a[i][j] = 1;
        a[i][j + 1] = 1;
        a[i][j + 2] = 1;
        a[i][j + 3] = 0;
      } else if (c == 'F') {
        a[i][j] = 1;
        a[i][j + 1] = 1;
        a[i][j + 2] = 1;
        a[i][j + 3] = 1;
      }
    }
  }
  for (int k = 1; k <= n / 2; ++k) {
    if (n % k == 0) {
      int f4 = 0;
      int r = n / k;
      for (int i = 1; i <= n; i += r) {
        int f3 = 0;
        for (int j = 1; j <= n; j += r) {
          int f2 = 0;
          int q = a[i][j];
          for (int a1 = 0; a1 < r; ++a1) {
            int f1 = 0;
            for (int a2 = 0; a2 < r; ++a2) {
              if (a[a1 + i][a2 + j] != q) {
                f1 = 1;
                break;
              }
            }
            if (f1) {
              f2 = 1;
              break;
            }
          }
          if (f2) {
            f3 = 1;
            break;
          }
        }
        if (f3) {
          f4 = 1;
          break;
        }
      }
      if (f4 == 0) {
        cout << r;
        return;
      }
    }
  }
  cout << 1;
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
