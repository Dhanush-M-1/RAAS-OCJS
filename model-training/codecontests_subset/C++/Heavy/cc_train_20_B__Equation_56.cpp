#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9 + 10;
const int N = 1010;
long double a, b, c;
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  cin >> a >> b >> c;
  long double d = (b * b - 4 * a * c);
  if (d < 0) {
    cout << 0;
    return 0;
  }
  if (a == b && b == c && a == 0) {
    cout << -1;
    return 0;
  }
  if (a == b && a == 0) {
    cout << 0;
    return 0;
  }
  if (a == 0) {
    cout << "1\n";
    cout << fixed << setprecision(10) << -c / (b) << "\n";
    return 0;
  }
  d = sqrt(d);
  long double x = (-b + d) / (2 * a);
  long double y = (-b - d) / (2 * a);
  if (x > y) swap(x, y);
  if (abs(x - y) < 1e-7) {
    cout << "1\n";
    cout << fixed << setprecision(10) << x << "\n";
  } else {
    cout << "2\n";
    cout << fixed << setprecision(10) << x << "\n";
    cout << fixed << setprecision(10) << y << "\n";
  }
  return 0;
}
