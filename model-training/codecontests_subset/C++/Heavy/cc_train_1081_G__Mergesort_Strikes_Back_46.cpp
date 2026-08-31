#include <bits/stdc++.h>
using namespace std;
template <class S, class T>
ostream& operator<<(ostream& o, const pair<S, T>& p) {
  return o << "(" << p.first << "," << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& o, const vector<T>& vc) {
  o << "{";
  for (const T& v : vc) o << v << ",";
  o << "}";
  return o;
}
using ll = long long;
template <class T>
using V = vector<T>;
template <class T>
using VV = vector<vector<T>>;
constexpr ll TEN(int n) { return (n == 0) ? 1 : 10 * TEN(n - 1); }
unsigned int mod = 1;
struct ModInt {
  using uint = unsigned int;
  using ll = long long;
  using ull = unsigned long long;
  uint v;
  ModInt() : v(0) {}
  ModInt(ll _v) : v(normS(_v % mod + mod)) {}
  explicit operator bool() const { return v != 0; }
  static uint normS(const uint& x) { return (x < mod) ? x : x - mod; }
  static ModInt make(const uint& x) {
    ModInt m;
    m.v = x;
    return m;
  }
  ModInt operator+(const ModInt& b) const { return make(normS(v + b.v)); }
  ModInt operator-(const ModInt& b) const { return make(normS(v + mod - b.v)); }
  ModInt operator-() const { return make(normS(mod - v)); }
  ModInt operator*(const ModInt& b) const { return make((ull)v * b.v % mod); }
  ModInt operator/(const ModInt& b) const { return *this * b.inv(); }
  ModInt& operator+=(const ModInt& b) { return *this = *this + b; }
  ModInt& operator-=(const ModInt& b) { return *this = *this - b; }
  ModInt& operator*=(const ModInt& b) { return *this = *this * b; }
  ModInt& operator/=(const ModInt& b) { return *this = *this / b; }
  ModInt& operator++(int) { return *this = *this + 1; }
  ModInt& operator--(int) { return *this = *this - 1; }
  ll extgcd(ll a, ll b, ll& x, ll& y) const {
    ll p[] = {a, 1, 0}, q[] = {b, 0, 1};
    while (*q) {
      ll t = *p / *q;
      for (int i = 0; i < (int)(3); i++) swap(p[i] -= t * q[i], q[i]);
    }
    if (p[0] < 0)
      for (int i = 0; i < (int)(3); i++) p[i] = -p[i];
    x = p[1], y = p[2];
    return p[0];
  }
  ModInt inv() const {
    ll x, y;
    extgcd(v, mod, x, y);
    return make(normS(x + mod));
  }
  ModInt pow(ll p) const {
    if (p < 0) return inv().pow(-p);
    ModInt a = 1;
    ModInt x = *this;
    while (p) {
      if (p & 1) a *= x;
      x *= x;
      p >>= 1;
    }
    return a;
  }
  bool operator==(const ModInt& b) const { return v == b.v; }
  bool operator!=(const ModInt& b) const { return v != b.v; }
  friend istream& operator>>(istream& o, ModInt& x) {
    ll tmp;
    o >> tmp;
    x = ModInt(tmp);
    return o;
  }
  friend ostream& operator<<(ostream& o, const ModInt& x) { return o << x.v; }
};
using mint = ModInt;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  cout << fixed << setprecision(20);
  int N, K;
  cin >> N >> K >> mod;
  K--;
  V<int> s = {N};
  for (int i = 0; i < (int)(K); i++) {
    if ((int)s.size() == N) break;
    V<int> ns;
    for (int v : s) {
      ns.push_back((v + 1) / 2);
      if (v / 2 != 0) ns.push_back(v / 2);
    }
    s = ns;
  }
  true;
  sort(s.begin(), s.end());
  V<int> v, n;
  {
    int c = 0;
    for (int x : s)
      if (s[0] == x) c++;
    v.push_back(s[0]);
    n.push_back(c);
    if (c != (int)s.size()) {
      v.push_back(s.back());
      n.push_back((int)s.size() - c);
    }
  }
  mint res = 0;
  for (int v : s) res += mint(v) * (v - 1) / 4;
  for (int i = 0; i < (int)(v.size()); i++)
    for (int j = 0; j < (int)(i + 1); j++) {
      mint tmp = mint(v[i]) * v[j] / 2;
      for (int x = 2; x <= v[i] + v[j]; x++) {
        mint num = x - 1 - max(x - 1 - v[i], 0) - max(x - 1 - v[j], 0);
        tmp -= num / x;
      }
      res += tmp * (i == j ? n[i] * (n[i] - 1) / 2 : n[i] * n[j]);
    }
  cout << res << endl;
}
