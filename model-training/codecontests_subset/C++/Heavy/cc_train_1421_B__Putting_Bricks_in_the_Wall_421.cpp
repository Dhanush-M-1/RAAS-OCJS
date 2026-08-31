#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  int T;
  int n, i, j;
  char num[300][300];
  cin >> T;
  while (T--) {
    cin >> n;
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= n; j++) {
        cin >> num[i][j];
      }
    }
    int cnt = 0;
    cnt = num[2][1] + num[1][2] + num[n - 1][n] + num[n][n - 1] - 4 * '0';
    int x, y, t;
    if (cnt == 0 || cnt == 4) {
      printf("2\n1 2\n2 1\n");
    } else if (cnt == 1 || cnt == 3) {
      printf("1\n");
      if (cnt == 1)
        t = '0';
      else
        t = '1';
      if (num[2][1] != num[1][2]) {
        if (t == num[2][1])
          x = 2, y = 1;
        else
          x = 1, y = 2;
      } else {
        if (t == num[n][n - 1])
          x = n, y = n - 1;
        else
          x = n - 1, y = n;
      }
      printf("%d %d\n", x, y);
    } else {
      if (num[1][2] == num[2][1]) {
        printf("0\n");
      } else {
        printf("2\n1 2\n");
        if (num[n - 1][n] == num[1][2])
          printf("%d %d\n", n, n - 1);
        else
          printf("%d %d\n", n - 1, n);
      }
    }
  }
  return 0;
}
