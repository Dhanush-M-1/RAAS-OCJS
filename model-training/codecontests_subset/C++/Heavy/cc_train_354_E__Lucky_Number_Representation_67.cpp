#include <bits/stdc++.h>
using namespace std;
int t, b[25];
long long n;
bool dp[25][15][15][10];
int main() {
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 0; i <= 20; ++i) {
      for (int j = 0; j <= 6; ++j) {
        for (int k = 0; k <= 6; ++k) {
          for (int v = 0; v <= 4; ++v) dp[i][j][k][v] = 0;
        }
      }
    }
    dp[0][0][0][0] = 1;
    int x = 1;
    vector<long long> d;
    for (int i = 1; i <= 6; ++i) d.push_back(0);
    int a = n % 10;
    while (n) {
      for (int i = 0; i <= 6; ++i) {
        for (int j = 0; j <= 6 - i; ++j) {
          for (int k = 0; k <= 4; ++k) {
            if (dp[x - 1][i][j][k]) {
              for (int m = 0; m <= 6; ++m) {
                for (int t = 0; t <= 6 - m; ++t) {
                  if ((m * 4 + t * 7 + k) % 10 == a) {
                    dp[x][m][t][(m * 4 + t * 7 + k) / 10] = 1;
                  }
                }
              }
            }
          }
        }
      }
      b[x] = a;
      ++x;
      n /= 10;
      a = n % 10;
    }
    int k = 0;
    bool u = 0;
    while (x > 1) {
      --x;
      u = 0;
      for (int i = 0; i <= 6; ++i) {
        for (int j = 0; j <= 6 - i; ++j) {
          if (dp[x][i][j][k]) {
            for (int l = 0; l < 6; ++l) d[l] *= 10;
            for (int p = 0; p < i; ++p) d[p] += 4;
            for (int q = i; q < i + j; ++q) d[q] += 7;
            u = 1;
            k = (b[x] + 10 - (i * 4 + j * 7) % 10) % 10;
            break;
          }
        }
        if (u) break;
      }
      if (!u) {
        cout << -1;
        break;
      }
    }
    if (u) {
      for (int i = 0; i < 6; ++i) cout << d[i] << ' ';
    }
    cout << '\n';
  }
}
