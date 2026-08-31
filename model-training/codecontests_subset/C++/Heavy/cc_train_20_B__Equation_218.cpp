#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  set<double> s;
  double d = b * b - 4 * a * c;
  if (d < 0) {
    cout << "0" << endl;
  } else if (a == 0 && b == 0 && c == 0) {
    cout << "-1" << endl;
  } else {
    double a1, a2;
    if (a != 0) {
      a1 = (-b + sqrt(d)) / (2.0 * a);
      a2 = (-b - sqrt(d)) / (2.0 * a);
      s.insert(a1);
      s.insert(a2);
      cout << s.size() << endl;
      for (auto i = s.begin(); i != s.end(); i++) {
        printf("%.15lf\n", *i);
      }
    } else if (b != 0) {
      a1 = (a2 = -c / b);
      s.insert(a1);
      s.insert(a2);
      cout << s.size() << endl;
      for (auto i = s.begin(); i != s.end(); i++) {
        printf("%.15lf\n", *i);
      }
    } else {
      cout << "0" << endl;
    }
  }
  return 0;
}
