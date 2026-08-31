#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using cd = complex<double>;
int main() {
  ll t;
  cin >> t;
  while (t--) {
    ll n, k;
    cin >> n >> k;
    pair<pair<ll, ll>, ll> ar[n];
    for (ll i = 0; i < n; i++) {
      cin >> ar[i].first.second >> ar[i].first.first;
      ar[i].second = i + 1;
    }
    sort(ar, ar + n);
    ll dp[n + 1][k + 1], ch[n + 1][k + 1];
    for (ll i = 0; i <= n; i++) {
      for (ll j = 0; j <= k; j++) {
        dp[i][j] = -(ll)(1e18);
      }
    }
    dp[0][0] = 0;
    for (ll i = 0; i < n; i++) {
      for (ll j = 0; j <= k; j++) {
        ll& tar = dp[i + 1][j + 1];
        ll v1 = dp[i][j] + j * ar[i].first.first + ar[i].first.second,
           v2 = dp[i][j] + (k - 1) * ar[i].first.first;
        if (j < k && v1 > tar) {
          tar = v1;
          ch[i + 1][j + 1] = j;
        }
        if (v2 > dp[i + 1][j]) {
          dp[i + 1][j] = v2;
          ch[i + 1][j] = j;
        }
      }
    }
    vector<ll> v1, v2;
    ll x = n, y = k;
    for (ll i = 0; i < n; i++) {
      if (ch[x][y] == y) {
        v2.push_back(ar[n - 1 - i].second);
      } else {
        v1.push_back(ar[n - 1 - i].second);
      }
      y = ch[x][y];
      x--;
    }
    reverse(v1.begin(), v1.end());
    cout << v1.size() + 2 * v2.size() << "\n";
    ll last = v1.back();
    v1.back();
    v1.pop_back();
    for (ll x : v1) {
      cout << x << " ";
    }
    for (ll x : v2) {
      cout << x << " " << -x << " ";
    }
    cout << last << "\n";
  }
}
