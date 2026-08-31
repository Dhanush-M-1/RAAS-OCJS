#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
long long power(long long x, unsigned long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) {
      res = res * x;
    }
    y = y >> 1;
    x = x * x;
  }
  return res;
}
long long powermod(long long x, unsigned long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) {
      res = (res * x) % p;
    }
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
long long min(long long a, long long b) { return a < b ? a : b; }
long long max(long long a, long long b) { return a > b ? a : b; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
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
  long long f = 0;
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
long long add(long long a, long long b) {
  return (a % 998244353 + b % 998244353) % 998244353;
}
long long mul(long long a, long long b) {
  return (a % 998244353 * b % 998244353) % 998244353;
}
long long f(vector<long long> &v, long long l) {
  long long res = 0;
  long long p = 1;
  for (long long i = 0; i < max((long long)v.size(), l); i++) {
    if (i < l) {
      p = mul(p, 10);
    }
    if (i < (long long)v.size()) {
      res = add(res, mul(v[i], p));
      p = mul(p, 10);
    }
  }
  return res;
}
long long f(long long l, vector<long long> &v) {
  long long res = 0;
  long long p = 1;
  for (long long i = 0; i < max((long long)v.size(), l); i++) {
    if (i < (long long)v.size()) {
      res = add(res, mul(v[i], p));
      p = mul(p, 10);
    }
    if (i < l) {
      p = mul(p, 10);
    }
  }
  return res;
}
void snow() {
  long long n;
  cin >> n;
  long long arr[n];
  long long maxd[20];
  for (long long i = 0; i < 20; i++) {
    maxd[i] = 0;
  }
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
    long long x = arr[i];
    long long l = 0;
    while (x) {
      ++l;
      x /= 10;
    }
    maxd[l]++;
  }
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    long long x = arr[i];
    long long l = 0;
    vector<long long> v;
    while (x) {
      v.push_back(x % 10);
      x /= 10;
      l++;
    }
    for (long long j = 1; j <= 11; j++) {
      long long sum = f(v, j);
      ans = add(ans, mul(sum, maxd[j]));
      sum = f(j, v);
      ans = add(ans, mul(sum, maxd[j]));
    }
  }
  cout << ans << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long t;
  t = 1;
  while (t--) snow();
  return 0;
}
