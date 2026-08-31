#include <bits/stdc++.h>
int main(void) {
  char s[101];
  if (scanf("%s", s) != 1) {
    return -1;
  }
  int u = 0, d = 0, t = 0;
  for (size_t k = 0; k < strlen(s); k += 2) {
    switch (s[k]) {
      case '1':
        u++;
        break;
      case '2':
        d++;
        break;
      case '3':
        t++;
        break;
      default:
        break;
    }
  }
  int tt = u + d + t;
  while (tt > 0) {
    if (u > 0) {
      printf("1");
      u--;
    } else if (d > 0) {
      printf("2");
      d--;
    } else if (t > 0) {
      printf("3");
      t--;
    }
    if (tt > 1) {
      printf("+");
    }
    tt--;
  }
  return 0;
}
