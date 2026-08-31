#include <bits/stdc++.h>
using namespace std;
int a[102];
char s[102];
int main() {
  int i, j, n, m, x;
  while (~scanf("%d%d", &n, &m)) {
    int id = 1;
    memset(a, 0, sizeof(a));
    while (n--) {
      scanf("%s", s);
      if (s[0] == 'a') {
        scanf("%d", &x);
        for (i = 0; i <= m - x; i++) {
          for (j = 0; j < x; j++)
            if (a[i + j] != 0) break;
          if (j == x) break;
        }
        if (i <= m - x) {
          for (j = i; j < i + x; j++) a[j] = id;
          printf("%d\n", id++);
        } else
          printf("NULL\n");
      } else if (s[0] == 'e') {
        scanf("%d", &x);
        int flag = 1;
        for (i = 0; i < m; i++)
          if (a[i] && a[i] == x) a[i] = 0, flag = 0;
        if (flag) printf("ILLEGAL_ERASE_ARGUMENT\n");
      } else {
        for (i = 0, j = 0; i < m; i++) {
          if (a[i]) a[j++] = a[i];
        }
        while (j < m) a[j++] = 0;
      }
    }
  }
  return 0;
}
