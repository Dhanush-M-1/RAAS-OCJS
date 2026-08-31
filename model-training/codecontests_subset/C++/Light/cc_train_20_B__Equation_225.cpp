#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d;
int main() {
  scanf("%lld%lld%lld", &a, &b, &c);
  if (a) {
    if (a < 0) a = -a, b = -b, c = -c;
    d = b * b - 4 * a * c;
    if (d > 0)
      printf("2\n%.10lf\n%.10lf\n", (-b - sqrt((double)d)) / (2 * a),
             (-b + sqrt((double)d)) / (2 * a));
    else if (d < 0)
      printf("0\n");
    else
      printf("1\n%.10lf\n", (double)-b / (2 * a));
  } else if (b)
    printf("1\n%.10lf\n", (double)-c / b);
  else if (c)
    printf("0\n");
  else
    printf("-1\n");
  return 0;
}
