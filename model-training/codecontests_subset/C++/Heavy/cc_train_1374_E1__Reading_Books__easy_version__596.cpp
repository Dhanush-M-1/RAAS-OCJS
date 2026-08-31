#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pi = pair<int, int>;
using pl = pair<ll, ll>;
const ll N = 3e5 + 10;
const ll INF = 1e10;
const ll M = 1e3 + 1;
const ll L = 31;
const ll mod = 998244353;
ll solve() {
  ll n, k;
  cin >> n >> k;
  ll t, a, b;
  ll ans = 0;
  multiset<ll> alice, bob, both;
  for (ll i = 0; i < n; i++) {
    cin >> t >> a >> b;
    if (a == 1 && b == 1) {
      both.insert(t);
    } else if (a == 1) {
      alice.insert(t);
    } else if (b == 1) {
      bob.insert(t);
    }
  }
  while (both.size() > 0 && alice.size() > 0 && bob.size() > 0 && k > 0) {
    ll a = *(alice.begin());
    ll b = *(bob.begin());
    ll c = *(both.begin());
    if (a + b < c) {
      ans += (a + b);
      alice.erase(alice.begin());
      bob.erase(bob.begin());
    } else {
      ans += c;
      both.erase(both.begin());
    }
    k--;
  }
  if (k == 0) {
    cout << ans << '\n';
    return 0;
  } else {
    if (alice.size() == 0 || bob.size() == 0) {
      if (both.size() < k) {
        cout << -1 << '\n';
      } else {
        while (k > 0) {
          ans += (*(both.begin()));
          both.erase(both.begin());
          k--;
        }
        cout << ans << '\n';
        return 0;
      }
    } else {
      if (alice.size() < k || bob.size() < k) {
        cout << -1 << '\n';
        return 0;
      } else {
        while (k > 0) {
          ans += (*(alice.begin()));
          alice.erase(alice.begin());
          ans += (*(bob.begin()));
          bob.erase(bob.begin());
          k--;
        }
        cout << ans << '\n';
        return 0;
      }
    }
  }
  return 0;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  solve();
  return 0;
}
