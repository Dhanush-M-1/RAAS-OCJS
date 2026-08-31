#include <bits/stdc++.h>
using namespace std;
int main() {
  set<double> s;
  set<double>::iterator it;
  double a, b, c;
  cin >> a >> b >> c;
  double ans1, ans2;
  if (a == 0 && b == 0 && c == 0)
    cout << -1 << endl;
  else if (a == 0 && b != 0) {
    ans2 = -(c / b);
    s.insert(ans2);
    cout << s.size() << endl;
    it == s.begin();
    for (it = s.begin(); it != s.end(); it++)
      cout << setprecision(5) << fixed << *it << endl;
  } else if (a != 0 && b == 0 && c == 0) {
    ans1 = 0;
    cout << 1 << endl << setprecision(5) << fixed << ans1 << endl;
  } else if ((-b) + sqrt(b * b - 4 * a * c) == 0 &&
             (-b) - sqrt(b * b - 4 * a * c) == 0)
    cout << 0 << endl;
  else if ((b * b - 4 * a * c) < 0)
    cout << 0 << endl;
  else {
    ans1 = ((-b) + sqrt(b * b - 4 * a * c)) / (2 * a);
    ans2 = ((-b) - sqrt((b * b - 4 * a * c))) / (2 * a);
    s.insert(ans1);
    s.insert(ans2);
    cout << s.size() << endl;
    for (it = s.begin(); it != s.end(); it++)
      cout << setprecision(5) << fixed << *it << endl;
  }
  return 0;
}
