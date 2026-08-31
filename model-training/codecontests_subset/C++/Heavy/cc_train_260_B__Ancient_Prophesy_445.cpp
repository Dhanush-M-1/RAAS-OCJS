#include <bits/stdc++.h>
char str[100100];
int a[20], f[60000];
int main() {
  int i, j, l, r, y, n, x, p, s, ans, h;
  memset(a, 0, sizeof(a));
  a[4] = a[6] = a[9] = a[11] = 1;
  while (~scanf("%s", str)) {
    memset(f, 0, sizeof(f));
    ans = 0;
    h = 0;
    l = strlen(str);
    for (i = 0; i <= l - 10; i++) {
      x = 1;
      for (j = 0; j <= 9; j++) {
        if ((j == 2) || (j == 5)) {
          if (str[i + j] != '-') x = 0;
        } else {
          if (str[i + j] == '-') x = 0;
        }
      }
      if (x) {
        p = 1;
        r = (str[i] - '0') * 10 + (str[i + 1] - '0');
        y = (str[i + 3] - '0') * 10 + (str[i + 4] - '0');
        n = (str[i + 6] - '0') * 1000 + (str[i + 7] - '0') * 100 +
            (str[i + 8] - '0') * 10 + (str[i + 9] - '0');
        if (n < 2013 || n > 2015) p = 0;
        if ((y > 12) || (y < 1)) p = 0;
        if (y == 2) {
          if (r > 28) p = 0;
        } else if (a[y]) {
          if (r > 30) p = 0;
        } else {
          if (r > 31) p = 0;
        }
        if (r == 0) p = 0;
        if (p) {
          s = (n % 10) * 10000 + y * 100 + r;
          f[s]++;
          if (f[s] > h) {
            ans = s;
            h = f[s];
          }
          if (f[s] == h && ans > s) ans = s;
        }
      }
    }
    x = ans % 100;
    ans /= 100;
    p = ans % 100;
    ans /= 100;
    if (x / 10 == 0) printf("0");
    printf("%d-", x);
    if (p / 10 == 0) printf("0");
    printf("%d-201%d\n", p, ans);
  }
}
