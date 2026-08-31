#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-6;
const int64_t MOD = 1000000007;
const int MAXN = 5205;
int sum[MAXN][MAXN];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.precision(10);
  cout << fixed;
  int n;
  cin >> n;
  for (int i = 0; i < (int)(n); i++) {
    string s;
    cin >> s;
    for (int j = 0; j < (int)(n / 4); j++) {
      int x = (s[j] >= '0' && s[j] <= '9') ? s[j] - '0' : s[j] - 'A' + 10;
      for (int k = 0; k < (int)(4); k++) {
        int p = ((x & (1 << (3 - k))) > 0) ? 1 : 0;
        sum[i + 1][4 * j + k + 1] = sum[i + 1][4 * j + k] +
                                    sum[i][4 * j + k + 1] - sum[i][4 * j + k] +
                                    p;
      }
    }
  }
  for (int d = (int)n; d >= (int)(2); d--) {
    if (n % d == 0) {
      bool ok = true;
      for (int i = 0; i < (int)(n / d); i++) {
        for (int j = 0; j < (int)(n / d); j++) {
          int x1 = i * d;
          int y1 = j * d;
          int x2 = (i + 1) * d;
          int y2 = (j + 1) * d;
          int s = sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1];
          if (s != 0 && s != d * d) {
            ok = false;
            break;
          }
        }
        if (!ok) {
          break;
        }
      }
      if (ok) {
        cout << d << "\n";
        exit(0);
      }
    }
  }
  cout << "1\n";
  return 0;
}
