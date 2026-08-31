#include <bits/stdc++.h>
using namespace std;
char s[1000000];
int n = 0, a = 1, d = 0, mem;
inline int check(int x, char op) {
  if (op == '+') {
    int m = n - x;
    if (a - d * mem > m || m > mem * a - d) return 0;
    return 1;
  }
  int m = n + x;
  if (a - d * mem > m || m > mem * a - d) return 0;
  return 1;
}
int main() {
  int i, j, l;
  char op;
  gets(s);
  l = strlen(s);
  for (i = 0; i < l; i++) {
    if (s[i] == '+')
      a++;
    else if (s[i] == '-')
      d++;
    else if (s[i] >= '0' && s[i] <= '9')
      n = n * 10 + s[i] - '0';
  }
  mem = n;
  if (a - d * n > n || n > n * a - d) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  op = '+';
  a--;
  for (i = 0; i < l; i++) {
    if (s[i] == '?') {
      int x;
      if (check(1, op))
        x = 1;
      else if (check(mem, op))
        x = mem;
      else {
        for (j = 1; j <= mem; j++)
          if (check(j, op)) {
            x = j;
            break;
          }
      }
      if (op == '+')
        n -= x;
      else
        n += x;
      printf("%d", x);
      continue;
    }
    printf("%c", s[i]);
    if (s[i] == '+') {
      op = '+';
      a--;
    } else if (s[i] == '-') {
      op = '-';
      d--;
    }
  }
  return 0;
}
