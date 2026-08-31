#include <bits/stdc++.h>
using namespace std;
inline bool check(long long x1, long long y1, long long x2, long long y2) {
  {
    long long num = x1 * x2 + y1 * y2;
    long long den = x2 * x2 + y2 * y2;
    if (den == 0 && (x1 != 0 || y1 != 0)) return false;
    if (den != 0 && num % den != 0) return false;
  }
  {
    long long num = x1 * y2 - y1 * x2;
    long long den = x2 * x2 + y2 * y2;
    if (den == 0 && (x1 != 0 || y1 != 0)) return false;
    if (den != 0 && num % den != 0) return false;
  }
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout << setprecision(32);
  long long xa, xb, xc, ya, yb, yc;
  cin >> xa >> ya;
  cin >> xb >> yb;
  cin >> xc >> yc;
  if (check(xb - xa, yb - ya, xc, yc) || check(xb - ya, yb + xa, xc, yc) ||
      check(xb + xa, yb + ya, xc, yc) || check(xb + ya, yb - xa, xc, yc)) {
    cout << "YES\n";
  } else {
    cout << "NO\n";
  }
  return 0;
}
