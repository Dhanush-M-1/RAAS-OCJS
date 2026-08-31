#include <bits/stdc++.h>
using namespace std;
char s[25];
int a[1005];
int b[1005];
int main() {
  int t, m, n, num;
  while (scanf("%d%d", &t, &m) != EOF) {
    num = 1;
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
    while (t--) {
      scanf("%s", s);
      if (s[0] == 'a') {
        scanf("%d", &n);
        int flag = 0;
        for (int i = 1; i <= m; i++) {
          if (flag == 1) break;
          if (a[i] == 0) {
            int cnt = 1;
            if (cnt == n) {
              a[i] = num;
              b[num] = 1;
              printf("%d\n", num);
              num++;
              flag = 1;
            }
            for (int j = i + 1; j <= m; j++) {
              if (a[j] == 0) {
                cnt++;
                if (cnt == n) {
                  for (int k = i; k <= j; k++) a[k] = num;
                  b[num] = 1;
                  printf("%d\n", num);
                  num++;
                  flag = 1;
                  break;
                }
              } else
                break;
            }
          }
        }
        if (flag == 0) printf("NULL\n");
      } else if (s[0] == 'e') {
        scanf("%d", &n);
        if (n <= 0 || n >= num || b[n] == 0) {
          printf("ILLEGAL_ERASE_ARGUMENT\n");
        } else {
          for (int i = 1; i <= m; i++) {
            if (a[i] == n) a[i] = 0;
          }
          b[n] = 0;
        }
      } else if (s[0] == 'd') {
        int c[1005];
        memset(c, 0, sizeof(c));
        int k = 1;
        for (int i = 1; i <= m; i++) {
          if (a[i] != 0) {
            c[k++] = a[i];
            a[i] = 0;
          }
        }
        for (int i = 1; i <= k; i++) {
          a[i] = c[i];
        }
      }
    }
  }
  return 0;
}
