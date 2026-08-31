#include <bits/stdc++.h>
using namespace std;
unsigned seed = chrono::system_clock::now().time_since_epoch().count();
mt19937 ran(seed);
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
clock_t start = clock();
int gcd(int a, int b) { return (a == 0) ? b : gcd(b % a, a); }
int power(int a, int n) {
  int p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
    }
    n >>= 1;
    a *= a;
  }
  return p;
}
int powm(int a, int n, int mod_) {
  int p = 1;
  while (n) {
    if (n % 2) {
      p = (((p % mod_) * 1LL * (a % mod_)) % mod_);
    }
    n >>= 1;
    a = (((a % mod_) * 1LL * (a % mod_)) % mod_);
  }
  return p % mod_;
}
int powi(int a, int mod_) { return powm(a, mod_ - 2, mod_); }
map<pair<int, int>, int> dp;
int ask(int x, int y) {
  if (dp.count({x, y})) return dp[{x, y}];
  cout << "? " << x << " " << y << endl;
  int a;
  cin >> a;
  if (a == -2) exit(0);
  return dp[{x, y}] = a;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int mn, mx;
  int n, m, k, t, i, j, sum = 0, flag = 0, cnt = 0;
  int x = 0, y = 0, z, l = 0, r = 0, q;
  int TC = 1;
  while (TC--) {
    x = y = 0;
    for (i = (1 << 29); i > 0; i >>= 1) {
      l = ask(x, y);
      r = ask(x + i, y + i);
      if (l == r) {
        l = ask(x + i, y);
        if (l == -1) {
          dp[{x + i, y + i}] = dp[{x, y}];
          x += i;
          y += i;
        }
        continue;
      }
      if (r == -1)
        x += i;
      else if (r == 1)
        y += i;
    }
    cout << "! " << x << " " << y << endl;
  };
  return 0;
}
