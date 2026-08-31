#include <bits/stdc++.h>
int main() {
  int t;
  scanf("%d", &t);
  int x[3];
  int y[3];
  int num;
  char str[205][205];
  while (t--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%s", &str[i][1]);
    num = 0;
    if (str[2][1] == str[1][2]) {
      if (str[n - 1][n] == str[2][1]) {
        x[num] = n - 1;
        y[num] = n;
        num++;
      }
      if (str[n][n - 1] == str[2][1]) {
        x[num] = n;
        y[num] = n - 1;
        num++;
      }
    } else if (str[n - 1][n] == str[n][n - 1]) {
      if (str[2][1] == str[n - 1][n]) {
        x[num] = 2;
        y[num] = 1;
        num++;
      }
      if (str[1][2] == str[n - 1][n]) {
        x[num] = 1;
        y[num] = 2;
        num++;
      }
    } else {
      x[num] = 1;
      y[num] = 2;
      num++;
      if (str[n - 1][n] == str[2][1]) {
        x[num] = n - 1;
        y[num] = n;
        num++;
      } else {
        x[num] = n;
        y[num] = n - 1;
        num++;
      }
    }
    printf("%d\n", num);
    for (int i = 0; i < num; i++) printf("%d %d\n", x[i], y[i]);
  }
  return 0;
}
