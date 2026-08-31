#include <bits/stdc++.h>
using namespace std;
double a, b, c;
set<double> s;
int main() {
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        puts("-1");
      else
        puts("0");
    } else {
      puts("1");
      double ans = -1.0 * c / b;
      printf("%0.5f", ans);
    }
  } else {
    if (b == 0) {
      double t = -1.0 * c / a;
      if (t < 0) {
        puts("0");
        return 0;
      }
      s.insert(sqrt(t));
      s.insert(-sqrt(t));
      cout << s.size() << endl;
      for (auto &v : s) printf("%0.5f\n", v);
    } else {
      double t = 1.0 * b * b / 4 / a / a - 1.0 * c / a;
      if (t < 0) {
        puts("0");
        return 0;
      }
      t = sqrt(t);
      double ans = t - 1.0 * b / 2 / a;
      s.insert(ans);
      ans = -t - 1.0 * b / 2 / a;
      s.insert(ans);
      cout << s.size() << endl;
      for (auto &v : s) printf("%0.5f\n", v);
    }
  }
}
