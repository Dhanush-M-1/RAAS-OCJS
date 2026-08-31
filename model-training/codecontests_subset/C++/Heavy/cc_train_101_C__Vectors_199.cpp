#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long double eps = 1e-9;
const long long maxn = 1e5 + 1;
const long long inf = 5e18;
const long long minf = -inf;
bool calc(long long a, long long b, long long e, long long c, long long d,
          long long f) {
  long long determinant = a * d - b * c;
  if (determinant != 0) {
    bool x = (e * d - b * f) % determinant;
    bool y = (a * f - e * c) % determinant;
    return !x && !y;
  } else {
    if (a == 0 && b == 0 && e == 0 && f == 0) return true;
  }
  return false;
}
bool solve() {
  vector<pair<long long, long long>> v(4);
  for (long long i = 1; i < 4; ++i) cin >> v[i].first >> v[i].second;
  if (calc(v[3].first, -v[3].second, v[2].first - v[1].first, v[3].second,
           v[3].first, v[2].second - v[1].second)) {
    ;
    return true;
  } else if (calc(v[3].first, -v[3].second, v[2].first + v[1].first,
                  v[3].second, v[3].first, v[2].second + v[1].second)) {
    ;
    return true;
  } else if (calc(v[3].first, -v[3].second, v[2].first + v[1].second,
                  v[3].second, v[3].first, v[2].second - v[1].first)) {
    ;
    return true;
  } else if (calc(v[3].first, -v[3].second, v[2].first - v[1].second,
                  v[3].second, v[3].first, v[2].second + v[1].first)) {
    ;
    return true;
  } else
    return false;
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  while (t--) {
    if (solve()) {
      cout << "YES"
           << "\n";
    } else {
      cout << "NO"
           << "\n";
    }
  }
  return 0;
}
