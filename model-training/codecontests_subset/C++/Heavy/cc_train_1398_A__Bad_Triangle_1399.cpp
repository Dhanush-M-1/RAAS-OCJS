#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << "\n";
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
template <class T>
ostream& operator<<(ostream& os, vector<T> V) {
  os << "[ ";
  for (auto v : V) os << v << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, set<T> second) {
  os << "{ ";
  for (auto s : second) os << s << " ";
  return os << "}";
}
template <class T>
ostream& operator<<(ostream& os, unordered_set<T> second) {
  os << "{ ";
  for (auto s : second) os << s << " ";
  return os << "}";
}
template <class L, class R>
ostream& operator<<(ostream& os, pair<L, R> P) {
  return os << "(" << P.first << "," << P.second << ")";
}
template <class L, class R>
ostream& operator<<(ostream& os, map<L, R> M) {
  os << "{ ";
  for (auto m : M) os << "(" << m.first << ":" << m.second << ") ";
  return os << "}";
}
template <class L, class R>
ostream& operator<<(ostream& os, unordered_map<L, R> M) {
  os << "{ ";
  for (auto m : M) os << "(" << m.first << ":" << m.second << ") ";
  return os << "}";
}
const long long mod = 1e9 + 7;
inline long long add(long long x, long long y) {
  x += y;
  if (x >= mod) return x - mod;
  return x;
}
inline long long sub(long long x, long long y) {
  x -= y;
  if (x < 0) return x + mod;
  return x;
}
inline long long mul(long long x, long long y) { return (x * 1ll * y) % mod; }
inline long long power(long long x, long long y) {
  long long ans = 1;
  while (y) {
    if (y & 1) ans = mul(ans, x);
    x = mul(x, x);
    y >>= 1;
  }
  return ans;
}
inline long long inv(long long x) { return power(x, mod - 2); }
const long long maxn = 1e6 + 100;
const long long INF = 1e16 + 7;
const long long MXI = 2e5 + 5;
const long double PI = acos((long double)-1);
const long long xd[4] = {1, 0, -1, 0}, yd[4] = {0, 1, 0, -1};
void Code_karr_bsdk() {
  long long n, data;
  cin >> n;
  long long a, b, c;
  for (long long i = 1; i <= n; i++) {
    cin >> data;
    if (i == 1) a = data;
    if (i == 2) b = data;
    if (i == n) c = data;
  }
  if (a + b <= c)
    cout << "1 2 " << n << "\n";
  else
    cout << "-1\n";
  return;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  auto start = std::chrono::high_resolution_clock::now();
  long long t = 1;
  cin >> t;
  while (t--) {
    Code_karr_bsdk();
  }
  auto stop = std::chrono::high_resolution_clock::now();
  auto duration =
      std::chrono::duration_cast<std::chrono::nanoseconds>(stop - start);
  return 0;
}
