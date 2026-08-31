#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, x = 4, m = 0, a1, a2, n = 2, ans;
  cin >> a >> b >> c;
  ans = b * b - x * a * c;
  if (a == m && b == m && c == m) {
    cout << -1;
    return 0;
  }
  if (a == m && b == m) {
    cout << 0;
    return 0;
  }
  if (a == m) {
    cout << 1 << endl;
    cout << fixed << setprecision(6) << (-c) / (b);
    return 0;
  }
  if (ans < 0) {
    cout << 0;
    return 0;
  }
  if (ans == m) {
    cout << 1 << endl;
    cout << fixed << setprecision(6) << (-b) / (n * a);
    return 0;
  }
  ans = sqrt(ans);
  a1 = (-b + ans) / (n * a);
  a2 = (-b - ans) / (n * a);
  cout << 2 << endl;
  if (a1 < a2) {
    cout << fixed << setprecision(6) << a1 << endl;
    cout << fixed << setprecision(6) << a2 << endl;
  } else {
    cout << fixed << setprecision(6) << a2 << endl;
    cout << fixed << setprecision(6) << a1 << endl;
  }
}
