#include <bits/stdc++.h>
int n, n_q, tmp[10], M[1001], run = 0, x = 0, start[101], fin[101], u = 1;
char s[15];
int main() {
  scanf("%d%d", &n_q, &n);
  for (int i = 0; i < n_q; i++) {
    scanf("%s", s);
    if (s[0] == 'a') {
      scanf("%d", &tmp[0]);
      for (int j = 0; j < n; j++) {
        if (M[j] > 0) continue;
        run = j;
        while (M[run] == 0 && run - j < tmp[0] && run < n) run++;
        if (run - j == tmp[0]) {
          ++x;
          start[x] = j;
          for (; j < run; j++) M[j] = x;
          fin[x] = run - 1;
          printf("%d\n", x);
          goto step2;
        }
        j = run;
      }
      printf("NULL\n");
    step2:;
    } else if (s[0] == 'e') {
      u = 0;
      scanf("%d", &tmp[0]);
      if (tmp[0] == 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
      for (int j = 0; j < n; j++) {
        if (M[j] == tmp[0]) {
          u = 1;
          M[j] = 0;
        }
      }
      if (u == 0) printf("ILLEGAL_ERASE_ARGUMENT\n");
    skip:;
    } else {
      run = 0;
      while (run < n && M[run] != 0) run++;
      for (int j = run + 1; j < n; j++) {
        if (M[j] != 0) {
          M[run] = M[j];
          M[j] = 0;
          run++;
        }
      }
    }
  }
  return 0;
}
