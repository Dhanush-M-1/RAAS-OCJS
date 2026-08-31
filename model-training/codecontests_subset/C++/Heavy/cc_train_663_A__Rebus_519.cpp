#include <bits/stdc++.h>
using namespace std;
int main() {
  char str[2333];
  gets(str);
  int len = strlen(str);
  int i = len - 1;
  int n = 0;
  int x = 1;
  while (str[i] == '\n' || str[i] == ' ' || str[i] == '\r') --i;
  while (str[i] != '=' && str[i] != ' ') {
    n += (str[i] - '0') * x;
    x *= 10;
    --i;
  }
  int a, b;
  a = 0;
  b = 0;
  for (i = 0; str[i] != '='; ++i) {
    if (str[i] == '+')
      a++;
    else if (str[i] == '-')
      b++;
  }
  if ((b > a * n) || (a > b * n + n - 1)) {
    puts("Impossible");
  } else {
    puts("Possible");
    bool f = 0;
    int rest;
    if (a >= b * n)
      rest = a - b * n;
    else if (a >= b)
      rest = a - b;
    else
      rest = b - a;
    for (int i = 0; str[i]; ++i) {
      if (str[i] != '?') {
        putchar(str[i]);
        if (str[i] == '+')
          f = 0;
        else if (str[i] == '-')
          f = 1;
      } else {
        if (i == 0) {
          if (a >= b * n)
            printf("%d", n - (a - b * n));
          else
            printf("%d", n);
        } else {
          if (a >= b * n) {
            if (!f) {
              printf("1");
            } else
              printf("%d", n);
          } else {
            if (a >= b) {
              if (!f)
                printf("1");
              else if (rest) {
                printf("%d", min(rest, n - 1) + 1);
                rest -= min(rest, n - 1);
              } else
                printf("1");
            } else {
              if (f)
                printf("1");
              else if (rest) {
                printf("%d", min(rest, n - 1) + 1);
                rest -= min(rest, n - 1);
              } else
                printf("1");
            }
          }
        }
      }
    }
  }
  return 0;
}
