#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LLINF = 0x3f3f3f3f3f3f3f3fll;
const double DINF = 1.0 / 0.0f;
const double pi = acos(-1.0);
const double eps = 1e-8;
inline int LC(int x) { return x << 1; }
inline int RC(int x) { return (x << 1) | 1; }
inline bool eq0(double x) { return fabs(x) < eps; }
inline bool eq(double x, double y) { return fabs(x - y) < eps; }
inline bool ls(double x, double y) { return x + eps < y; }
inline bool gr(double x, double y) { return x - eps > y; }
inline bool greq(double x, double y) { return x + eps >= y; }
inline bool lseq(double x, double y) { return x - eps <= y; }
inline double fmax(double x, double y) { return gr(x, y) ? x : y; }
inline double fmin(double x, double y) { return ls(x, y) ? x : y; }
template <class T>
inline T sqr(T x) {
  return x * x;
}
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    cout << a * c / b + (a * c % b != 0) - c << endl;
  }
  return 0;
}
