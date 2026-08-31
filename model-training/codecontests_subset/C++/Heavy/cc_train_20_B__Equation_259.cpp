#include <bits/stdc++.h>
using namespace std;
const int dx[9] = {0, 1, -1, 0, 0, -1, -1, 1, 1};
const int dy[9] = {0, 0, 0, -1, 1, -1, 1, -1, 1};
const double pi = acos(-1.0);
const int N = 1e6 + 100;
const int MOD = 1e9 + 7;
long long a, b, c;
double temp;
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    cout << 0 << endl;
    return 0;
  }
  if (a == 0 && b != 0) {
    cout << 1 << endl;
    double ans = (-1.0) * c / b;
    cout << fixed << setprecision(10) << ans << endl;
    return 0;
  }
  temp = b * b - 4 * a * c;
  if (temp < 0) {
    cout << 0 << endl;
  } else if (temp == 0) {
    cout << 1 << endl;
    double ans = -1.0 * b / (2 * a);
    cout << fixed << setprecision(10) << ans << endl;
  } else if (temp > 0) {
    cout << 2 << endl;
    temp = sqrt(temp);
    double ans1 = (-1.0 * b - temp) / (1.0 * 2 * a),
           ans2 = (-1.0 * b + temp) / (1.0 * 2 * a);
    if (ans1 > ans2) swap(ans1, ans2);
    cout << fixed << setprecision(10) << ans1 << endl << ans2 << endl;
  }
  return 0;
}
