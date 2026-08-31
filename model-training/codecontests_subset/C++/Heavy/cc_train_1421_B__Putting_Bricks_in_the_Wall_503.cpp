#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, i, j, count = 0;
    cin >> n;
    char ch[n + 1][n + 1];
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= n; j++) {
        cin >> ch[i][j];
      }
    }
    long long int b[5][5];
    b[1][2] = b[2][1] = 0;
    b[3][1] = b[2][2] = b[1][3] = 1;
    long long int c[5][5];
    c[1][2] = c[2][1] = 1;
    c[3][1] = c[2][2] = c[1][3] = 0;
    count = 0;
    for (i = 1; i <= 3; i++) {
      for (j = 1; j <= 3; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        if (i + j <= 4) {
          if (ch[i][j] - '0' != b[i][j]) {
            count++;
          }
        }
      }
    }
    if (count <= 2) {
      cout << count << '\n';
      for (i = 1; i <= 3; i++) {
        for (j = 1; j <= 3; j++) {
          if (i == 1 && j == 1) {
            continue;
          }
          if (i + j <= 4) {
            if (ch[i][j] - '0' != b[i][j]) {
              cout << i << " " << j << '\n';
            }
          }
        }
      }
    } else {
      count = 0;
      for (i = 1; i <= 3; i++) {
        for (j = 1; j <= 3; j++) {
          if (i == 1 && j == 1) {
            continue;
          }
          if (i + j <= 4) {
            if (ch[i][j] - '0' != c[i][j]) {
              count++;
            }
          }
        }
      }
      cout << count << '\n';
      for (i = 1; i <= 3; i++) {
        for (j = 1; j <= 3; j++) {
          if (i == 1 && j == 1) {
            continue;
          }
          if (i + j <= 4) {
            if (ch[i][j] - '0' != c[i][j]) {
              cout << i << " " << j << '\n';
            }
          }
        }
      }
    }
  }
}
