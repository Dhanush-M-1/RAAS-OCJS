#include <bits/stdc++.h>
using namespace std;
void GG() { cout << -1 << endl, exit(0); }
const int N = 110, P = 1000000007;
long long mul(long long x, long long y) { return 1ll * x * y % P; }
void upd(long long &x, long long y) { x = mul(x, y); }
long long Pow(long long x, long long y) {
  long long ret = 1;
  while (y) {
    if (y & 1) upd(ret, x);
    upd(x, x), y >>= 1;
  }
  return ret;
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
struct Num {
  vector<pair<int, long long>> p;
  inline void read() {
    int x;
    cin >> x;
    for (int i = 2; i * i <= x; i++)
      if (!(x % i)) {
        p.push_back(make_pair(i, 0ll));
        while (!(x % i)) ++p.back().second, x /= i;
      }
    if (x != 1) p.push_back(make_pair(x, 1ll));
  }
  inline void out() {
    long long ans = 1;
    for (auto o : p)
      if (o.second < 0) GG();
    for (auto o : p) upd(ans, Pow(o.first, o.second));
    cout << ans << endl;
  }
  inline friend bool operator==(Num x, Num y) {
    if (x.p.size() != y.p.size()) return false;
    for (int i = 0; i < x.p.size(); i++)
      if (x.p[i].first != y.p[i].first || x.p[i].second != y.p[i].second)
        return false;
    return true;
  }
  inline friend Num operator*(Num x, Num y) {
    Num z;
    int i = 0, j = 0;
    while (i < x.p.size() && j < y.p.size())
      if (x.p[i].first == y.p[j].first)
        z.p.push_back(make_pair(x.p[i].first, x.p[i].second + y.p[j].second)),
            ++i, ++j;
      else if (x.p[i].first < y.p[j].first)
        z.p.push_back(x.p[i++]);
      else
        z.p.push_back(y.p[j++]);
    while (i < x.p.size()) z.p.push_back(x.p[i++]);
    while (j < y.p.size()) z.p.push_back(y.p[j++]);
    return z;
  }
  inline friend bool operator%(Num x, Num y) {
    for (int i = 0, j = 0; j < y.p.size(); i++, j++) {
      while (i < x.p.size() && x.p[i].first != y.p[j].first) ++i;
      if (i == x.p.size() || x.p[i].second < y.p[j].second) return 1;
    }
    return 0;
  }
  inline friend Num operator/(Num x, Num y) {
    Num z;
    for (int i = 0, j = 0; i < x.p.size(); i++)
      if (j < y.p.size() && x.p[i].first == y.p[j].first) {
        z.p.push_back(make_pair(x.p[i].first, x.p[i].second - y.p[j++].second));
        if (!z.p.back().second) z.p.pop_back();
      } else
        z.p.push_back(x.p[i]);
    return z;
  }
  inline friend Num operator&(Num x, Num y) {
    Num z;
    for (int i = 0, j = 0; i < x.p.size(); i++)
      if (j < y.p.size() && x.p[i].first == y.p[j].first)
        z.p.push_back(make_pair(x.p[i].first, x.p[i].second - y.p[j++].second));
      else
        z.p.push_back(x.p[i]);
    return z;
  }
  inline friend bool operator|(Num x, Num y) {
    if (!x.p.size()) return 0;
    long long k;
    for (int i = 0, j = 0; i <= x.p.size(); i++, j++) {
      while (j < y.p.size() && !y.p[j].second) ++j;
      if (i == x.p.size()) {
        if (j == y.p.size()) return 0;
        return 1;
      }
      if (j == y.p.size()) return 1;
      if (x.p[i].first != y.p[j].first || x.p[i].second % y.p[j].second)
        return 1;
      if (!i)
        k = x.p[i].second / y.p[j].second;
      else if ((x.p[i].second / y.p[j].second) != k)
        return 1;
    }
    return 0;
  }
  inline friend Num operator^(Num x, long long y) {
    for (auto &o : x.p) o.second *= y;
    return x;
  }
  inline friend Num operator+(Num x, Num y) {
    Num z;
    for (int i = 0; i < x.p.size(); i++)
      z.p.push_back(make_pair(
          x.p[i].first,
          x.p[i].second * y.p[i].second / gcd(x.p[i].second, y.p[i].second)));
    return z;
  }
} a[N], b[N], c[N], A, B;
int n;
bool check(Num x) {
  for (int i = 1; i <= n; i++)
    if ((x % a[i]) || ((x / a[i]) | b[i])) return false;
  return true;
}
struct Pro {
  long long k, b, p;
  inline Pro(long long k = 0, long long b = 0, long long p = 0)
      : k(k), b(b), p(p) {}
  bool operator==(const Pro t) const {
    return k == t.k && b == t.b && p == t.p;
  }
};
void exgcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) return x = 1, y = 0, void();
  exgcd(b, a % b, y, x);
  return y -= a / b * x, void();
}
long long solve(Pro x, Pro y) {
  long long a = x.b * y.p - y.b * x.p, b = x.k * y.p - y.k * x.p;
  if (!b || a % b) GG();
  return a / b;
}
bool merge(int o) {
  vector<Pro> pro;
  for (int i = 0; i < A.p.size(); i++) {
    long long k1 = B.p[i].second, b1 = A.p[i].second;
    long long k2 = b[o].p[i].second, b2 = a[o].p[i].second;
    if (!k1 && !k2) {
      if (b1 ^ b2) GG();
      continue;
    }
    if (!k1) {
      if (b1 < b2 || (b1 - b2) % k2) GG();
      return A = a[o] * (b[o] ^ ((b1 - b2) / k2)), 0;
    }
    if (!k2) {
      if (b2 < b1 || (b2 - b1) % k1) GG();
      return A = A * (B ^ ((b2 - b1) / k1)), 0;
    }
    long long d = gcd(k1, k2), g = b2 - b1;
    if (g % d) GG();
    g /= d, k1 /= d, k2 /= d;
    if (pro.size()) {
      if (pro[0] == Pro(k1, g, k2)) continue;
      return A = A * (B ^ solve(pro[0], Pro(k1, g, k2))), 0;
    }
    pro.push_back(Pro(k1, g, k2));
  }
  if (pro.size()) {
    long long k1 = pro[0].k, p1 = pro[0].p, b1 = pro[0].b, x, y;
    exgcd(k1, p1, x, y);
    b1 = (b1 % p1 + p1) % p1;
    x = (x % p1 * b1 % p1 + p1) % p1;
    A = A * (B ^ x), B = B + b[o];
  }
  return 1;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) a[i].read(), b[i].read(), c[i] = a[i] * b[i];
  int flag = 1;
  for (int i = 2; i <= n; i++)
    if (!(a[i] == a[1])) {
      flag = false;
      break;
    }
  if (flag == 1) return a[1].out(), 0;
  for (int i = 1; i <= n; i++)
    if (check(a[i])) return a[i].out(), 0;
  for (int i = 1; i <= n; i++) {
    if (c[i].p.size() != c[1].p.size()) GG();
    for (int j = 0; j < c[1].p.size(); j++)
      if (c[i].p[j].first ^ c[1].p[j].first) GG();
    a[i] = c[i] & b[i], b[i] = c[i] & a[i];
  }
  A = a[1], B = b[1];
  for (int i = 2; i <= n; i++) {
    if (!merge(i)) {
      if (check(A)) return A.out(), 0;
      GG();
    }
  }
  return A.out(), 0;
  return 0;
}
