#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
template <typename T>
using lim = numeric_limits<T>;
template <typename T>
istream& operator>>(istream& is, vector<T>& a) {
  for (T& x : a) {
    is >> x;
  }
  return is;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  ll a, b, c;
  cin >> a >> b >> c;
  cout.setf(ios::fixed);
  cout.precision(5);
  if (a == 0) {
    if (b == 0) {
      cout << (c == 0 ? -1 : 0) << endl;
    } else {
      cout << 1 << endl;
      cout << (double)-c / b << endl;
    }
  } else {
    ll d = b * b - 4 * a * c;
    if (d > 0) {
      cout << 2 << endl;
      double r1 = (-b - sqrtl(d)) / (2 * a), r2 = (-b + sqrtl(d)) / (2 * a);
      cout << min(r1, r2) << endl;
      cout << max(r1, r2) << endl;
    } else if (d == 0) {
      cout << 1 << endl;
      cout << (double)-b / (2 * a) << endl;
    } else {
      cout << 0 << endl;
    }
  }
  return 0;
}
