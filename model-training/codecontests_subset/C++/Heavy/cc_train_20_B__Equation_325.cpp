#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long a, b, c;
  cin >> a >> b >> c;
  if (!a && !b && !c) {
    cout << -1;
    return 0;
  }
  if (!a && !b && c) {
    cout << 0;
    return 0;
  }
  if (!a) {
    cout << 1 << '\n';
    cout << setprecision(12) << ((double)(-c) / b);
    return 0;
  }
  if (b * b - 4 * a * c < 0) {
    cout << 0;
    return 0;
  }
  if (b * b == 4 * a * c) {
    cout << 1 << '\n';
    cout << setprecision(12) << (double)(-b) / (2 * a);
    return 0;
  }
  cout << 2 << '\n';
  double r1 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a),
         r2 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
  if (r1 > r2) swap(r1, r2);
  cout << setprecision(12) << r1 << '\n';
  cout << setprecision(12) << r2 << '\n';
  return 0;
}
