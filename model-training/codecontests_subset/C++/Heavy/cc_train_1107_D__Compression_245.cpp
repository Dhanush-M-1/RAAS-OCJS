#include <bits/stdc++.h>
using namespace std;
const int N = 5200;
int n;
int a[N + 10][N + 10];
char s[N + 10][N + 10];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%s", s[i]);
    for (int j = 0; j < n / 4; j++) {
      int key = s[i][j] - '0';
      if (s[i][j] >= 'A' && s[i][j] <= 'F') {
        key = s[i][j] - 'A' + 10;
      }
      for (int k = 0; k < 4; k++) {
        a[i][j * 4 + 4 - k] = key % 2;
        key /= 2;
      }
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + a[i][j];
  int ans = -1;
  for (int x = 1; x <= n; x++)
    if (n % x == 0) {
      bool flag = true;
      for (int i = x; i <= n; i += x) {
        for (int j = x; j <= n; j += x) {
          int x0 = i - x + 1, y0 = j - x + 1;
          int x1 = i, y1 = j;
          int num =
              a[x1][y1] - a[x0 - 1][y1] - a[x1][y0 - 1] + a[x0 - 1][y0 - 1];
          if (num != 0 && num != x * x) {
            flag = false;
            break;
          }
        }
        if (!flag) break;
      }
      if (flag) {
        ans = x;
      }
    }
  printf("%d\n", ans);
  return 0;
}
