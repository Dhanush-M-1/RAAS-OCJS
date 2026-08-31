#include <bits/stdc++.h>
const int N = 200010;
const int inf = 0x3f3f3f3f;
using namespace std;
string str;
long long a, b, c;
int main() {
  cin >> a >> b >> c;
  if (a == 0) {
    if (c == 0) {
      if (b == 0) return puts("-1"), 0;
      printf("1\n0.000000000000\n");
      return 0;
    } else {
      if (b == 0) return puts("0"), 0;
      printf("1\n%.12f\n", -1.0 * c / b);
      return 0;
    }
  } else {
    long long x = b * b - 4 * a * c;
    if (x < 0) return puts("0"), 0;
    if (x == 0) return printf("1\n%.12f\n", -1.0 * b / (2 * a)), 0;
    double x1 = (-1.0 * b - sqrt(x + 0.0)) / (2 * a),
           x2 = (-1.0 * b + sqrt(x + 0.0)) / (2 * a);
    if (x1 > x2) swap(x1, x2);
    printf("2\n%.12f\n%.12f\n", x1, x2);
    return 0;
  }
  return 0;
}
