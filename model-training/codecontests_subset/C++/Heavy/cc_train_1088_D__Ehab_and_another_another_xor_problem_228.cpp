#include <bits/stdc++.h>
using namespace std;
int main() {
  int ans1 = 0, ans2 = 0;
  int ansa = 0, ansb = 0;
  printf("? 0 0\n");
  fflush(stdout);
  int d;
  scanf("%d", &d);
  for (int i = (1 << 29); i != 0; i /= 2) {
    printf("? %d %d\n", ans1 + i, ans2 + i);
    fflush(stdout);
    int p;
    scanf("%d", &p);
    if (p == d) {
      printf("? %d %d\n", ans1 + i, ans2);
      fflush(stdout);
      int pp;
      scanf("%d", &pp);
      if (pp == -1) {
        ansa += i;
        ansb += i;
      }
    } else {
      if (p == -1 && d == 1) {
        ans1 += i;
        ansa += i;
      }
      if (p == 1 && d == -1) {
        ans2 += i;
        ansb += i;
      }
      printf("? %d %d\n", ans1, ans2);
      fflush(stdout);
      scanf("%d", &d);
    }
  }
  printf("! %d %d\n", ansa, ansb);
}
