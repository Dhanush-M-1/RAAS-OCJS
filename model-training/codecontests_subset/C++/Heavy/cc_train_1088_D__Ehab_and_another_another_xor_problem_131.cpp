#include <bits/stdc++.h>
int a, b;
void parham(int guess_num, int ar[30], int br[30], int *pmax);
int power_2(int n);
int main() {
  int max = 0, i, ar[30], br[30];
  parham(1, ar, br, &max);
  for (i = 2; i <= 62; i += 2) parham(i, ar, br, &max);
  return 0;
}
int power_2(int n) {
  if (n == 0)
    return 1;
  else if (n >= 1)
    return 2 * power_2(n - 1);
}
void parham(int guess_num, int ar[30], int br[30], int *pmax) {
  int iman1, iman2;
  if (guess_num == 1) {
    printf("? 0 0\n");
    fflush(stdout);
    scanf("%d", &iman1);
    if (iman1 == 1)
      *pmax = 1;
    else if (iman1 == -1)
      *pmax = -1;
    else
      *pmax = 0;
  } else if (guess_num >= 2 && guess_num <= 61) {
    printf("? %d %d\n", a, power_2(30 - (guess_num / 2)) + b);
    fflush(stdout);
    scanf("%d", &iman1);
    printf("? %d %d\n", power_2(30 - (guess_num / 2)) + a, b);
    fflush(stdout);
    scanf("%d", &iman2);
    if (iman1 == 1 && iman2 == -1) {
      ar[30 - (guess_num / 2)] = 1;
      br[30 - (guess_num / 2)] = 1;
      a += power_2(30 - (guess_num / 2));
      b += power_2(30 - (guess_num / 2));
    } else if (iman1 == -1 && iman2 == 1) {
      ar[30 - (guess_num / 2)] = 0;
      br[30 - (guess_num / 2)] = 0;
    } else {
      if (*pmax == 1) {
        ar[30 - (guess_num / 2)] = 1;
        br[30 - (guess_num / 2)] = 0;
        *pmax = iman1;
        a += power_2(30 - (guess_num / 2));
      } else if (*pmax == -1) {
        ar[30 - (guess_num / 2)] = 0;
        br[30 - (guess_num / 2)] = 1;
        *pmax = iman1;
        b += power_2(30 - (guess_num / 2));
      }
    }
  } else if (guess_num == 62) {
    int i, ans_a = 0, ans_b = 0;
    for (i = 0; i <= 29; i++) {
      ans_a += power_2(i) * ar[i];
      ans_b += power_2(i) * br[i];
    }
    printf("! %d %d", ans_a, ans_b);
  }
}
