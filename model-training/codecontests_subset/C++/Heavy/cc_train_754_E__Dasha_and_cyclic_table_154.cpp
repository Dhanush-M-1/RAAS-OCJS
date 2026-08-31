#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
using ll = long long;
template <typename T>
using v = vector<T>;
struct Complex {
  double x, y;
  Complex() : x(0.0), y(0.0) {}
  Complex(double xin) : x(xin), y(0.0) {}
  Complex(double xin, double yin) : x(xin), y(yin) {}
  Complex operator*(const Complex& rhs) const {
    return Complex(x * rhs.x - y * rhs.y, x * rhs.y + y * rhs.x);
  }
  Complex operator+(const Complex& rhs) const {
    return (Complex)(*this) += rhs;
  }
  Complex operator-(const Complex& rhs) const {
    return (Complex)(*this) -= rhs;
  }
  Complex& operator+=(const Complex& rhs) {
    x += rhs.x;
    y += rhs.y;
    return *this;
  }
  Complex& operator-=(const Complex& rhs) {
    x -= rhs.x;
    y -= rhs.y;
    return *this;
  }
};
double norm(const Complex& z) { return z.x * z.x + z.y * z.y; }
using clx = Complex;
static const double pi = 2.0 * acos(0.0);
static v<clx> roots;
ll log2ll(ll a) {
  ll result = 0;
  while (a >>= 1) result++;
  return result;
}
ll pow2ll(ll a) { return (1LL << a); }
v<ll> getreverse(ll deg) {
  ll k = 1 + log2(deg), twok = pow2ll(k);
  v<ll> r(twok);
  for (ll i = 1; i < twok; i++) {
    r[i] = (r[i >> 1] >> 1) | ((i & 1) << (k - 1));
  }
  return r;
}
v<clx> getroots(ll deg) {
  ll twok = pow2ll(1 + log2ll(deg));
  v<clx> res(twok);
  for (ll i = 0; i < twok / 2; i++) {
    double angle = (2.0 * i * pi) / twok;
    res[i + twok / 2] = clx(cos(angle), sin(angle));
  }
  for (ll i = twok / 2 - 1; i >= 1; i--) {
    res[i] = res[2 * i];
  }
  return res;
}
v<clx> fft(const v<clx>& a, const v<ll>& rev) {
  assert(a.size() == rev.size());
  ll sz = a.size();
  v<clx> f(sz);
  for (ll i = 0; i < sz; i++) {
    f[i] = a[rev[i]];
  }
  for (ll k = 1; k < sz; k <<= 1) {
    for (ll i = 0; i < sz; i += 2 * k) {
      for (ll j = 0; j < k; j++) {
        clx r = f[i + j + k] * roots[j + k];
        f[i + j + k] = f[i + j] - r;
        f[i + j] += r;
      }
    }
  }
  return f;
}
v<clx> mul(const v<clx>& a, const v<clx>& b) {
  ll adeg = a.size() - 1, bdeg = b.size() - 1, newdeg = adeg + bdeg;
  ll k = 1 + log2ll(newdeg);
  ll twok = pow2ll(k);
  v<ll> rev = getreverse(newdeg);
  v<clx> f(a), g(b);
  f.resize(twok);
  g.resize(twok);
  f = fft(f, rev);
  g = fft(g, rev);
  for (ll i = 0; i < twok; i++) {
    f[i] = f[i] * g[i] * clx(1.0 / twok, 0);
  }
  reverse(f.begin() + 1, f.end());
  f = fft(f, rev);
  f.resize(newdeg + 1);
  return f;
}
void printnomatch(ll n, ll m) {
  for (ll i = 0; i < n; i++) {
    for (ll j = 0; j < m; j++) {
      cout << 0;
    }
    cout << endl;
  }
}
static const ll L = 400;
static const ll V = 'z' - 'a' + 1;
static ll N;
static ll T[L][L];
static ll P[L][L];
int main(int argc, char const* argv[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  ll n, m, r, c;
  cin >> n >> m;
  string str;
  for (ll i = 0; i < n; i++) {
    cin >> str;
    for (ll j = 0; j < m; j++) {
      T[i][j] = str[j] - 'a';
    }
  }
  cin >> r >> c;
  for (ll i = 0; i < r; i++) {
    cin >> str;
    for (ll j = 0; j < c; j++) {
      P[i][j] = ('a' <= str[j] && str[j] <= 'z') ? str[j] - 'a' : -1;
    }
  }
  ll newr = min(n, r), newc = min(m, c);
  ll lettercount = 0;
  for (ll i = 0; i < newr; i++) {
    for (ll j = 0; j < newc; j++) {
      ll cell = -1;
      for (ll a = i; a < r; a += n) {
        for (ll b = j; b < c; b += m) {
          if (cell == -1) {
            cell = P[a][b];
          } else if (cell != P[a][b] && P[a][b] != -1) {
            printnomatch(n, m);
            return 0;
          }
        }
      }
      P[i][j] = cell;
      lettercount += (cell != -1);
    }
  }
  r = newr, c = newc;
  N = 2 * n + 2 * r - 2;
  ll tdeg = (n + r - 1) + N * (m + c - 1);
  ll pdeg = (r - 1) + N * (c - 1);
  v<clx> pt(1 + tdeg), pp(1 + pdeg);
  for (ll i = 0; i < n + r; i++) {
    for (ll j = 0; j < m + c; j++) {
      double angle = (2.0 * pi * T[i % n][j % m]) / V;
      pt[i + N * j] = clx(cos(angle), sin(angle));
    }
  }
  for (ll i = 0; i < r; i++) {
    for (ll j = 0; j < c; j++) {
      double angle = -(2.0 * pi * P[i][j]) / V;
      pp[(r - 1 - i) + N * (c - 1 - j)] =
          (P[i][j] == -1) ? 0 : clx(cos(angle), sin(angle));
    }
  }
  roots = getroots(tdeg + pdeg);
  v<clx> ptp = mul(pt, pp);
  double angle = 2 * pi / V;
  double epsilon = 0.5 * norm(clx(1.0) - clx(cos(angle), sin(angle)));
  for (ll i = 0; i < n; i++) {
    for (ll j = 0; j < m; j++) {
      clx coef = ptp[i + N * j + (r - 1) + (c - 1) * N];
      double difnorm = norm((clx)lettercount - coef);
      cout << "01"[difnorm < epsilon];
    }
    cout << endl;
  }
  return 0;
}
