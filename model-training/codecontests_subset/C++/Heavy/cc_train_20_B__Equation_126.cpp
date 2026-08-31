#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const long long INFLL = 0x3f3f3f3f3f3f3f3f;
const int MOD = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0 and c == 0) {
      cout << -1 << endl;
      return 0;
    } else if (b == 0 and c != 0) {
      cout << 0 << endl;
      return 0;
    }
    cout << 1 << endl << fixed << setprecision(5) << (double)(-c) / b << endl;
    return 0;
  }
  long long delta = b * b - 4 * a * c;
  if (delta == 0) {
    cout << 1 << endl << fixed << setprecision(5) << -b / (2.0 * a);
    return 0;
  }
  if (delta < 0) {
    cout << 0 << endl;
    return 0;
  }
  double m = (-b - sqrt(delta)) / (2.0 * a),
         mm = (-b + sqrt(delta)) / (2.0 * a);
  cout << 2 << endl
       << fixed << setprecision(5) << min(m, mm) << endl
       << max(m, mm) << endl;
  return 0;
}
