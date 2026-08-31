#include <bits/stdc++.h>
using namespace std;
int n;
bool a[5210][5210];
int sum[5210][5210];
char str[1310];
void ji_su_shuang_du() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", str + 1);
    for (int j = 1; j <= n / 4; j++) {
      int num = (str[j] < 'A' ? str[j] - '0' : str[j] - 'A' + 10);
      for (int k = 3; k >= 0; k--) a[i][j * 4 - k] = (num & (1 << k) ? 1 : 0);
    }
  }
}
void getsum() {
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + a[i][j];
}
bool check(int x) {
  for (int i = x; i <= n; i += x) {
    for (int j = x; j <= n; j += x) {
      int x2 = i, y2 = j;
      int x1 = i - x + 1, y1 = j - x + 1;
      int s =
          sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
      if (s != 0 && s != x * x) return false;
    }
  }
  cout << x << endl;
  return true;
}
int main() {
  ji_su_shuang_du();
  getsum();
  for (int x = n; x >= 1; x--)
    if (n % x == 0 && check(x)) break;
  return 0;
}
