#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[100000];
  int i, j, x = 0, n, cp = 0, cm = 0, tmp, ap, am, pkp, flag = 0, p[10000],
            pp = 0, m[10000], mm = 0, mmm = 0, nnn = 0, a;
  scanf(" %[^\n]", s);
  n = strlen(s);
  for (i = 0; i < n; i++) {
    if (s[i] == '+')
      cp++;
    else if (s[i] == '-')
      cm++;
    if (s[i] >= 48 && s[i] <= 57) {
      tmp = s[i] - 48;
      x = x * 10 + tmp;
    }
  }
  cp++;
  a = min(cp, cm);
  if (cp > cm) {
    ap = x * (a + 1);
    am = x * a;
    for (i = 0; i < n; i++) {
      if ((s[i] == '?' && s[i - 2] == '+') || (i == 0)) {
        pkp = ap / cp;
        if (pkp <= 0 || pkp > x) {
          printf("Impossible\n");
          flag = 1;
          break;
        } else {
          p[pp] = pkp;
          pp++;
        }
        ap -= pkp;
        cp--;
      } else if (s[i] == '?' && s[i - 2] == '-') {
        pkp = am / cm;
        if (pkp <= 0 || pkp > x) {
          printf("Impossible\n");
          flag = 1;
          break;
        } else {
          m[mm] = pkp;
          mm++;
        }
        am -= pkp;
        cm--;
      }
    }
  } else if (cp <= cm) {
    ap = x * a;
    am = x * (a - 1);
    for (i = 0; i < n; i++) {
      if ((s[i] == '?' && s[i - 2] == '+') || (i == 0)) {
        pkp = ap / cp;
        if (pkp <= 0 || pkp > x) {
          printf("Impossible\n");
          flag = 1;
          break;
        } else {
          p[pp] = pkp;
          pp++;
        }
        ap -= pkp;
        cp--;
      } else if (s[i] == '?' && s[i - 2] == '-') {
        pkp = am / cm;
        if (pkp <= 0 || pkp > x) {
          printf("Impossible\n");
          flag = 1;
          break;
        } else {
          m[mm] = pkp;
          mm++;
        }
        am -= pkp;
        cm--;
      }
    }
  }
  if (flag != 1) {
    printf("Possible\n");
    for (i = 0; i < n; i++) {
      if ((s[i] == '?' && s[i - 2] == '+') || (i == 0)) {
        printf("%d", p[mmm]);
        mmm++;
      } else if (s[i] == '?' && s[i - 2] == '-') {
        printf("%d", m[nnn]);
        nnn++;
      } else
        printf("%c", s[i]);
    }
    printf("\n");
  }
  return 0;
}
