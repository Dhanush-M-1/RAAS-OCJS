#include <bits/stdc++.h>
using namespace std;
int n;
int maxt[5210][5210];
int a[5210][5210];
char str[5210];
int getn(char ch) {
  if (ch >= '0' && ch <= '9') {
    return ch - '0';
  } else {
    return 10 + ch - 'A';
  }
}
int main() {
  scanf("%d", &n);
  memset(maxt, 0, sizeof(maxt));
  for (int i = 1; i <= n; i++) {
    scanf("%s", str + 1);
    int In = 0, len = strlen(str + 1);
    for (int j = len; j >= 1; j--) {
      int N = getn(str[j]);
      int Jn = 0;
      while (N) {
        a[i][n - In - Jn] = N % 2;
        N /= 2;
        Jn++;
      }
      for (; Jn < 4; Jn++) {
        if (n - In - Jn == 0) {
          break;
        }
        a[i][n - In - Jn] = 0;
      }
      In += Jn;
    }
    for (int j = n - In; j >= 1; j--) {
      a[i][j] = 0;
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      maxt[i][j] =
          a[i][j] + maxt[i - 1][j] + maxt[i][j - 1] - maxt[i - 1][j - 1];
    }
  }
  for (int I = n; I >= 1; I--) {
    if (n % I == 0) {
      int flag = 1;
      for (int i = 1; i <= (n / I); i++) {
        for (int j = 1; j <= (n / I); j++) {
          int cnt = maxt[i * I][j * I] - maxt[(i - 1) * I][j * I] -
                    maxt[i * I][(j - 1) * I] + maxt[(i - 1) * I][(j - 1) * I];
          if (cnt != I * I * a[i * I][j * I]) {
            flag = 0;
            break;
          }
        }
        if (!flag) {
          break;
        }
      }
      if (flag) {
        printf("%d\n", I);
        break;
      }
    }
  }
  return 0;
}
