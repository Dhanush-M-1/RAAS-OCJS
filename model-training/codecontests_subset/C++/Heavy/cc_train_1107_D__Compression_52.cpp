#include <bits/stdc++.h>
using namespace std;
void tobin(char hex, int bin[]) {
  int x;
  if (hex >= 48 && hex <= 57)
    x = hex - '0';
  else
    x = hex - 'A' + 10;
  int k = 4;
  while (k >= 1) {
    bin[k] = x % 2;
    x = x / 2;
    k--;
  }
}
int sum(int *dp[5201], bool *a[5201], int n) {
  for (int i = 0; i <= n; i++) dp[i][0] = dp[0][i] = 0;
  for (int i = 1; i <= n; i++) {
    dp[i][1] = dp[i - 1][1] + a[i][1];
    dp[1][i] = dp[1][i - 1] + a[1][i];
  }
  for (int i = 2; i <= n; i++) {
    for (int j = 2; j <= n; j++) {
      dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + a[i][j] - dp[i - 1][j - 1];
    }
  }
  for (int x = n; x >= 1; x--) {
    if (n % x != 0) continue;
    int flag = 1;
    for (int i = 1; i <= n / x; i++) {
      for (int j = 1; j <= n / x; j++) {
        int y = dp[i * x][j * x] - dp[(i - 1) * x][j * x] -
                dp[i * x][(j - 1) * x] + dp[(i - 1) * x][(j - 1) * x];
        if (y != 0 && y != x * x) {
          flag = 0;
          break;
        }
      }
      if (flag == 0) break;
    }
    if (flag == 1) return x;
  }
}
int main() {
  int n;
  cin >> n;
  int bin[5];
  bool *a[5201];
  int *dp[5201];
  for (int i = 0; i <= 5200; i++) {
    a[i] = new bool[5201];
    dp[i] = new int[5201];
  }
  char ch[1301];
  for (int i = 1; i <= n; i++) {
    cin >> ch;
    int j = 1;
    for (int k = 0; ch[k] != '\0'; k++) {
      tobin(ch[k], bin);
      for (int t = 1; t <= 4; t++) a[i][j++] = bin[t];
    }
  }
  int ans = sum(dp, a, n);
  cout << ans << endl;
  return 0;
}
