#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T sqr(T x) {
  return x * x;
}
template <class T>
inline T parse(const string &s) {
  T x;
  stringstream ss(s);
  ss >> x;
  return x;
}
const double EPS = 1e-12;
const int INF = 1000 * 1000 * 1000;
const long long LINF = INF * 1ll * INF;
const double DINF = 1e200;
const double PI = 3.1415926535897932384626433832795l;
int gcd(int a, int b) { return a ? gcd(b % a, a) : b; }
long long gcd(long long a, long long b) { return a ? gcd(b % a, a) : b; }
long long gcdex(long long a, long long b, long long &x, long long &y) {
  if (!a) {
    x = 0, y = 1;
    return b;
  }
  long long k = b / a;
  long long g = gcdex(b - k * a, a, y, x);
  x -= k * y;
  return g;
}
long long inv(long long a, long long m) {
  assert(m > 1);
  long long x, y, g;
  g = gcdex(a, m, x, y);
  return (x % (m / g) + m / g) % m / g;
}
long long crt(long long a1, long long m1, long long a2, long long m2) {
  long long a = (a2 - a1 % m2 + m2) % m2;
  long long x, y, g;
  g = gcdex(m1, m2, x, y);
  if (a % g) return -1;
  long long m = m1 / g * m2;
  assert(x + m2 >= 0);
  x = a / g * (x + m2) % m2;
  long long r = (a1 + x * m1) % m;
  assert(r % m1 == a1 && r % m2 == a2);
  return r;
}
long long powmod(long long a, long long p, long long m) {
  assert(p >= 0);
  long long r = 1;
  while (p) {
    if (p & 1) r = r * a % m;
    p >>= 1;
    a = a * a % m;
  }
  return r;
}
bool isprime(long long a) {
  if (a <= 1) return false;
  for (long long i = 2; i * i <= a; ++i) {
    if (a % i == 0) return false;
  }
  return true;
}
long long sqrtup(long long a) {
  if (!a) return 0;
  long long x = max(0ll, (long long)sqrt((double)a));
  while (x * x >= a) --x;
  while ((x + 1) * (x + 1) < a) ++x;
  return x + 1;
}
long long isqrt(long long a) {
  if (a <= 0) {
    assert(!a);
    return 0;
  }
  long long x = (long long)sqrt((double)a);
  while (sqr(x + 1) <= a) ++x;
  while (x * x > a) --x;
  return x;
}
long long sgn(long long x) { return x < 0 ? -1 : x > 0 ? 1 : 0; }
template <class T>
ostream &operator<<(ostream &s, const vector<T> &v);
template <class A, class B>
ostream &operator<<(ostream &s, const pair<A, B> &p);
template <class K, class V>
ostream &operator<<(ostream &s, const map<K, V> &m);
template <class T>
ostream &operator<<(ostream &s, const set<T> &m);
template <class T, size_t N>
ostream &operator<<(ostream &s, const array<T, N> &a);
template <class... T>
ostream &operator<<(ostream &s, const tuple<T...> &t);
template <class T>
ostream &operator<<(ostream &s, const vector<T> &v) {
  s << '[';
  for (int i = 0; i < (((int)(v).size())); ++i) {
    if (i) s << ',';
    s << v[i];
  }
  s << ']';
  return s;
}
template <class A, class B>
ostream &operator<<(ostream &s, const pair<A, B> &p) {
  s << "(" << p.first << "," << p.second << ")";
  return s;
}
template <class K, class V>
ostream &operator<<(ostream &s, const map<K, V> &m) {
  s << "{";
  bool f = false;
  for (const auto &it : m) {
    if (f) s << ",";
    f = true;
    s << it.first << ": " << it.second;
  }
  s << "}";
  return s;
}
template <class T>
ostream &operator<<(ostream &s, const set<T> &m) {
  s << "{";
  bool f = false;
  for (const auto &it : m) {
    if (f) s << ",";
    f = true;
    s << it;
  }
  s << "}";
  return s;
}
template <class T>
ostream &operator<<(ostream &s, const multiset<T> &m) {
  s << "{";
  bool f = false;
  for (const auto &it : m) {
    if (f) s << ",";
    f = true;
    s << it;
  }
  s << "}";
  return s;
}
template <class T, class V, class C>
ostream &operator<<(ostream &s, const priority_queue<T, V, C> &q) {
  auto a = q;
  s << "{";
  bool f = false;
  while (!a.empty()) {
    if (f) s << ",";
    f = true;
    s << a.top();
    a.pop();
  }
  return s << "}";
}
template <class T, size_t N>
ostream &operator<<(ostream &s, const array<T, N> &a) {
  s << '[';
  for (int i = 0; i < (((int)(a).size())); ++i) {
    if (i) s << ',';
    s << a[i];
  }
  s << ']';
  return s;
}
template <class T>
ostream &operator<<(ostream &s, const deque<T> &a) {
  s << '[';
  for (int i = 0; i < (((int)(a).size())); ++i) {
    if (i) s << ',';
    s << a[i];
  }
  s << ']';
  return s;
}
template <size_t n, class... T>
struct put1 {
  static ostream &put(ostream &s, const tuple<T...> &t) {
    s << get<sizeof...(T) - n>(t);
    if (n > 1) s << ',';
    return put1<n - 1, T...>::put(s, t);
  }
};
template <class... T>
struct put1<0, T...> {
  static ostream &put(ostream &s, const tuple<T...> &t) { return s; }
};
template <class... T>
ostream &operator<<(ostream &s, const tuple<T...> &t) {
  s << "(";
  put1<sizeof...(T), T...>::put(s, t);
  s << ")";
  return s;
}
ostream &put3(ostream &s, const char *, bool) { return s; }
template <class U, class... T>
ostream &put3(ostream &s, const char *f, bool fs, U &&u, T &&...t) {
  while (*f == ' ') ++f;
  if (!fs) s << ", ";
  auto nf = f;
  int d = 0;
  while (*nf && (*nf != ',' || d)) {
    if (*nf == '(')
      ++d;
    else if (*nf == ')')
      --d;
    ++nf;
  }
  auto nf2 = nf;
  while (nf2 > f && *(nf2 - 1) == ' ') --nf;
  fs = *f == '"';
  if (!fs) {
    s.write(f, nf2 - f);
    s << "=";
  };
  s << u;
  if (fs) s << ' ';
  if (*nf) ++nf;
  return put3(s, nf, fs, forward<T>(t)...);
}
int main(int argc, char **argv) {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.precision(20);
  srand(time(0));
  int n, m, k;
  cin >> n >> m >> k;
  vector<vector<pair<int, int>>> G(n);
  vector<int> C(n);
  vector<pair<pair<int, int>, pair<int, int>>> E;
  for (int i = 0; i < (m); ++i) {
    int a, b;
    cin >> a >> b;
    --a;
    --b;
    E.push_back(make_pair(make_pair(a, b), make_pair(((int)(G[a]).size()),
                                                     ((int)(G[b]).size()))));
    G[a].push_back(make_pair(b, 1));
    G[b].push_back(make_pair(a, 1));
    ++C[a];
    ++C[b];
  }
  vector<short> W(n);
  vector<int> Q;
  int res = n;
  auto doit = [&] {
    while (((int)(Q).size())) {
      --res;
      int v = Q.back();
      Q.pop_back();
      for (pair<int, int> p : G[v]) {
        if (p.second && !W[p.first] && --C[p.first] < k) {
          W[p.first] = 1;
          Q.push_back(p.first);
        }
      }
    }
  };
  for (int i = 0; i < (n); ++i) {
    if (C[i] < k) {
      W[i] = 1;
      Q.push_back(i);
    }
  }
  doit();
  vector<int> R;
  reverse((E).begin(), (E).end());
  for (auto e : E) {
    R.push_back(res);
    if (W[e.first.first] || W[e.first.second]) continue;
    G[e.first.first][e.second.first].second = 0;
    G[e.first.second][e.second.second].second = 0;
    if (--C[e.first.first] < k) {
      W[e.first.first] = 1;
      Q.push_back(e.first.first);
    }
    if (--C[e.first.second] < k) {
      W[e.first.second] = 1;
      Q.push_back(e.first.second);
    }
    doit();
  }
  reverse((R).begin(), (R).end());
  for (int x : R) cout << x << '\n';
  return 0;
}
