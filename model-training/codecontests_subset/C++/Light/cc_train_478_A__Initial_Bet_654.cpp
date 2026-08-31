#include <bits/stdc++.h>
int main() {
  int i, s = 0, k;
  for (i = 0; i < 5; i++) {
    scanf("%d", &k);
    s += k;
  }
  if (s % 5 != 0 || s == 0)
    printf("-1");
  else
    printf("%d", s / 5);
  return 0;
}
