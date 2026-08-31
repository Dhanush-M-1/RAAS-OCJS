#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<ll> a(n);
  const int C = 11;
  vector<ll> c(C, 0);
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    ++c[std::to_string(a[i]).length()];
  }
  const ll mod = 998244353;
  ll ans = 0;
  for (int i = 0; i < n; ++i) {
    ll q = a[i];
    int m = std::to_string(q).length();
    ll tmp = 0, coeff = 1;
    for (int k = 0; k < m; ++k) {
      tmp += (q % 10) * coeff;
      q /= 10;
      coeff = (coeff * 100) % mod;
    }
    ll A = 0;
    for (int k = m; k < C; ++k) A += c[k];
    ans += (tmp * 11 * A) % mod;
    for (int l = 1; l < m; ++l)
      if (c[l]) {
        tmp = 0;
        q = a[i];
        coeff = 1;
        for (int k = 0; k < l; ++k) {
          tmp += (q % 10) * coeff;
          q /= 10;
          coeff = (coeff * 100) % mod;
        }
        ans += (tmp * 11 * c[l]) % mod;
        tmp = 0;
        for (int k = l; k < m; ++k) {
          tmp += (q % 10) * coeff;
          q /= 10;
          coeff = (coeff * 10) % mod;
        }
        ans += (2 * tmp * c[l]) % mod;
      }
    ans %= mod;
  }
  cout << ans << endl;
  return 0;
}
