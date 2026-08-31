#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;
using ll = long long;
using ld = long double;
int ctoi(const char c) {
  if ('0' <= c && c <= '9') return (c - '0');
  return -1;
}
ll gcd(ll a, ll b) { return (b == 0 ? a : gcd(b, a % b)); }
ll lcm(ll a, ll b) { return a * b / gcd(a, b); }
constexpr ll MOD = 1000000007;
constexpr ll INF = 1000000011;
constexpr ll MOD2 = 998244353;
constexpr ll LINF = 1001002003004005006ll;
constexpr ld EPS = 10e-8;
template <class T>
bool chmax(T& a, const T& b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T& a, const T& b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T>
istream& operator>>(istream& is, vector<T>& v) {
  for (auto&& x : v) is >> x;
  return is;
}
template <typename T, typename U>
istream& operator>>(istream& is, pair<T, U>& p) {
  is >> p.first;
  is >> p.second;
  return is;
}
template <typename T, typename U>
ostream& operator>>(ostream& os, const pair<T, U>& p) {
  os << p.first << ' ' << p.second;
  return os;
}
template <class T>
ostream& operator<<(ostream& os, vector<T>& v) {
  for (auto i = begin(v); i != end(v); ++i) {
    if (i != begin(v)) os << ' ';
    os << *i;
  }
  return os;
}
int main() {
  ll T, A, B, C, ans = 0;
  cin >> T;
  for (ll i = 0; i < (T); ++i) {
    ans = 0;
    cin >> A >> B >> C;
    ans += min(B, C / 2) * 3;
    B -= min(B, C / 2);
    ans += min(A, B / 2) * 3;
    cout << ans << '\n';
  }
}
