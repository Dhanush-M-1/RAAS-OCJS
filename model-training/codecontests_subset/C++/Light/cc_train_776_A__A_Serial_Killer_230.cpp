#include <bits/stdc++.h>
using namespace std;
long double safe_sqrt(long double x) { return sqrt(max((long double)0.0, x)); }
long long GI(long long& x) { return scanf("%lld", &x); }
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout << (fixed) << setprecision(9);
  string a, b;
  while (cin >> a >> b) {
    long long n;
    cin >> n;
    cout << a << ' ' << b << '\n';
    for (long long i = (1), _b = (n); i <= _b; ++i) {
      string x, y;
      cin >> x >> y;
      if (a == x)
        a = y;
      else
        b = y;
      cout << a << ' ' << b << '\n';
    }
  }
}
