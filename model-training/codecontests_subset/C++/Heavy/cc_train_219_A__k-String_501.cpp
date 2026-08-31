#include <bits/stdc++.h>
using namespace std;
char s[1005];
int a[30];
int main() {
  int i, j, flag, k, p;
  while (~scanf("%d", &k)) {
    getchar();
    scanf("%s", s);
    memset(a, 0, sizeof(a));
    for (i = 0; s[i] != '\0'; i++) {
      a[s[i] - 'a' + 1]++;
    }
    flag = 1;
    for (i = 1; i <= 26; i++) {
      if (a[i] && a[i] / k != a[i] * 1.0 / k) {
        flag = 0;
        break;
      }
    }
    if (flag) {
      for (i = 1; i <= k; i++) {
        for (p = 1; p <= 26; p++) {
          if (a[p]) {
            for (j = 1; j <= a[p] / k; j++) putchar('a' + p - 1);
          }
        }
      }
    } else
      printf("-1");
    printf("\n");
  }
  return 0;
}
