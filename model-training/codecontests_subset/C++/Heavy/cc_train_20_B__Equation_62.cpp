#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    printf("-1\n");
  } else if (a == 0 && b == 0 && c != 0) {
    printf("0\n");
  } else if (a == 0 && b != 0) {
    printf("1\n");
    double val = (-1 * c) / (b * 1.0);
    printf("%0.8f", val);
  } else {
    long long d = b * b - 4 * a * c;
    if (d < 0) {
      printf("0\n");
    } else {
      double x1 = (-1 * b + sqrt(d)) / (2 * a * 1.0);
      double x2 = (-1 * b - sqrt(d)) / (2 * a * 1.0);
      if (d == 0) {
        printf("1\n");
        printf("%0.8f\n", min(x1, x2));
      } else {
        printf("2\n");
        printf("%0.8f\n", min(x1, x2));
        printf("%0.8f", max(x1, x2));
      }
    }
  }
}
