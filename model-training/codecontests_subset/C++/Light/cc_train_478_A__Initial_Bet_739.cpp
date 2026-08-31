#include <bits/stdc++.h>
int main() {
  int c1, c2, c3, c4, c5, s = 0;
  scanf("%d%d%d%d%d", &c1, &c2, &c3, &c4, &c5);
  s = c1 + c2 + c3 + c4 + c5;
  if (s % 5 == 0 && s > 0)
    printf("%d", s / 5);
  else
    printf("%d", -1);
}
