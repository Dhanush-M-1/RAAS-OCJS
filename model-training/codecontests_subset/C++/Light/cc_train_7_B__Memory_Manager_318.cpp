#include <bits/stdc++.h>
using namespace std;
inline int IN() {
  int x = 0, ch = getchar(), f = 1;
  while (!isdigit(ch) && (ch != '-') && (ch != EOF)) ch = getchar();
  if (ch == '-') {
    f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 1) + (x << 3) + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, m, now, idt[105];
char ope[15];
int main() {
  n = IN(), m = IN(), now = 1;
  for (int i = 1; i <= n; i++) {
    scanf("%s", ope);
    if (ope[0] == 'a') {
      int x = IN(), find = 0;
      for (int i = 1; i <= m - x + 1; i++) {
        if (idt[i]) continue;
        int j = i;
        while (j - i + 1 < x && !idt[j + 1]) j++;
        if (j - i + 1 == x) {
          for (int k = i; k <= j; k++) idt[k] = now;
          find = 1;
          break;
        }
        i = j;
      }
      if (find)
        printf("%d\n", now++);
      else
        puts("NULL");
    }
    if (ope[0] == 'e') {
      int x = IN(), find = 0;
      for (int i = 1; i <= m; i++) {
        if (idt[i] == x) idt[i] = 0, find = 1;
      }
      if (x <= 0 || x >= now || !find) puts("ILLEGAL_ERASE_ARGUMENT");
    }
    if (ope[0] == 'd') {
      for (int i = 1; i <= m; i++)
        if (!idt[i]) {
          int j = i + 1;
          while (j <= m && !idt[j]) j++;
          if (j > m)
            break;
          else
            idt[i] = idt[j], idt[j] = 0;
        }
    }
  }
}
