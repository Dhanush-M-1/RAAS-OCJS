#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
const double eps = 1e-9;
const double pi = acos(-1.0);
const double dinf = 1e250;
const long long INF = static_cast<long long>(2e18);
const int inf = static_cast<int>(1e9 + 7);
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
template <class T>
void OUT(T a) {
  cout << a;
  exit(0);
}
template <typename T>
inline bool amax(T& a, T b) {
  if (b > a) {
    a = b;
    return true;
  }
  return false;
}
template <typename T>
inline bool amin(T& a, T b) {
  if (b < a) {
    a = b;
    return true;
  }
  return false;
}
mt19937 rng(static_cast<uint32_t>(
    chrono::steady_clock::now().time_since_epoch().count()));
chrono::time_point<chrono::steady_clock> cl;
double current_time() {
  return (chrono::steady_clock::now() - cl).count() / 1e9;
}
int c = 0;
int d = 0;
int bit;
int cur;
int go(int cc, int dd) {
  int resp;
  cout << "? " << c + (cc << bit) << " " << d + (dd << bit) << endl;
  cin >> resp;
  return resp;
}
void ch(int cc, int dd) {
  c += (cc << bit);
  d += (dd << bit);
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cout << fixed << setprecision(10);
  cl = chrono::steady_clock::now();
  cin.tie(0);
  int ord = go(0, 0);
  for (bit = 29; bit >= 0; --bit) {
    cur = go(1, 1);
    if (cur == 0) {
      int tmp = go(1, 0);
      if (tmp == -1) ch(1, 1);
      if (tmp == 1) ch(0, 0);
    } else if (ord == cur) {
      if (ord == 1) cur = go(0, 1);
      if (ord == -1) cur = go(1, 0);
      if (cur == ord) ch(1, 1);
    } else {
      if (ord == -1)
        ord = go(1, 0), ch(0, 1);
      else if (ord == 1)
        ord = go(0, 1), ch(1, 0);
    }
  }
  cout << "! " << c << " " << d;
  return 0;
}
