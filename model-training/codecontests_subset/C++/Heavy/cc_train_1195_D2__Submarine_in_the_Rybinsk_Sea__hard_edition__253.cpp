#include <bits/stdc++.h>
const double pi = acos(-1.0);
using namespace std;
inline long long MAX2(long long a, long long b) {
  return (a) > (b) ? (a) : (b);
}
inline long long MAX3(long long a, long long b, long long c) {
  return (a) > (b) ? ((a) > (c) ? (a) : (c)) : ((b) > (c) ? (b) : (c));
}
inline long long MIN2(long long a, long long b) {
  return (a) < (b) ? (a) : (b);
}
inline long long MIN3(long long a, long long b, long long c) {
  return (a) < (b) ? ((a) < (c) ? (a) : (c)) : ((b) < (c) ? (b) : (c));
}
const int MAX = 2e5 + 10;
const int mod = 998244353;
int64_t extGcd(int64_t a, int64_t b, int64_t& x, int64_t& y) {
  if (!a) {
    x = 0;
    y = 1;
    return b;
  }
  int64_t x1, y1;
  int64_t d = extGcd(b % a, a, x1, y1);
  x = y1 - (b / a) * x1;
  y = x1;
  return d;
}
inline long long addmod(long long a, long long b) {
  a = a % mod + b % mod;
  if (a > mod) a %= mod;
  return a;
}
inline long long submod(long long a, long long b) {
  a = a % mod - b % mod;
  if (a < 0) a += mod;
  return a;
}
inline long long mulmod(long long a, long long b) {
  return (a % mod * b % mod) % mod;
}
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
inline long long exp(long long a, long long b) {
  if (a == 0) return 0ll;
  long long r = 1LL;
  while (b > 0) {
    if (b & 1) {
      r = r * (a % mod);
      r = (r + mod) % mod;
    }
    b /= 2;
    a = (a % mod) * (a % mod);
    a = (a + mod) % mod;
  }
  return (r + mod) % mod;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  if (a == 0) return b;
  return gcd(b, a % b);
}
unsigned long int setbits(long long n) {
  unsigned long int count = 0;
  while (n) {
    n &= (n - 1);
    count++;
  }
  return count;
}
int n;
vector<long long> g1;
map<int, int> m1;
vector<long long> pw(21, 0);
int max_len;
long long contri_odd(string s, int l) {
  long long res = 0;
  int id = 0;
  for (int i = 0; i < MIN2(s.size(), l); i++) {
    res = addmod(res, mulmod(s[i] - '0', pw[id]));
    id += 2;
  }
  for (int i = MIN2(s.size(), l); i < s.size(); i++) {
    res = addmod(res, mulmod(s[i] - '0', pw[id]));
    id++;
  }
  return res;
}
long long contri_even(string s, int l) {
  long long res = 0;
  int id = 1;
  for (int i = 0; i < MIN2(s.size(), l); i++) {
    res = addmod(res, mulmod(s[i] - '0', pw[id]));
    id += 2;
  }
  id--;
  for (int i = MIN2(s.size(), l); i < s.size(); i++) {
    res = addmod(res, mulmod(s[i] - '0', pw[id]));
    id++;
  }
  return res;
}
int main() {
  if (fopen("input.txt", "r"))
    freopen("input.txt", "r", stdin), freopen("output.txt", "w", stdout);
  ;
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  g1 = vector<long long>(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> g1[i];
    m1[to_string(g1[i]).size()]++;
    max_len = MAX2(to_string(g1[i]).size(), max_len);
  }
  int sz = 21;
  pw[0] = 1;
  for (int i = 1; i < pw.size(); i++) pw[i] = mulmod(10, pw[i - 1]);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    string s = to_string(g1[i]);
    reverse(s.begin(), s.end());
    for (int j = 1; j <= max_len; j++) {
      long long res = mulmod(m1[j], contri_odd(s, j));
      ans = addmod(res, ans);
      res = mulmod(m1[j], contri_even(s, j));
      ans = addmod(res, ans);
    }
  }
  cout << ans << '\n';
  return 0;
}
