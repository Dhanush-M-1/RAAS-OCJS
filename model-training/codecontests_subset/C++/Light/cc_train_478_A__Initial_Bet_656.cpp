#include <bits/stdc++.h>
int main() {
  int c, t = 5, s = 0;
  while (t--) {
    scanf("%d", &c);
    s += c;
  }
  if (s % 5 == 0 && s != 0)
    printf("%d", s / 5);
  else
    printf("-1");
  return 0;
}
