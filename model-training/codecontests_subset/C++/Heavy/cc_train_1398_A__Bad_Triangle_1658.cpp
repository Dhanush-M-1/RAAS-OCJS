#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int f = 0;
  cerr << '{';
  for (auto &i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
long long binpow(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = (res * x);
    y = y >> 1;
    x = (x * x);
  }
  return res;
}
long long binpowmod(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long mod_inverse(long long n, long long p) {
  return binpowmod(n, p - 2, p);
}
long long gcd(long long x, long long y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
bool comp_pairs_by_s(pair<long long, long long> &x,
                     pair<long long, long long> &y) {
  return x.second < y.second;
}
bool isPowerOfTwo(long long x) { return x && (!(x & (x - 1))); }
class cmp {
 public:
  bool operator()(pair<int, int> A, pair<int, int> B) {
    if (abs(A.first - A.second) == abs(B.first - B.second))
      return A.first > B.first;
    return abs(A.first - A.second) < abs(B.first - B.second);
  }
};
void swap(long long &x, long long &y) {
  int temp = x;
  x = y;
  y = temp;
}
unsigned int onesComplement(unsigned int n) {
  int number_of_bits = floor(log2(n)) + 1;
  return ((1 << number_of_bits) - 1) ^ n;
}
bool comp(pair<long long, long long> x, pair<long long, long long> y) {
  return x.second < y.second;
}
bool comp1(pair<long long, long long> x, pair<long long, long long> y) {
  return x.second < y.second;
}
void selfmin(int &x, int y) { x = min(x, y); }
void solve() {
  int n;
  cin >> n;
  vector<long long> a(n);
  for (auto &it : a) cin >> it;
  if (a[0] + a[1] > a[n - 1])
    cout << -1;
  else {
    cout << 1 << ' ' << 2 << ' ' << n;
  }
  cout << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) solve();
}
