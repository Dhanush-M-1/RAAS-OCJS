#include <bits/stdc++.h>
using namespace std;
void GG() {
  puts("-1");
  exit(0);
}
long long gcd(long long x, long long y) { return y ? gcd(y, x % y) : x; }
void exgcd(long long x, long long y, long long &a, long long &b) {
  if (!y) {
    a = 1;
    b = 0;
    return;
  }
  exgcd(y, x % y, b, a);
  b -= (x / y) * a;
}
long long getinv(long long x, long long y) {
  long long a, b;
  exgcd(x, y, a, b);
  return (a % y + y) % y;
}
long long mul(long long x, long long y, long long mod) {
  long long s = 0;
  for (; y; y /= 2, x = (x + x) % mod)
    if (y & 1) s = (s + x) % mod;
  return s;
}
pair<long long, long long> operator/(pair<long long, long long> a,
                                     pair<long long, long long> b) {
  assert(a.first % b.first == 0);
  assert(a.second >= b.second);
  a.second -= b.second;
  assert(a.second % b.first == 0);
  return pair<long long, long long>(a.first / b.first, a.second / b.first);
}
pair<long long, long long> operator*(pair<long long, long long> a,
                                     pair<long long, long long> b) {
  return pair<long long, long long>(a.first * b.first,
                                    a.first * b.second + a.second);
}
void equation(pair<long long, long long> x, pair<long long, long long> y,
              pair<long long, long long> &v1, pair<long long, long long> &v2) {
  bool fl = (x < y);
  if (fl) swap(x, y);
  if (x == y) {
    if (!x.first)
      v1 = v2 = pair<long long, long long>(-1, 0);
    else
      v1 = v2 = pair<long long, long long>(1, 0);
  } else if (!x.first)
    GG();
  else if (!y.first) {
    if (x.second > y.second || (y.second - x.second) % x.first) GG();
    v1 = pair<long long, long long>(0, (y.second - x.second) / x.first);
    v2 = pair<long long, long long>(1, 0);
  } else if (x.first == y.first) {
    if ((x.second - y.second) % x.first) GG();
    v1 = pair<long long, long long>(1, 0);
    v2 = pair<long long, long long>(1, (x.second - y.second) / x.first);
  } else {
    long long G = gcd(x.first, y.first);
    if (x.second % G != y.second % G) GG();
    long long rem = x.second % G;
    pair<long long, long long> X = x, Y = y;
    x.first /= G;
    y.first /= G;
    x.second /= G;
    y.second /= G;
    long long mod = x.first * y.first;
    long long val = (mul(x.second % x.first,
                         mul(y.first, getinv(y.first, x.first), mod), mod) +
                     mul(y.second % y.first,
                         mul(x.first, getinv(x.first, y.first), mod), mod)) %
                    mod;
    if (val < x.second) val += ((x.second - val - 1) / mod + 1) * mod;
    if (val < y.second) val += ((y.second - val - 1) / mod + 1) * mod;
    pair<long long, long long> res(mod * G, val * G + rem);
    v1 = res / X;
    v2 = res / Y;
  }
  if (fl) swap(v1, v2);
}
void equationeq(pair<long long, long long> x, pair<long long, long long> y,
                pair<long long, long long> &v1,
                pair<long long, long long> &v2) {
  if (x == y)
    v1 = v2 = pair<long long, long long>(1, 0);
  else {
    if (x.first == y.first) GG();
    long long T = (x.second - y.second) / (y.first - x.first);
    if (x.first * T + x.second != y.first * T + y.second || T < 0) GG();
    v1 = v2 = pair<long long, long long>(0, T);
  }
}
void merge(pair<long long, long long> &v1, pair<long long, long long> &v2,
           pair<long long, long long> l1, pair<long long, long long> l2) {
  if (v1.first == -1) {
    v1 = l1;
    v2 = l2;
    return;
  }
  if (l1.first == -1) return;
  pair<long long, long long> i1, i2;
  equation(v1, l1, i1, i2);
  if (i1.first != -1) v1 = v1 * i1, l1 = l1 * i2, v2 = v2 * i1, l2 = l2 * i2;
  equationeq(v2, l2, i1, i2);
  v1 = v1 * i1;
  l1 = l1 * i2;
  v2 = v2 * i1;
  l2 = l2 * i2;
}
map<int, pair<long long, long long> > tmp, ans;
void input(map<int, pair<long long, long long> > &mp) {
  int x;
  mp.clear();
  scanf("%d", &x);
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0) {
      int cnt = 0;
      for (; x % i == 0; x /= i, ++cnt)
        ;
      mp[i].second = cnt;
    }
  if (x != 1) mp[x].second++;
  scanf("%d", &x);
  for (int i = 2; i * i <= x; i++)
    if (x % i == 0) {
      int cnt = 0;
      for (; x % i == 0; x /= i, ++cnt)
        ;
      mp[i].first = cnt;
    }
  if (x != 1) mp[x].first++;
}
map<int, pair<long long, long long> > merge(
    map<int, pair<long long, long long> > x,
    map<int, pair<long long, long long> > y) {
  for (auto i : y) x[i.first].first += 0;
  pair<long long, long long> lim1(-1, 0), lim2(-1, 0);
  for (auto i : x) {
    pair<long long, long long> v1 = i.second, v2 = y[i.first], l1, l2;
    equation(v1, v2, l1, l2);
    merge(lim1, lim2, l1, l2);
  }
  if (lim1 != pair<long long, long long>(-1, 0)) {
    for (auto &i : x) i.second = i.second * lim1;
  }
  return x;
}
const int mo = 1000000007;
int power(int x, long long y) {
  int s = 1;
  for (; y; y /= 2, x = 1ll * x * x % mo)
    if (y & 1) s = 1ll * s * x % mo;
  return s;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = (int)(1); i <= (int)(n); i++) {
    input(tmp);
    if (i != 1)
      ans = merge(ans, tmp);
    else
      ans = tmp;
  }
  int res = 1;
  for (auto i : ans) res = 1ll * res * power(i.first, i.second.second) % mo;
  printf("%d\n", res);
}
