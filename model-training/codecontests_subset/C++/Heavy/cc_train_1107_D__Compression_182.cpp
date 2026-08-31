#include <bits/stdc++.h>
using namespace std;
int n;
char s[6010];
int sum[5210][5210], c[5210][5210];
int b[10];
bool check(int x) {
  for (int i = 1; i <= n; i += x)
    for (int j = 1; j <= n; j += x) {
      int num = sum[i + x - 1][j + x - 1] - sum[i + x - 1][j - 1] -
                sum[i - 1][j + x - 1] + sum[i - 1][j - 1];
      if (num != x * x && num != 0) return (0);
    }
  return (1);
}
int main() {
  scanf("%d", &n);
  for (int ii = 0; ii <= n - 1; ii++) {
    scanf("%s", s);
    int len = n / 4;
    int k = 0;
    for (int i = 0; i <= len - 1; i++) {
      int o;
      if (s[i] >= 'A' && s[i] <= 'F')
        o = s[i] - 'A' + 10;
      else
        o = s[i] - '0';
      int num = 0;
      memset(b, 0, sizeof(b));
      while (o != 0) {
        num++;
        b[num] = o % 2;
        o /= 2;
      }
      for (int i = 4; i >= 1; i--) c[ii + 1][++k] = b[i];
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + c[i][j];
    }
  int o = 0;
  int ans = 0;
  for (int i = 1; i <= n; i++)
    if (n % i == 0) {
      if (check(i)) {
        ans = max(ans, i);
      }
    }
  printf("%d\n", ans);
  return (0);
}
