#include <bits/stdc++.h>
int main() {
  int symbols = 0, one = 0, two = 0, three = 0, i;
  char s[101], *p;
  gets(s);
  p = s;
  while (*p != '\0') {
    if (*p == '1')
      one++;
    else if (*p == '2')
      two++;
    else if (*p == '3')
      three++;
    else if (*p == '+')
      symbols++;
    *p++;
  }
  for (i = 0; i < one; i++) {
    printf("1");
    if (symbols) {
      printf("+");
      symbols--;
    }
  }
  for (i = 0; i < two; i++) {
    printf("2");
    if (symbols) {
      printf("+");
      symbols--;
    }
  }
  for (i = 0; i < three; i++) {
    printf("3");
    if (symbols) {
      printf("+");
      symbols--;
    }
  }
  return 0;
}
