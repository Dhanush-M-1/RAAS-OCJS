#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[]) {
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0) {
    if (c == 0) {
      cout << -1 << endl;
    } else {
      cout << 0 << endl;
    }
    return 0;
  }
  if (a == 0) {
    cout << 1 << endl;
    printf("%.6f\n", 0 - c / b);
    return 0;
  }
  double d = b * b - 4 * a * c;
  if (d < 0) {
    cout << 0 << endl;
  } else if (d == 0) {
    cout << 1 << endl;
    printf("%.6f\n", 0 - b / (2 * a));
  } else {
    cout << 2 << endl;
    double res[2];
    res[0] = (0 - b - sqrt(d)) / (2 * a);
    res[1] = (0 - b + sqrt(d)) / (2 * a);
    sort(res, res + 2);
    printf("%.6f\n", res[0]);
    printf("%.6f\n", res[1]);
  }
  return 0;
}
