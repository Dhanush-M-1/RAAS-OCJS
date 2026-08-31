#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d %d", &r1, &r2);
  scanf("\n");
  scanf("%d %d", &c1, &c2);
  scanf("\n");
  scanf("%d %d", &d1, &d2);
  int used[10] = {0};
  for (int LT = 1; LT <= 9; LT++) {
    used[LT] = 1;
    int RT = r1 - LT;
    if (used[RT] || RT > 9 || RT < 1) {
      used[LT] = 0;
      continue;
    }
    used[RT] = 1;
    int LB = c1 - LT;
    int RB = c2 - RT;
    if (used[LB] || used[RB] || LB == RB || RB > 9 || RB < 1 || LB > 9 ||
        LB < 1) {
      used[LT] = 0;
      used[RT] = 0;
      continue;
    }
    used[LB] = 1;
    used[RB] = 1;
    if (LT + RB == d1 && LB + RT == d2 && LB + RB == r2 && LT + LB == c1 &&
        RT + RB == c2) {
      printf("%d %d\n", LT, RT);
      printf("%d %d", LB, RB);
      return 0;
    } else {
      used[LT] = 0;
      used[RT] = 0;
      used[LB] = 0;
      used[RB] = 0;
    }
  }
  printf("-1");
  return 0;
}
