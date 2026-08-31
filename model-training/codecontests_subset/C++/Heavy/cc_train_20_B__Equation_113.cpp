#include <bits/stdc++.h>
using namespace std;
template <typename T>
typename std::set<T>::const_iterator GetNearestTo(const std::set<T>& data,
                                                  const T& t) {
  auto upper = data.lower_bound(t);
  if (upper == data.begin() || (*upper) == t) return upper;
  auto lower = upper;
  --lower;
  if (data.end() == lower || (t - (*lower)) < ((*upper) - t)) return lower;
  if (upper == data.end() && data.size() > 0) return (--upper);
  return upper;
}
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        cout << "-1" << endl;
        return 0;
      } else {
        cout << "0" << endl;
        return 0;
      }
    } else {
      cout << "1" << endl;
      double x = (-c) / b;
      printf("%0.6f\n", x);
      return 0;
    }
  } else {
    double d = b * b - 4 * a * c;
    if (d < 0) {
      cout << "0" << endl;
      return 0;
    }
    d = sqrt(d);
    double p = (-b + d);
    double q = (-b - d);
    p = p / 2 / a;
    q = q / 2 / a;
    if (p == q) {
      cout << "1" << endl;
      printf("%0.6f\n", p);
      return 0;
    } else {
      cout << "2" << endl;
      if (p > q) {
        printf("%0.6f\n", q);
        printf("%0.6f\n", p);
        return 0;
      } else {
        printf("%0.6f\n", p);
        printf("%0.6f\n", q);
        return 0;
      }
    }
  }
  return 0;
}
