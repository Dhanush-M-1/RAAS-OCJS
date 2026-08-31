#include <bits/stdc++.h>
int main(int argc, const char* argv[]) {
  int n, x, y;
  scanf("%d%d%d", &n, &x, &y);
  int min = ((n * y - 1) / 100 + 1);
  if (min < x)
    x = 0;
  else
    x = min - x;
  printf("%d\n", x);
  return 0;
}
