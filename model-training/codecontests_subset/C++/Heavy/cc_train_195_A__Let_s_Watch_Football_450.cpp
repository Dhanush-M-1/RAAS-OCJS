#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using db = double;
using ldb = long double;
const int SMALLINF = 1e9 + 7;
const ll BIGINF = ((ll)1e18) + 7;
void solve() {
  ll a, b, c;
  cin >> a >> b >> c;
  ll size = a * c;
  ll l = 0, r = 1e9, res = 0;
  while (l <= r) {
    ll mid = (l + r) / 2;
    ll wait = mid * b;
    ll thing = size - wait;
    if ((thing) % b != 0)
      thing = thing / b + 1;
    else
      thing /= b;
    if (thing <= c) {
      res = mid;
      r = mid - 1;
    } else
      l = mid + 1;
  }
  cout << res;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  solve();
}
