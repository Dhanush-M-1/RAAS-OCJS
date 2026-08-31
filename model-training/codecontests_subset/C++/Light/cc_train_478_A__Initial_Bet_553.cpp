#include <bits/stdc++.h>
int main() {
  int s = 0, ar[5], t = 0;
  for (int i = 0; i < 5; ++i) {
    scanf("%d", &ar[i]);
    s += ar[i];
  }
  if (s % 5 || s == 0)
    printf("-1\n");
  else {
    for (int i = 0; i < 5; ++i)
      if (ar[i] % 2) ++t;
    if ((((s / 5) % 2) && (t == 1 || t == 3 || t == 5)) ||
        (!((s / 5) % 2) && (t == 0 || t == 2 || t == 4)))
      printf("%d\n", s / 5);
    else
      printf("-1\n");
  }
  return 0;
}
