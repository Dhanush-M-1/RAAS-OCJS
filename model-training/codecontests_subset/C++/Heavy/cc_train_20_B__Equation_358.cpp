#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else {
      cout << 1 << endl;
      printf("%.9lf\n", -c / b);
    }
  } else {
    if (b * b - 4 * a * c < 0) {
      cout << 0 << endl;
      return 0;
    }
    double root1, root2;
    root1 = (-b + pow(b * b - 4 * a * c, 0.5)) / (2 * a);
    root2 = (-b - pow(b * b - 4 * a * c, 0.5)) / (2 * a);
    if (root1 == root2) {
      cout << 1 << endl;
      printf("%.9lf\n", root1);
    } else {
      cout << 2 << endl;
      if (root1 > root2) swap(root1, root2);
      printf("%.9lf\n", root1);
      printf("%.9lf\n", root2);
    }
  }
  return 0;
}
