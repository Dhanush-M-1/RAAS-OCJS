#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <class t, class u>
void chmax(t& first, u second) {
  if (first < second) first = second;
}
template <class t, class u>
void chmin(t& first, u second) {
  if (second < first) first = second;
}
template <class t>
using vc = vector<t>;
template <class t>
using vvc = vc<vc<t>>;
using pi = pair<ll, ll>;
using vi = vc<ll>;
template <class t, class u>
ostream& operator<<(ostream& os, const pair<t, u>& p) {
  return os << "{" << p.first << "," << p.second << "}";
}
template <class t>
ostream& operator<<(ostream& os, const vc<t>& v) {
  os << "{";
  for (auto e : v) os << e << ",";
  return os << "}";
}
using uint = unsigned;
using ull = unsigned long long;
uint mod = 1;
struct mint {
  uint v;
  mint(ll vv = 0) { s(vv % mod + mod); }
  mint& s(uint vv) {
    v = vv < mod ? vv : vv - mod;
    return *this;
  }
  mint operator-() const { return mint() - *this; }
  mint& operator+=(const mint& rhs) { return s(v + rhs.v); }
  mint& operator-=(const mint& rhs) { return s(v + mod - rhs.v); }
  mint& operator*=(const mint& rhs) {
    v = ull(v) * rhs.v % mod;
    return *this;
  }
  mint& operator/=(const mint& rhs) { return *this *= rhs.inv(); }
  mint operator+(const mint& rhs) const { return mint(*this) += rhs; }
  mint operator-(const mint& rhs) const { return mint(*this) -= rhs; }
  mint operator*(const mint& rhs) const { return mint(*this) *= rhs; }
  mint operator/(const mint& rhs) const { return mint(*this) /= rhs; }
  mint pow(ll n) const {
    mint res(1), x(*this);
    while (n) {
      if (n & 1) res *= x;
      x *= x;
      n >>= 1;
    }
    return res;
  }
  mint inv() const { return pow(mod - 2); }
  friend ostream& operator<<(ostream& os, const mint& m) { return os << m.v; }
};
const ll Vmax = (1 << 21) + 10;
mint fact[Vmax], finv[Vmax], inv[Vmax];
void initfact() {
  fact[0] = 1;
  for (ll i = ll(1); i < ll(Vmax); i++) {
    fact[i] = fact[i - 1] * i;
  }
  finv[Vmax - 1] = fact[Vmax - 1].inv();
  for (ll i = Vmax - 2; i >= 0; i--) {
    finv[i] = finv[i + 1] * (i + 1);
  }
  for (ll i = Vmax - 1; i >= 1; i--) {
    inv[i] = finv[i] * fact[i - 1];
  }
}
mint choose(ll n, ll k) { return fact[n] * finv[n - k] * finv[k]; }
mint binom(ll first, ll second) {
  return fact[first + second] * finv[first] * finv[second];
}
mint catalan(ll n) {
  return binom(n, n) - (n - 1 >= 0 ? binom(n - 1, n + 1) : 0);
}
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(0);
  cout << fixed << setprecision(20);
  ll n, h;
  cin >> n >> h;
  cin >> mod;
  initfact();
  chmin(h, 20);
  ll s = min(ll(1) << (h - 1), n);
  ll sz[2], cnt[2];
  sz[0] = n / s;
  sz[1] = sz[0] + 1;
  cnt[1] = n % s;
  cnt[0] = s - cnt[1];
  mint ans = 0;
  for (ll i = ll(1); i < ll(n); i++) {
    ll k = n - i + 1;
    mint den = choose(n, k) * k * (k - 1);
    mint num = 0;
    for (ll first = ll(0); first < ll(2); first++)
      for (ll second = ll(0); second < ll(2); second++) {
        mint wab = cnt[first] * (cnt[second] - (first == second));
        mint sum = 0;
        for (ll c = ll(0); c < ll(2); c++)
          for (ll d = ll(0); d < ll(2); d++) {
            mint x = 0;
            ll rem = n;
            if (c) rem -= sz[first];
            if (d) rem -= sz[second];
            if (rem >= k) x = choose(rem, k);
            if (c ^ d)
              sum -= x;
            else
              sum += x;
          }
        num += wab * sum;
      }
    ans += (mint(1) - num / den) / 2 * i;
  }
  cout << ans << endl;
}
