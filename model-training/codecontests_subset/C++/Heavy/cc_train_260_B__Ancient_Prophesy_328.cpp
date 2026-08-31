#include <bits/stdc++.h>
struct date {
  int d;
  int m;
  int y;
};
int* maxdm(void) {
  int i = 0;
  int* mdm = (int*)malloc(13 * sizeof(int));
  for (i = 1; i < 13; i++) {
    mdm[i] = 30;
    if (i < 8) {
      if (i % 2 == 0) {
        if (i == 2) {
          mdm[i] = 28;
        } else {
          mdm[i] = 30;
        }
      } else {
        mdm[i] = 31;
      }
    } else {
      if (i % 2 == 0) {
        mdm[i] = 31;
      } else {
        mdm[i] = 30;
      }
    }
  }
  return mdm;
}
int isdigit(char c) {
  if (c < 58 && c > 47) {
    return 1;
  } else {
    return 0;
  }
}
int dateiscorrect(int d, int m, int y, int* mdm) {
  if (m < 0 || m > 12 || y > 2015 || y < 2013 || d < 1) {
    return 0;
  } else {
    if (mdm[m] >= d) {
      return 1;
    } else {
      return 0;
    }
  }
}
int main(void) {
  int* mdm = maxdm();
  char* s = (char*)malloc(100000);
  scanf("%s", s);
  int d, m, y;
  int i = 0;
  int nb = 0;
  int tab[12 * 31 * 3];
  for (i = 0; i < 12 * 31 * 3; i++) {
    tab[i] = 0;
  }
  i = 0;
  while (s[i + 9] != '\0') {
    if (isdigit(s[i + 0]) && isdigit(s[i + 1]) && isdigit(s[i + 3]) &&
        isdigit(s[i + 4]) && isdigit(s[i + 6]) && isdigit(s[i + 7]) &&
        isdigit(s[i + 8]) && isdigit(s[i + 9]) && s[i + 2] == '-' &&
        s[i + 5] == '-') {
      int d = (s[i + 0] - 48) * 10 + (s[i + 1] - 48);
      int m = (s[i + 3] - 48) * 10 + (s[i + 4] - 48);
      int y = (s[i + 6] - 48) * 1000 + (s[i + 7] - 48) * 100 +
              (s[i + 8] - 48) * 10 + (s[i + 9] - 48);
      if (dateiscorrect(d, m, y, mdm)) {
        tab[d - 1 + (m - 1) * 31 + (y - 2013) * 372]++;
        nb++;
      }
    }
    i++;
  }
  int pmax = 0;
  int max = 0;
  int tmp = 0;
  for (i = 0; i < 12 * 31 * 3; i++) {
    if (tab[i] > max) {
      max = tab[i];
      pmax = i;
    }
  }
  y = 2013 + pmax / 372;
  m = (pmax % 372) / 31 + 1;
  d = ((pmax % 372) % 31) + 1;
  if (d < 10) {
    printf("0");
  }
  printf("%d-", d);
  if (m < 10) {
    printf("0");
  }
  printf("%d-", m);
  printf("%d", y);
  return 0;
}
