#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  scanf("%d", &a);
  for (int rr = 1; rr <= a; rr++) {
    int r1, r2, dig, res;
    scanf("%d%d%d", &r1, &r2, &dig);
    if (r1 > dig)
      printf("%d\n", dig);
    else {
      res = ((r2 / dig) + 1) * dig;
      printf("%d\n", res);
    }
  }
  return 0;
}
