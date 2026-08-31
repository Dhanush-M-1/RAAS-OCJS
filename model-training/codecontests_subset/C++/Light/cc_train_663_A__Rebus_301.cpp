#include <bits/stdc++.h>
using namespace std;
char s[10];
int a[110], tot;
int goal, mi, pov;
int main() {
  do {
    scanf("%s", s);
    scanf("%s", s);
    tot++;
    if (s[0] == '-') {
      mi++;
      a[tot] = -1;
    } else if (s[0] == '+') {
      a[tot] = 1;
    }
  } while (s[0] != '=');
  int mic = 1;
  scanf("%d", &goal);
  pov = tot - mi;
  int asum = max(pov, mi + goal);
  int bsum = asum - goal;
  int a1 = asum / pov, a2 = a1 + (asum % pov != 0);
  int anum = 0, bnum = 0;
  anum = asum % pov;
  if (mi > 0) bnum = bsum % mi;
  int b1 = 1, b2 = 1;
  if (mi > 0) b1 = bsum / mi, b2 = b1 + (bsum % mi != 0);
  if (a1 <= 0 || b1 <= 0 || a2 > goal || b2 > goal || (mi == 0 && pov > goal)) {
    puts("Impossible");
  } else {
    puts("Possible");
    if (anum) {
      anum--;
      printf("%d ", a2);
    } else {
      printf("%d ", a1);
    }
    for (int i = 1; i < tot; ++i) {
      if (a[i] == 1) {
        if (anum) {
          anum--;
          printf("+ %d ", a2);
        } else {
          printf("+ %d ", a1);
        }
      } else {
        if (bnum) {
          bnum--;
          printf("- %d ", b2);
        } else {
          printf("- %d ", b1);
        }
      }
    }
    printf("= %d\n", goal);
  }
}
