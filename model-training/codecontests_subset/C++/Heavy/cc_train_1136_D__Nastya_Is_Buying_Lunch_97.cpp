#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
std ::chrono ::high_resolution_clock::time_point t1 =
    std ::chrono ::high_resolution_clock ::now();
double dur_() {
  std ::chrono ::high_resolution_clock::time_point t2 =
      std ::chrono ::high_resolution_clock ::now();
  std ::chrono ::duration<double> time_span =
      std ::chrono ::duration_cast<std ::chrono ::duration<double>>(t2 - t1);
  return time_span.count();
}
using namespace std;
template <typename T1, typename T2>
ostream &operator<<(ostream &out, const pair<T1, T2> &p) {
  out << p.first << ' ' << p.second;
  return out;
}
template <typename T1>
ostream &operator<<(ostream &out, const vector<T1> &v) {
  for (auto it : v) out << it << ' ';
  return out;
}
template <typename T1, typename T2>
istream &operator>>(istream &in, pair<T1, T2> &p) {
  in >> p.first >> p.second;
  return in;
}
template <typename T>
void cinv(vector<T> &v, size_t n, istream &in) {
  for (size_t i = 0; i < n; i++) {
    T x;
    in >> x;
    v.push_back(x);
  }
}
inline void read(long long &x) {
  char ch;
  while (1) {
    ch = getchar();
    if (ch > '9' | ch < '0') return;
    x *= 10;
    x = x + ch - '0';
  }
}
inline void out(long long x) {
  char buff[20];
  size_t sizel = 0;
  for (; x > 0; x /= 10, sizel++) buff[sizel] = x % 10 + '0';
  for (long long i = sizel - 1; i >= 0; i--) putchar(buff[i]);
  return;
}
struct cmp {
  bool f = 1;
  template <class T>
  inline bool operator()(T x, T y) {
    return x < y ? f : !f;
  }
  inline void setcmp(bool x) { f = x; }
};
const long long N = 3 * 1e5 + 1;
const long long M = 1e3 + 1;
const long long inf = INFINITY;
using namespace std;
long long n, m;
long long a[N];
vector<long long> cur;
signed main() {
  ios_base ::sync_with_stdio(NULL);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  for (long long i = 0; i < n; ++i) {
    cin >> a[i];
  }
  cur.push_back(a[n - 1]);
  map<pair<long long, long long>, char> mp;
  for (long long i = 0; i < m; ++i) {
    long long x, y;
    cin >> x >> y;
    mp[{x, y}] = 1;
  }
  bool f = 0;
  for (long long i = n - 2; i >= 0; --i) {
    f = 0;
    long long pos = cur.size();
    for (long long j = 0; j < pos; ++j) {
      if (mp[{a[i], cur[j]}] == 0) {
        f = 1;
        break;
      }
    }
    if (f == true) cur.push_back(a[i]);
  }
  cout << n - cur.size();
  return 0;
}
