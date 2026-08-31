#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
long long a, b, c, d, e, f, k;
bool check(long long x, long long y) {
  if (k == 0) {
    return x == c && y == d;
  }
  return ((c - x) * e + (d - y) * f) % k == 0 &&
         (e * (d - y) + f * (x - c)) % k == 0;
}
int main() {
  while (cin >> a >> b >> c >> d >> e >> f) {
    k = e * e + f * f;
    if (check(a, b) || check(-a, -b) || check(b, -a) || check(-b, a)) {
      cout << "YES" << endl;
    } else
      cout << "NO" << endl;
  }
  return 0;
}
