#include <bits/stdc++.h>
int main() {
  int mem[1001] = {0}, temp[1001] = {0}, t, m, i, j, k, a = 0, si, n, tr;
  char s[30];
  scanf("%d%d", &t, &m);
  while (t--) {
    scanf(" %[^\n]", s);
    n = 0;
    if (s[0] == 'a' || s[0] == 'e') {
      i = 0;
      while (s[i] != ' ') i++;
      i++;
      while (s[i]) {
        n = n * 10 + s[i] - '0';
        i++;
      }
    }
    if (s[0] == 'a') {
      a++;
      tr = 0;
      for (i = 1; i <= m; i++) {
        k = i;
        while (mem[i] == 0 && i <= m) {
          i++;
        }
        if (i - k >= n) {
          for (j = k; j <= k + n - 1; j++) {
            mem[j] = a;
          }
          tr = 1;
          break;
        }
      }
      if (tr) {
        printf("%d\n", a);
      } else {
        a--;
        printf("NULL\n");
      }
    } else if (s[0] == 'e') {
      tr = 0;
      for (i = 1; i <= m; i++) {
        if (mem[i] == n) {
          mem[i] = 0;
          tr = 1;
        }
      }
      if (!tr || n == 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      }
    } else {
      k = 1;
      for (i = 1; i <= m; i++) {
        if (mem[i]) {
          temp[k++] = mem[i];
        }
      }
      for (; k <= m; k++) temp[k] = 0;
      for (i = 1; i <= m; i++) {
        mem[i] = temp[i];
      }
    }
  }
  return 0;
}
