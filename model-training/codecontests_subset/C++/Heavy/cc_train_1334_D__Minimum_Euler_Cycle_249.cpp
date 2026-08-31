#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const ll inf = 1e18;
const ll mod = 1e9 + 7;
const ll MOD = 998244353;
const ll MAX = 2e5 + 1;
inline ll add(ll a, ll b) { return ((a % mod) + (b % mod)) % mod; }
inline ll sub(ll a, ll b) { return ((a % mod) - (b % mod) + mod) % mod; }
inline ll mul(ll a, ll b) { return ((a % mod) * (b % mod)) % mod; }
ll pwr(ll x, ll n) {
  if (!n) return 1;
  if (n & 1)
    return mul(x, pwr(mul(x, x), (n - 1) / 2));
  else
    return pwr(mul(x, x), n / 2);
}
ll modinv(ll n) { return pwr(n, mod - 2); }
void pattern(ll x, ll y, ll n) {
  ll tot = 0, idx = n;
  for (ll i = 1; i < n; i++) {
    if (tot + 2 * (n - i) >= x) {
      idx = i;
      break;
    }
    tot += 2 * (n - i);
  }
  ll l = idx, r = idx + 1;
  bool ok = false;
  while (tot < x) {
    if (r == n + 1) {
      r = (++l) + 1;
    }
    if (tot + 1 == x) {
      ok = true;
      l = idx;
      tot++;
      break;
    } else {
      tot += 2;
      if (tot == x) {
        break;
      }
      r++;
    }
  }
  while (tot <= y) {
    if (tot == (n * n - n + 1)) {
      cout << 1;
      return;
    }
    if (ok) {
      cout << l << " ";
    } else {
      cout << r << " ";
      r++;
      if (r == n + 1) {
        r = (++l) + 1;
      }
    }
    tot++;
    ok = !ok;
  }
}
void speed_solve() {
  ll n, l, r;
  cin >> n >> l >> r;
  if (l == r and l == (n * n - n + 1)) {
    cout << 1 << "\n";
    return;
  }
  ll x = l;
  ll y = r;
  pattern(l, r, n);
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ll test_cases = 1;
  cin >> test_cases;
  for (ll i = 0; i < test_cases; i++) {
    speed_solve();
  }
  return 0;
}
