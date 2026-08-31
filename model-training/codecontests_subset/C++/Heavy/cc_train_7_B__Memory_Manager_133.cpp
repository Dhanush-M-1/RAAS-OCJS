#include <bits/stdc++.h>
int num[101];
int vis[101];
char op[101];
int main() {
  int a, b;
  int i, ii, j;
  int step;
  int data, flag;
  while (scanf("%d%d", &a, &b) != EOF) {
    step = 0;
    memset(num, 0, sizeof(num));
    memset(vis, 0, sizeof(vis));
    for (ii = 0; ii < a; ii++) {
      scanf("%s", op);
      switch (op[0]) {
        case 'a':
          flag = 0;
          int fir;
          scanf("%d", &data);
          for (j = 0, i = 1; i <= b; i++) {
            if (num[i] == 0) {
              ++j;
              if (j == data) {
                flag = 1;
                fir = i;
                break;
              }
            } else {
              j = 0;
              flag = 0;
            }
          }
          if (flag) {
            ++step;
            vis[step] = 1;
            for (i = fir; i > fir - data; i--) num[i] = step;
            printf("%d\n", step);
          } else
            printf("NULL\n");
          ;
          break;
        case 'e':
          scanf("%d", &data);
          if (data <= 0 || !vis[data])
            printf("ILLEGAL_ERASE_ARGUMENT\n");
          else {
            for (i = 1; i <= b; i++)
              if (num[i] == data) {
                num[i] = 0;
              }
            vis[data] = 0;
          }
          break;
        case 'd':
          int s;
          for (s = 0, i = 1; i <= b; i++) {
            if (num[i]) num[++s] = num[i];
            if (i > s) num[i] = 0;
          }
          break;
      }
    }
  }
  return 0;
}
