#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
using ll = long long;
long long arr[N];
ll n;
int solve(ll x) {
  if (x == n * (n - 1) + 1) {
    return 1;
  }
  auto p = lower_bound(arr + 1, arr + n + 1, x) - arr - 1;
  x -= arr[p];
  if (x & 1) {
    return p + 1;
  }
  return (p + 1 + x / 2);
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    ll l, r;
    cin >> n >> l >> r;
    for (int i = 1; i <= n; i++) {
      arr[i] = arr[i - 1] + 2 * (n - i);
    }
    for (ll i = l; i <= r; i++) {
      cout << solve(i) << " ";
    }
    cout << "\n";
  }
  return 0;
}
