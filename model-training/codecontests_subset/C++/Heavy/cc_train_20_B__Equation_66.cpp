#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        printf("-1\n");
      else
        printf("0\n");
    } else {
      printf("1\n");
      printf("%.5lf\n", -1.0 * c / b);
    }
  } else {
    long long sum = b * b - 4 * a * c;
    if (sum < 0)
      printf("0\n");
    else if (sum == 0) {
      printf("1\n");
      printf("%.5lf\n", -1.0 * b / (2 * a));
    } else {
      printf("2\n");
      double ans[2];
      ans[0] = -b + sqrt(sum);
      ans[0] /= (2 * a);
      ans[1] = -b - sqrt(sum);
      ans[1] /= (2 * a);
      if (ans[0] > ans[1]) swap(ans[0], ans[1]);
      printf("%.5lf\n%.5lf\n", ans[0], ans[1]);
    }
  }
  return 0;
}
