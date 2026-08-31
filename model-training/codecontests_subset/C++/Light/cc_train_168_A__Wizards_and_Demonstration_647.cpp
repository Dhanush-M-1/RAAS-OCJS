#include <bits/stdc++.h>
using namespace std;
int t, n, y, x, a, b;
int main() {
  scanf("%d%d%d", &n, &x, &y);
  double s = (double)(y * n) / 100;
  a = ceil(s);
  if (a - x > 0)
    printf("%d\n", a - x);
  else
    printf("0\n");
  return 0;
}
