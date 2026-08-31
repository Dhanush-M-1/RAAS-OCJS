#include <bits/stdc++.h>
using namespace std;
int main() {
  int flag, x;
  printf("? 0 0\n");
  fflush(stdout);
  scanf("%d", &flag);
  int tempa = 0, tempb = 0;
  for (int i = 1 << 29; i; i >>= 1) {
    if (flag == 0) {
      printf("? %d %d\n", tempa | i, tempb);
      fflush(stdout);
      scanf("%d", &x);
      if (x == -1) tempa |= i, tempb |= i;
    } else if (flag == -1) {
      printf("? %d %d\n", tempa | i, tempb | i);
      fflush(stdout);
      scanf("%d", &x);
      if (x == 1) {
        tempb |= i;
        printf("? %d %d\n", tempa, tempb);
        fflush(stdout);
        scanf("%d", &flag);
      } else {
        printf("? %d %d\n", tempa | i, tempb);
        fflush(stdout);
        scanf("%d", &x);
        if (x == -1) tempa |= i, tempb |= i;
      }
    } else {
      printf("? %d %d\n", tempa | i, tempb | i);
      fflush(stdout);
      scanf("%d", &x);
      if (x == -1) {
        tempa |= i;
        printf("? %d %d\n", tempa, tempb);
        fflush(stdout);
        scanf("%d", &flag);
      } else {
        printf("? %d %d\n", tempa, tempb | i);
        fflush(stdout);
        scanf("%d", &x);
        if (x == 1) tempa |= i, tempb |= i;
      }
    }
  }
  printf("! %d %d\n", tempa, tempb);
  fflush(stdout);
  return 0;
}
