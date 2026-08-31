#include <bits/stdc++.h>
using namespace std;
int main() {
  double t, x, y, n;
  scanf("%lf %lf %lf", &n, &x, &y);
  t = (n * y) / 100;
  t = ceil(t) - x;
  if (t < 0) t = 0;
  printf("%.lf\n", t);
  getchar();
  getchar();
  return 0;
}
