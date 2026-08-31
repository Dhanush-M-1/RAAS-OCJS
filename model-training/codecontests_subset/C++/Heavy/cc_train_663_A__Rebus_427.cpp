#include <bits/stdc++.h>
using namespace std;
char a[105][5], b[105][5];
int p = 0, q = 0, n, num = 1;
void init() {
  int i = 1;
  scanf("%s", a[0]);
  a[0][0] = '+';
  while (scanf("%s", a[i])) {
    if (a[i][0] == '=') {
      scanf("%d", &n);
      return;
    }
    scanf("%s", b[i]);
    num++;
    if (a[i][0] == '+')
      p++;
    else
      q++;
    i++;
  }
}
void work() {
  if (p == 0 && q != 0)
    puts("Impossible");
  else if (p == 0 && q == 0)
    printf("Possible\n%d = %d", n, n);
  else if (p + 1 > n && q == 0)
    puts("Impossible");
  else if (p + 1 <= n && q == 0) {
    puts("Possible");
    printf("%d ", n - p);
    for (int i = 2; i <= num; i++) printf("%c 1 ", a[i - 1][0]);
    printf("= %d\n", n);
  } else if (p - q * n >= n || n * p - q < 0)
    puts("Impossible");
  else if (p > q) {
    int x = p - q;
    puts("Possible");
    if (p - q * n <= 0) {
      printf("%d ", n);
      for (int i = 2; i <= num; i++) {
        if (a[i - 1][0] == '+')
          printf("%c 1 ", a[i - 1][0]);
        else {
          if (x > 0) {
            printf("%c %d ", a[i - 1][0], min(x + 1, n));
            x -= min(x, n - 1);
          } else
            printf("%c 1 ", a[i - 1][0]);
        }
      }
    } else {
      printf("%d ", n - (p - q * n));
      for (int i = 2; i <= num; i++) {
        if (a[i - 1][0] == '+')
          printf("%c 1 ", a[i - 1][0]);
        else {
          if (x > 0) {
            printf("%c %d ", a[i - 1][0], min(x + 1, n));
            x -= min(x, n - 1);
          } else
            printf("%c 1 ", a[i - 1][0]);
        }
      }
    }
    printf("= %d\n", n);
  } else if (p < q) {
    int x = q - p;
    puts("Possible");
    printf("%d ", n);
    for (int i = 2; i <= num; i++) {
      if (a[i - 1][0] == '-')
        printf("%c 1 ", a[i - 1][0]);
      else {
        if (x > 0) {
          printf("%c %d ", a[i - 1][0], min(x + 1, n));
          x -= min(x, n - 1);
        } else
          printf("%c 1 ", a[i - 1][0]);
      }
    }
    printf("= %d\n", n);
  } else {
    puts("Possible");
    printf("%d ", n);
    for (int i = 2; i <= num; i++) printf("%c 1 ", a[i - 1][0]);
    printf("= %d\n", n);
  }
}
int main() {
  init();
  work();
  return 0;
}
