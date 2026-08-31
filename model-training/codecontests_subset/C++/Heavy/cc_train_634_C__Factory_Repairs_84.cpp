#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T SQR(T x) {
  return x * x;
}
template <typename T>
inline T MIN(T x, T y) {
  return (x < y) ? x : y;
}
template <typename T>
inline T MAX(T x, T y) {
  return (x > y) ? x : y;
}
template <typename T>
inline T ABS(T x) {
  return (x > 0) ? x : -x;
}
template <typename T>
inline void UPDATE_MIN(T &x, T y) {
  if (y < x) {
    x = y;
  }
}
template <typename T>
inline void UPDATE_MAX(T &x, T y) {
  if (x < y) {
    x = y;
  }
}
template <typename T>
inline int ARGMAX(T cont) {
  return max_element(cont.begin(), cont.end()) - cont.begin();
}
template <typename T>
inline int ARGMIN(T cont) {
  return min_element(cont.begin(), cont.end()) - cont.begin();
}
vector<string> split(const string &s, char c) {
  vector<string> v;
  stringstream ss(s);
  string x;
  while (getline(ss, x, c)) v.emplace_back(x);
  return move(v);
}
template <typename T, typename... Args>
inline string arrStr(T arr, int n) {
  stringstream s;
  s << "[";
  for (__typeof(n - 1) i = (0), __tmpvar__end87 = (n - 1); i < __tmpvar__end87;
       i++)
    s << arr[i] << ",";
  s << arr[n - 1] << "]";
  return s.str();
}
template <class T>
inline string TOSTR(const T &x) {
  stringstream ss;
  ss << x;
  return ss.str();
}
inline int gcd(int a, int b) { return a ? gcd(b % a, a) : b; }
inline long long gcd(long long a, long long b) { return a ? gcd(b % a, a) : b; }
inline long long powmod(long long a, long long p, long long m) {
  long long r = 1;
  while (p) {
    if (p & 1) r = r * a % m;
    p >>= 1;
    a = a * a % m;
  }
  return r;
}
struct pairhash {
  template <typename T, typename U>
  std::size_t operator()(const std::pair<T, U> &x) const {
    return std::hash<T>()(x.first) ^ std::hash<U>()(x.second);
  }
};
template <typename K, typename V>
V GetWithDef(const std::unordered_map<K, V> &m, const K &key, const V &defval) {
  auto it = m.find(key);
  return (it == m.end()) ? defval : it->second;
}
template <typename K, typename V>
void SetDef(std::unordered_map<K, V> &m, const K &key, const V &defval) {
  auto it = m.find(key);
  if (it == m.end()) m[key] = defval;
}
const int MOD = 1000 * 1000 * 1000 + 7;
const double PI = 3.1415926535897932384626433832795l;
inline void addto(int &a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
}
inline int add(int a, int b) {
  a += b;
  if (a >= MOD) a -= MOD;
  return a;
}
inline void subto(int &a, int b) {
  a -= b;
  if (a < 0) a += MOD;
  if (a >= MOD) a -= MOD;
}
inline int sub(int a, int b) {
  a -= b;
  if (a < 0) a += MOD;
  if (a >= MOD) a -= MOD;
  return a;
}
inline void multo(int &a, int b) { a = (long long)a * b % MOD; }
inline int mul(int a, int b) { return (long long)a * b % MOD; }
inline int mulmod(int a, int b, int mod) { return (long long)a * b % mod; }
inline int powmod(int a, int e, int mod) {
  int x;
  for (x = 1; e > 0; e >>= 1) {
    if (e & 1) x = mulmod(x, a, mod);
    a = mulmod(a, a, mod);
  }
  return x;
}
inline int invmod(int a, int mod) { return powmod(a, mod - 2, mod); }
inline long long invmodLL(long long p) {
  long long q = p;
  for (long long a = p * p; a != 1; a *= a) q *= a;
  return q;
}
int N, K, A, B, Q;
struct BIT {
  vector<long long> bit;
  int N;
  void init(int N) {
    this->N = N;
    bit.assign(N + 1, 0);
  }
  void add_to_i(int x, long long val) {
    for (; x <= N; x += x & -x) bit[x] += val;
  }
  void set_i(int x, long long val) { add_to_i(x, val - get(x)); }
  long long sum_prefix(int x) {
    long long sum = 0;
    for (; x > 0; x -= x & -x) sum += bit[x];
    return sum;
  }
  long long sum_range(int l, int r) {
    if (l > r) return 0;
    return sum_prefix(r) - sum_prefix(l - 1);
  }
  long long get(int i) { return sum_range(i, i); }
};
BIT limb;
BIT lima;
int main() {
  ios_base::sync_with_stdio(0);
  scanf("%d%d", &N, &K);
  scanf("%d%d%d", &A, &B, &Q);
  lima.init(N);
  limb.init(N);
  for (__typeof(Q) i = (0), __tmpvar__end246 = (Q); i < __tmpvar__end246; i++) {
    int typ;
    scanf("%d", &typ);
    if (typ == 1) {
      int d, a;
      scanf("%d%d", &d, &a);
      lima.add_to_i(d, a);
      if (lima.get(d) > A) lima.set_i(d, A);
      limb.add_to_i(d, a);
      if (limb.get(d) > B) limb.set_i(d, B);
    } else {
      assert(typ == 2);
      int p;
      scanf("%d", &p);
      long long ans = 0;
      if (p > 1) ans += limb.sum_prefix(p - 1);
      if (p + K <= N) ans += lima.sum_range(p + K, N);
      printf("%lld\n", ans);
    }
  }
  return 0;
}
