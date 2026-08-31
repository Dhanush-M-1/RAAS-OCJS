#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0)
    cout << -1;
  else if (a == 0 && b == 0 && c != 0)
    cout << 0;
  else if (b * b - 4 * a * c < 0)
    cout << 0;
  else if (a == 0) {
    cout << 1 << endl;
    double x = -(c / b);
    printf("%.10f", x);
  } else {
    double x = ((-b) + sqrt(b * b - 4 * a * c)) / (2 * a);
    double y = ((-b) - sqrt(b * b - 4 * a * c)) / (2 * a);
    if (x == y) {
      cout << 1 << endl;
      printf("%.10f", x);
    } else {
      cout << 2 << endl;
      if (x > y) swap(x, y);
      printf("%.10f", x);
      cout << endl;
      printf("%.10f", y);
    }
  }
}
