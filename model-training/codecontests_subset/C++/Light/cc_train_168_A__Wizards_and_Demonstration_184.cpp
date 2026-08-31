#include <bits/stdc++.h>
int main() {
  int n, w, p;
  scanf("%d%d%d", &n, &w, &p);
  double d = double(n) * double(p) / 100.0;
  int m = (int)ceil(d);
  if (m <= w)
    puts("0");
  else
    printf("%d\n", m - w);
  return 0;
}
