#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const long long mod = 998244353;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const double eps = 1e-7;
inline long long read() {
  long long X = 0, w = 0;
  char ch = 0;
  while (!isdigit(ch)) {
    w |= ch == '-';
    ch = getchar();
  }
  while (isdigit(ch)) X = (X << 3) + (X << 1) + (ch ^ 48), ch = getchar();
  return w ? -X : X;
}
struct node {
  long long c11 = 0, c12 = 0, c13 = 0;
  long long c2 = 0;
  long long c3 = 0;
  long long num1 = 0, num2 = 0, num3 = 0;
} arr[maxn];
long long dp[maxn][15];
int main() {
  long long n = read();
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    long long k = read();
    for (int j = 1; j <= k; ++j) {
      long long c = read(), d = read();
      if (c == 1) {
        arr[i].num1++;
        if (d >= arr[i].c11) {
          arr[i].c13 = arr[i].c12;
          arr[i].c12 = arr[i].c11;
          arr[i].c11 = d;
        } else if (d >= arr[i].c12) {
          arr[i].c13 = arr[i].c12;
          arr[i].c12 = d;
        } else if (d >= arr[i].c13) {
          arr[i].c13 = d;
        }
      } else if (c == 2) {
        arr[i].num2 = 1;
        arr[i].c2 = max(arr[i].c2, d);
      } else if (c == 3) {
        arr[i].num3 = 1;
        arr[i].c3 = max(arr[i].c3, d);
      }
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j < 10; ++j) dp[i][j] = dp[i - 1][j];
    for (int j = 0; j < 10; ++j) {
      if (dp[i - 1][j] == -1) continue;
      if (arr[i].num1 + arr[i].num2 + arr[i].num3 >= 1) {
        dp[i][(j + 1) % 10] =
            max(dp[i][(j + 1) % 10],
                dp[i - 1][j] + max(arr[i].c11, max(arr[i].c2, arr[i].c3)) +
                    (j >= 9) * max(arr[i].c11, max(arr[i].c2, arr[i].c3)));
      }
      if (arr[i].num1 + arr[i].num2 >= 2) {
        long long tmp1 = arr[i].c11, tmp2 = arr[i].c12;
        if (arr[i].c2 > tmp1) {
          tmp2 = tmp1;
          tmp1 = arr[i].c2;
        } else if (arr[i].c2 > tmp2) {
          tmp2 = arr[i].c2;
        }
        dp[i][(j + 2) % 10] = max(dp[i][(j + 2) % 10],
                                  dp[i - 1][j] + tmp1 + tmp2 + (j >= 8) * tmp1);
      }
      if (arr[i].num1 >= 3) {
        dp[i][(j + 3) % 10] =
            max(dp[i][(j + 3) % 10], dp[i - 1][j] + arr[i].c11 + arr[i].c12 +
                                         arr[i].c13 + (j >= 7) * arr[i].c11);
      }
    }
  }
  long long ans = -1;
  for (int i = 0; i < 10; ++i) {
    ans = max(dp[n][i], ans);
  }
  cout << ans << endl;
  return 0;
}
