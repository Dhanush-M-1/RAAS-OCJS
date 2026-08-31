#include <bits/stdc++.h>
using namespace std;
int main() {
  int tmp, n, a = 0, b = 0;
  printf("? 0 0\n");
  fflush(stdout);
  scanf("%d", &n);
  for (int i = 29; i >= 0; --i) {
    if (n == 0) {
      printf("? %d %d\n", (a | (1 << i)), b);
      fflush(stdout);
      scanf("%d", &tmp);
      if (tmp == -1) a |= (1 << i), b |= (1 << i);
    } else {
      printf("? %d %d\n", (a | (1 << i)), (b | (1 << i)));
      fflush(stdout);
      scanf("%d", &tmp);
      if (tmp == n) {
        printf("? %d %d\n", (a | (1 << i)), b);
        fflush(stdout);
        scanf("%d", &tmp);
        if (tmp == -1) a |= (1 << i), b |= (1 << i);
      } else {
        if (n == 1)
          a |= (1 << i);
        else
          b |= (1 << i);
        printf("? %d %d\n", a, b);
        fflush(stdout);
        scanf("%d", &n);
      }
    }
  }
  printf("! %d %d\n", a, b);
  fflush(stdout);
  return 0;
}
