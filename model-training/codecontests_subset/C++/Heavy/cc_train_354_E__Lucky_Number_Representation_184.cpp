#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
const int INF = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
int c[20];
bool vis[20][10];
int A[20][10], B[20][10];
long long P[20];
long long res[7];
int main() {
  P[0] = 1;
  for (int i = 1; i <= 18; ++i) P[i] = P[i - 1] * 10;
  int T;
  cin >> T;
  while (T--) {
    long long n;
    cin >> n;
    int len = 0;
    while (n) c[++len] = n % 10, n /= 10;
    memset(vis, false, sizeof(vis));
    vis[0][0] = true;
    for (int i = 0; i < len; ++i) {
      for (int j = 0; j < 20; ++j)
        if (j < 10 && vis[i][j]) {
          for (int a = 0; a <= 6; ++a) {
            for (int b = 0; a + b <= 6; ++b) {
              int tmp = a * 4 + b * 7 + j;
              if ((tmp % 10) != c[i + 1]) continue;
              vis[i + 1][tmp / 10] = true;
              A[i + 1][tmp / 10] = a;
              B[i + 1][tmp / 10] = b;
            }
          }
        }
    }
    if (!vis[len][0]) {
      puts("-1");
      continue;
    }
    int m = 0;
    memset(res, 0, sizeof(res));
    for (int i = len; i >= 1; --i) {
      int a = A[i][m];
      int b = B[i][m];
      int tmp = a * 4 + b * 7;
      m = m * 10 + c[i] - tmp;
      int j = 1;
      for (; j <= a; ++j) res[j] += 4 * P[i - 1];
      for (; j <= a + b; ++j) res[j] += 7 * P[i - 1];
    }
    for (int i = 1; i <= 6; ++i) cout << res[i] << ' ';
    puts("");
  }
  return 0;
}
