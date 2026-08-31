#include <bits/stdc++.h>
using namespace std;
using ll = int64_t;
using vl = vector<ll>;
using pll = pair<ll, ll>;
using mll = map<ll, ll>;
using vvl = vector<vl>;
using md = double;
template <typename T>
istream& operator>>(istream& c, vector<T>& v) {
  for (auto& i1 : v) c >> i1;
  return c;
}
template <typename T1, typename T2>
istream& operator>>(istream& c, pair<T1, T2>& p) {
  return c >> p.first >> p.second;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& c, pair<T1, T2> p) {
  return c << p.first << ' ' << p.second;
}
const ll mod = 1000000007;
mt19937_64 rng(0xDEADBEEF);
template <typename T>
T binpow(T a, ll b, ll c = mod) {
  if (b == 1) return a;
  if (b & 1) return binpow(a, b - 1) * a % c;
  T res = binpow(a, b >> 1);
  return res * res % c;
}
namespace geom {
pll operator+(pll a, pll b) { return {a.first + b.first, a.second + b.second}; }
pll operator-(pll a, pll b) { return {a.first - b.first, a.second - b.second}; }
pll operator-(pll a) { return {-a.first, -a.second}; }
pll operator*(pll a) { return {-a.second, a.first}; }
ll operator*(pll a, pll b) { return a.first * b.first + a.second * b.second; }
}  // namespace geom
int main() {
  using namespace geom;
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout.sync_with_stdio(0);
  cout.tie(0);
  ll n;
  cin >> n;
  string s;
  cin >> s;
  cout << min<ll>(s.size() / 11, count(s.begin(), s.end(), '8'));
  return 0;
}
