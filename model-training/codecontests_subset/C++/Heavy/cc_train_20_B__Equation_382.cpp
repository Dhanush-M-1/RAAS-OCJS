#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
const int INF32 = INT_MAX;
const ll INF64 = ((ll)INF32 << 29ll);
void reflex() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr), cout.tie(nullptr);
}
signed main() {
  reflex();
  using ld = long double;
  ld a, b, c;
  cin >> a >> b >> c;
  cout << setprecision(10) << fixed;
  if (!a && !b && !c) cout << -1, exit(false);
  if (!a) {
    if (!b)
      cout << 0;
    else
      cout << "1\n" << (ld)(-c / b);
    return false;
  }
  ld d = (b * 1ll * b) - (4 * 1ll * a * c);
  if (d < 0) cout << 0, exit(false);
  d = (ld)sqrt(d);
  ld x = (-b + d) / (a * 2ll);
  ld y = (-b - d) / (a * 2ll);
  if (d > 0) {
    if (x > y) swap(x, y);
    cout << "2\n" << x << "\n" << y;
  } else
    cout << "1\n" << x;
  return false;
}
