#include <bits/stdc++.h>
using namespace std;
class Quadratic_root {
  long long a, b, c;

 public:
  Quadratic_root(long a, long b, long c) : a(a), b(b), c(c) {}
  void Calculate_roots() {
    if ((b * b - 4 * a * c) < 0)
      cout << 0 << endl;
    else if (!a && !b && !c)
      cout << -1 << endl;
    else if (!a && !b) {
      cout << 0 << endl;
    } else if (!a) {
      cout << 1 << endl;
      cout << fixed << setprecision(10) << (-1 * c) / float(b);
    } else {
      double ans1 = (-b + sqrt(b * b - 4 * a * c)) / float(2 * a);
      double ans2 = (-b - sqrt(b * b - 4 * a * c)) / float(2 * a);
      if (ans1 == ans2) {
        cout << 1 << endl;
        cout << fixed << setprecision(10) << ans1 << endl;
      } else {
        if (ans2 < ans1) {
          double temp = ans1;
          ans1 = ans2;
          ans2 = temp;
        }
        cout << 2 << endl;
        cout << fixed << setprecision(10) << ans1 << endl;
        cout << fixed << setprecision(10) << ans2 << endl;
      }
    }
  }
};
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  Quadratic_root Q(a, b, c);
  Q.Calculate_roots();
  return 0;
}
