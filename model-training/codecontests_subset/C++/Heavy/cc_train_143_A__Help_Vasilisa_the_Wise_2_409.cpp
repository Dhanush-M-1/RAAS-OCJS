#include <bits/stdc++.h>
using namespace std;
template <class T>
T Multiply(T a, T b) {
  return a * b;
}
template <class T>
T larger(T a, T b) {
  return (a > b ? a : b);
}
template <class T>
T smaller(T a, T b) {
  return (a < b ? a : b);
}
template <class T>
T gcd(T a, T b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
template <class T>
T lcm(T a, T b) {
  return (a * b) / gcd(a, b);
}
template <class T>
string converter(T n) {
  stringstream x;
  x << n;
  return x.str();
}
template <class T1>
void deb(T1 e1) {
  cout << e1 << endl;
}
template <class T1, class T2>
void deb(T1 e1, T2 e2) {
  cout << e1 << " " << e2 << endl;
}
template <class T1, class T2, class T3>
void deb(T1 e1, T2 e2, T3 e3) {
  cout << e1 << " " << e2 << " " << e3 << endl;
}
template <class T1, class T2, class T3, class T4>
void deb(T1 e1, T2 e2, T3 e3, T4 e4) {
  cout << e1 << " " << e2 << " " << e3 << " " << e4 << endl;
}
template <class T1, class T2, class T3, class T4, class T5>
void deb(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5) {
  cout << e1 << " " << e2 << " " << e3 << " " << e4 << " " << e5 << endl;
}
template <class T1, class T2, class T3, class T4, class T5, class T6>
void deb(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5, T6 e6) {
  cout << e1 << " " << e2 << " " << e3 << " " << e4 << " " << e5 << " " << e6
       << endl;
}
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& a) {
  in >> a.first >> a.set<char>;
  return in;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& out, pair<T1, T2> a) {
  out << a.first << " " << a.set<char>;
  return out;
}
template <typename T, typename T1>
T amax(T& a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T& a, T1 b) {
  if (b < a) a = b;
  return a;
}
const long long INF = 1e18;
const int32_t M = 1e9 + 7;
const int32_t MM = 998244353;
void setIO(string s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
void solve() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d %d\n%d %d\n%d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int a = 9; a > 0; a--) {
    for (int b = 9; b > 0; b--) {
      for (int c = 9; c > 0; c--) {
        for (int d = 9; d > 0; d--) {
          if (a != b && a != c && a != d && b != c && b != d && c != d &&
              r1 == a + b && r2 == c + d && c1 == a + c && c2 == b + d &&
              d1 == a + d && d2 == b + c) {
            printf("%d %d\n%d %d\n", a, b, c, d);
            return;
          }
        }
      }
    }
  }
  deb(-1);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
