#include <bits/stdc++.h>
using namespace std;
long long good_rand() { return rand() * RAND_MAX + rand(); }
template <class A>
class myvector : public std::vector<A> {
 public:
  A &operator[](int pos) {
    if (pos < 0) pos = 0;
    while (this->size() <= pos) {
      this->push_back({});
    }
    return std::vector<A>::operator[](pos);
  }
  void print(bool b = false) {
    unsigned int si = this->size();
    if (b) std::cout << si << std::endl;
    for (unsigned int i = 0; i < si; ++i) {
      std::cout << this->operator[](i) << " ";
    }
  }
  void printendl(bool b = false) {
    print(b);
    std::cout << std::endl;
  }
  void good_random_shuffle() {
    unsigned int si = this->size();
    for (unsigned int i = 0; i < si - 1; ++i) {
      unsigned int j = good_rand() % (si - i);
      j += i;
      swap(this->operator[](i), this->operator[](j));
    }
  }
  template <class B>
  void read(B &n, bool b = false) {
    if (b) std::cin >> n;
    for (int i = 0; i < n; ++i) {
      std::cin >> this->operator[](i);
    }
  }
};
template <class A, class B = std::less<typename std::vector<A>::value_type> >
class mypriority_queue : public std::priority_queue<A, std::vector<A>, B> {
 public:
  A top() const {
    if (this->empty()) return {};
    return std::priority_queue<A, std::vector<A>, B>::top();
  }
  void pop() {
    if (this->empty()) return;
    std::priority_queue<A, std::vector<A>, B>::pop();
  }
  A take() {
    A a = this->top();
    this->pop();
    return a;
  }
  void print(bool b = false) const {
    while (!this->empty()) {
      std::cout << take() << " ";
    }
  }
  void printendl(bool b = false) const {
    print(b);
    std::cout << std::endl;
  }
};
class modll {
  static const long long mod = 1000000007;
  long long modvalue = 0;

 public:
  modll() { this->modvalue = 0; }
  modll(int x) { this->modvalue = x % mod; }
  modll(long long x) { this->modvalue = x % mod; }
  modll(const modll &x) { this->modvalue = x.modvalue; }
  long long getmodvalue() const { return modvalue; }
  static long long modpow(long long z, long long u) {
    if (u == 0) return 1;
    if (u == 1) return z;
    if (u % 2 == 0) {
      long long sa = modpow(z, u / 2);
      return (sa * sa) % mod;
    }
    return (z * modpow(z, u - 1)) % mod;
  }
  static modll fastpow(long long z, long long u) {
    modll a = modpow(z, u);
    return a;
  }
  static modll fact(long long z) {
    modll a = 1;
    for (long long i = 2; i <= z; ++i) {
      a *= i;
    }
    return a;
  }
  static modll choose(long long n, long long k) {
    modll a = 1;
    if (k > n / 2) return choose(n, n - k);
    for (long long i = n; n - i + 1 <= k; --i) {
      a *= i;
    }
    for (long long i = 2; i <= k; ++i) {
      a /= i;
    }
    return a;
  }
  long long rec() const { return modll::modpow(modvalue, mod - 2); }
  modll operator+(const modll &x) const {
    modll a;
    a.modvalue = (this->modvalue + x.modvalue) % mod;
    return a;
  }
  modll operator-(const modll &x) const {
    modll a;
    a.modvalue = (mod + this->modvalue - x.modvalue) % mod;
    return a;
  }
  modll operator*(const modll &x) const {
    modll a;
    a.modvalue = (this->modvalue * x.modvalue) % mod;
    return a;
  }
  modll operator/(const modll &x) const {
    modll a;
    if (x.modvalue == 0) return a;
    a.modvalue = (this->modvalue * x.rec()) % mod;
    return a;
  }
  template <class A>
  modll operator+(A x) const {
    if (x < 0) return this->operator-(-x);
    modll a;
    a.modvalue = (this->modvalue + x % mod) % mod;
    return a;
  }
  template <class A>
  modll operator-(A x) const {
    if (x < 0) return this->operator+(-x);
    modll a;
    a.modvalue = (this->modvalue - (x % mod) + mod) % mod;
    return a;
  }
  template <class A>
  modll operator*(A x) const {
    if (x < 0) {
      long long y = x / mod;
      y *= mod;
      y = x - y;
      x = y;
    }
    x %= mod;
    modll a;
    a.modvalue = (this->modvalue * x) % mod;
    return a;
  }
  template <class A>
  modll operator/(A x) const {
    if (x < 0) {
      long long y = x / mod;
      y *= mod;
      y = x - y;
      x = y;
    }
    x %= mod;
    modll a;
    if (x == 0) return a;
    modll b = x;
    a = *this / b;
    return a;
  }
  void operator=(modll x) { this->modvalue = x.modvalue; }
  template <class A>
  void operator=(A x) {
    this->modvalue = x % mod;
  }
  bool operator==(modll x) const { return (this->modvalue == x.modvalue); }
  template <class A>
  bool operator==(A x) const {
    return (this->modvalue == x);
  }
  bool operator<(modll x) const { return (this->modvalue < x.modvalue); }
  template <class A>
  bool operator<(A x) const {
    return (this->modvalue < x);
  }
  bool operator>(modll x) const { return (this->modvalue > x.modvalue); }
  template <class A>
  bool operator>(A x) {
    return (this->modvalue > x);
  }
  bool operator<=(modll x) const { return (this->modvalue <= x.modvalue); }
  template <class A>
  bool operator<=(A x) const {
    return (this->modvalue <= x);
  }
  bool operator>=(modll x) const { return (this->modvalue >= x.modvalue); }
  template <class A>
  bool operator>=(A x) const {
    return (this->modvalue >= x);
  }
  void operator+=(const modll &x) {
    this->modvalue += x.modvalue;
    this->modvalue %= mod;
  }
  template <class A>
  void operator+=(A x) {
    if (x < 0) this->operator+=(-1 * x);
    this->modvalue += x % mod;
    if (modvalue < 0) {
      this->modvalue *= -1;
      if (modvalue % mod == 0)
        modvalue = 0;
      else
        modvalue = mod - (modvalue % mod);
    }
    this->modvalue %= mod;
  }
  void operator-=(const modll &x) {
    this->modvalue -= x.modvalue;
    while (this->modvalue < 0) this->modvalue += mod;
    this->modvalue %= mod;
  }
  template <class A>
  void operator-=(A x) {
    if (x < 0) this->operator+=(-1 * x);
    this->modvalue -= x % mod;
    if (modvalue < 0) {
      this->modvalue *= -1;
      if (modvalue % mod == 0)
        modvalue = 0;
      else
        modvalue = mod - (modvalue % mod);
    }
    this->modvalue %= mod;
  }
  void operator*=(const modll &x) {
    this->modvalue *= x.modvalue;
    this->modvalue %= mod;
  }
  template <class A>
  void operator*=(A x) {
    bool neg = false;
    if (x < 0) {
      neg = true;
      x *= -1;
    }
    this->modvalue *= x % mod;
    if (modvalue < 0) {
      this->modvalue *= -1;
      if (modvalue % mod == 0)
        modvalue = 0;
      else
        modvalue = mod - (modvalue % mod);
    }
    this->modvalue %= mod;
    if (neg) {
      this->modvalue = mod - modvalue;
      this->modvalue %= mod;
    }
  }
  void operator/=(const modll &x) {
    if (x.modvalue == 0) {
      this->modvalue = 0;
      return;
    }
    this->modvalue = this->modvalue / x.modvalue;
    this->modvalue %= mod;
  }
  template <class A>
  void operator/=(A x) {
    bool neg = false;
    if (x < 0) {
      neg = true;
      x *= -1;
    }
    modll se = x % mod;
    this->operator/=(se);
    if (modvalue < 0) {
      this->modvalue *= -1;
      if (modvalue % mod == 0)
        modvalue = 0;
      else
        modvalue = mod - (modvalue % mod);
    }
    this->modvalue %= mod;
    if (neg) {
      this->modvalue = mod - modvalue;
      this->modvalue %= mod;
    }
  }
  modll operator++() {
    modvalue++;
    if (modvalue == mod) modvalue = 0;
  }
  modll operator--() {
    modvalue--;
    if (modvalue < 0) modvalue += mod;
  }
  void print() const { std::cout << this->modvalue; }
  void printspace() const { std::cout << this->modvalue << " "; }
  void printendl() const { std::cout << this->modvalue << std::endl; }
};
set<long long> pos;
set<long long> t;
myvector<long long> v;
myvector<long long> w;
long long n, m, k, l, r, x, y;
mypriority_queue<long long> pq;
const long long N = 200005;
long long a[2 * N];
long long b[2 * N];
long long c[2 * N];
long long from[2 * N];
long long to[2 * N];
long long childa(long long z) { return (z * 2) + 1; }
long long childb(long long z) { return (z * 2) + 2; }
long long parent(long long z) {
  if (z == 0) return -1;
  return (z - 1) / 2;
}
void update(long long u) {
  if (u < 0) return;
  if (childa(u) < 2 * m - 1)
    b[u] = (b[childa(u)] + c[childa(u)] + b[childb(u)] + c[childb(u)]);
  else
    b[u] = a[m - 1];
  if (u != 0) update(parent(u));
}
void add(long long l, long long r, long long z, long long u) {
  if (from[u] == l && to[u] == r) {
    c[u] += z;
    update(u);
  } else {
    if (to[childa(u)] >= l) {
      add(l, min(r, to[childa(u)]), z, childa(u));
    }
    if (from[childb(u)] <= r) {
      add(max(l, from[childb(u)]), r, z, childb(u));
    }
  }
}
long long getvalue(long long l, long long r, long long u) {
  long long sa = 0;
  long long sb = 0;
  if (from[u] == l && to[u] == r) {
    return c[u] + b[u];
  }
  if (to[childa(u)] >= l) {
    sa = getvalue(l, min(r, to[childa(u)]), childa(u));
  }
  if (from[childb(u)] <= r) {
    sb = getvalue(max(l, from[childb(u)]), r, childb(u));
  }
  return c[u] + sa + sb;
}
const int SIZE = 400005;
long long A[SIZE];
long long sum(long long i) {
  long long sum = 0;
  while (i > 0) sum += A[i], i -= ((i) & -(i));
  return sum;
}
void add(long long i, long long k) {
  while (i < SIZE) A[i] += k, i += ((i) & -(i));
}
int main() {
  std::ios_base::sync_with_stdio(false);
  v.read(n, true);
  w[n - 1] = 0;
  for (int i = 1; i <= n; ++i) add(i, i);
  for (int i = 1; i <= n; ++i) t.insert(i);
  for (int i = n - 1; i >= 0; --i) {
    long long small = 0;
    long long big = n;
    while (small != big) {
      int mid = small + big;
      mid /= 2;
      if (sum(mid) < v[i])
        small = mid + 1;
      else
        big = mid;
    }
    x = *t.upper_bound(small);
    add(x, -x);
    t.erase(x);
    w[i] = x;
  }
  w.print(false);
}
