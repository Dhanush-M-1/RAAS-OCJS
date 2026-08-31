#include <bits/stdc++.h>
char s[(1 << 17)];
int ds = (1 << 17);
char ma[5200][5200];
inline char readch() {
  if (ds == (1 << 17)) {
    fread(s, (1 << 17), 1, stdin);
    ds = 0;
  }
  ds++;
  return s[ds - 1];
}
inline int cmmmc(int a, int b) {
  int r;
  while (b > 0) {
    r = a % b;
    a = b;
    b = r;
  }
  return a;
}
int main() {
  int n, rez = 0, cur, i, j, k;
  char ch;
  scanf("%d ", &n);
  for (i = 0; i < n; i++) {
    for (j = 0; j < (n >> 2); j++) {
      ch = readch();
      if (ch >= 'A' && ch <= 'F')
        ch = ch - 'A' + 10;
      else
        ch = ch - '0';
      for (k = 0; k < 4; k++) {
        ma[i][4 * j + 3 - k] = ((ch & (1 << k)) > 0);
      }
    }
    readch();
  }
  for (i = 0; i < n; i++) {
    cur = 1;
    for (j = 1; j < n; j++) {
      if (ma[i][j] == ma[i][j - 1])
        cur++;
      else {
        rez = cmmmc(rez, cur);
        cur = 1;
      }
    }
    rez = cmmmc(rez, cur);
  }
  for (i = 0; i < n; i++) {
    cur = 1;
    for (j = 1; j < n; j++) {
      if (ma[j][i] == ma[j - 1][i])
        cur++;
      else {
        rez = cmmmc(rez, cur);
        cur = 1;
      }
    }
    rez = cmmmc(rez, cur);
  }
  printf("%d\n", rez);
  return 0;
}
