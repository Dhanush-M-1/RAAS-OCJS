#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool setmin(T &a, T b) {
  if (a > b) return a = b, 1;
  return 0;
}
template <class T>
inline bool setmax(T &a, T b) {
  if (a < b) return a = b, 1;
  return 0;
}
template <class T>
inline T fast(T a, T b, T mod) {
  long long res = 1;
  while (b) {
    if (b & 1) res = (res * a) % mod;
    a = (a * a) % mod;
    b >>= 1;
  }
  return res;
}
template <class T>
inline T russian(T a, T b, T mod) {
  long long res = 0;
  while (b) {
    if (b & 1) res = (res + a) % mod;
    a = (a + a) % mod;
    b >>= 1;
  }
  return res;
}
template <class T>
inline T sub(T a, T b, T mod) {
  return ((a % mod - b % mod) + mod) % mod;
}
template <class T>
inline T add(T a, T b, T mod) {
  return (a % mod + b % mod) % mod;
}
template <class T>
inline T mult(T a, T b, T mod) {
  return ((a % mod * b % mod) + mod) % mod;
}
template <class T>
inline T mult(vector<T> vec, T mod) {
  T ret = 1;
  for (int i = 0; i < (int)(vec).size(); i++) ret = (ret * vec[i]) % mod;
  return ret;
}
template <class T>
istream &operator>>(istream &os, vector<T> &container) {
  for (auto &u : container) os >> u;
  return os;
}
template <class T>
ostream &operator<<(ostream &os, const vector<T> &container) {
  for (auto &u : container) os << u << " ";
  return os;
}
template <typename T>
inline T gcd(T a, T b) {
  while (b) swap(a %= b, b);
  return a;
}
long double PI = acos(-1);
long double eps = 1e-11;
const long long T = 1 << 14;
const long long INF = 1e9 + 7;
const long long MOD = 998244353;
const long long BIG_INF = 1e18 + 7;
const long long N = 1e6 + 7;
const long long M = 2007;
long long n, m, k;
long long ile[11];
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  vector<string> tab;
  for (int i = 0; i < n; i++) {
    string temp;
    cin >> temp;
    reverse((temp).begin(), (temp).end());
    tab.push_back(temp);
    ile[(int)(temp).size()]++;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 10; j++) {
      long long mnoz = 10;
      for (int l = 0; l < (int)(tab[i]).size(); l++) {
        ans = (ans + (mnoz * (tab[i][l] - '0')) * ile[j]) % MOD;
        if (l + 1 >= j) {
          mnoz = (mnoz * 10) % MOD;
        } else {
          mnoz = (mnoz * 100) % MOD;
        }
      }
    }
    for (int j = 1; j <= 10; j++) {
      long long mnoz = 1;
      for (int l = 0; l < (int)(tab[i]).size(); l++) {
        ans = (ans + (mnoz * (tab[i][l] - '0')) * ile[j]) % MOD;
        if (l + 1 > j) {
          mnoz = (mnoz * 10) % MOD;
        } else {
          mnoz = (mnoz * 100) % MOD;
        }
      }
    }
  }
  cout << ans % MOD;
}
