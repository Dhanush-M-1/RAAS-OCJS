#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e, s;
  scanf("%d%d%d%d%d", &a, &b, &c, &d, &e);
  s = a + b + c + d + e;
  if (s / 5 == 0)
    printf("-1\n");
  else {
    if (s % 5 == 0)
      printf("%d\n", s / 5);
    else
      printf("-1\n");
  }
  return 0;
}
