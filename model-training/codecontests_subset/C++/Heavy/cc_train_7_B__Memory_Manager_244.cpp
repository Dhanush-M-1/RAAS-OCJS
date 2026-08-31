#include <bits/stdc++.h>
int mem[100 + 5];
char s[15];
int t, m;
int check(int x, int c) {
  int i, j, f;
  for (i = 1; i <= m - x + 1; i++) {
    f = 0;
    for (j = i; j < i + x; j++)
      if (mem[j] != 0) f = 1;
    if (f == 0) {
      for (j = i; j < i + x; j++) mem[j] = c;
      return 1;
    }
  }
  return 0;
}
int main() {
  int i, j, c, x, f;
  while (~scanf("%d %d", &t, &m)) {
    c = 1;
    memset(mem, 0, sizeof(mem));
    while (t--) {
      scanf("%s", s);
      if (s[0] == 'a') {
        scanf("%d", &x);
        if (check(x, c) == 1)
          printf("%d\n", c++);
        else
          puts("NULL");
      } else if (s[0] == 'e') {
        scanf("%d", &x);
        if (x == 0)
          puts("ILLEGAL_ERASE_ARGUMENT");
        else {
          f = 0;
          for (i = 1; i <= m; i++)
            if (mem[i] == x) {
              mem[i] = 0;
              f = 1;
            }
          if (f == 0) puts("ILLEGAL_ERASE_ARGUMENT");
        }
      } else if (s[0] == 'd') {
        i = j = 1;
        while (j <= m) {
          mem[i] = mem[j];
          if (mem[i] != 0) {
            if (j > i) mem[j] = 0;
            i++;
          }
          j++;
        }
      }
    }
  }
  return 0;
}
