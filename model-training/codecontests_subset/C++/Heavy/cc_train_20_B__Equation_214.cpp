#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == 0 && b != 0) {
    cout << 1 << endl;
    long double ans = (long double)(-c / b);
    cout << fixed << setprecision(10) << ans << endl;
    return 0;
  }
  if (a == 0 && b == 0 && c == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    cout << 0 << endl;
    return 0;
  }
  if (b * b - 4 * a * c == 0) {
    cout << 1 << endl;
    long long int ans = (long double)((-b / (2 * a)));
    cout << fixed << setprecision(10) << ans << endl;
    return 0;
  } else if (b * b - 4 * a * c < 0) {
    cout << 0 << endl;
    return 0;
  } else {
    long double x, y;
    x = (long double)((-b + (long double)sqrt(b * b - 4 * a * c)) / (2 * a));
    y = (long double)((-b - (long double)sqrt(b * b - 4 * a * c)) / (2 * a));
    cout << 2 << endl;
    if (x > y) {
      swap(x, y);
    }
    cout << fixed << setprecision(10) << x << endl;
    cout << fixed << setprecision(10) << y << endl;
  }
  return 0;
}
