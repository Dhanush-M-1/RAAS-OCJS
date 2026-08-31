#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:60000000")
using namespace std;
const long double eps = 1e-10;
const int inf = (1 << 30) - 1;
const long long inf64 = ((long long)1 << 62) - 1;
const long double pi = 3.1415926535897932384626433832795;
template <class T>
T sqr(T first) {
  return first * first;
}
pair<long long, long long> A, B, C;
pair<long long, long long> operator-(pair<long long, long long> p1,
                                     pair<long long, long long> p2) {
  return pair<long long, long long>(p1.first - p2.first, p1.second - p2.second);
}
pair<long long, long long> rotate(pair<long long, long long> first) {
  return pair<long long, long long>(-first.second, first.first);
}
pair<long double, long double> rotate(pair<long double, long double> p,
                                      long double ang) {
  return pair<long double, long double>(
      p.first * cosl(ang) - p.second * sinl(ang),
      p.first * sinl(ang) + p.second * cosl(ang));
}
bool integer(long double first) {
  long double X = floorl(first + 0.1);
  if (fabsl(first - X) < eps) return 1;
  return 0;
}
bool check(pair<long long, long long> A, pair<long long, long long> B) {
  if (B == pair<long long, long long>(0, 0)) return 1;
  if (A == pair<long long, long long>(0, 0)) return 0;
  pair<long double, long double> a =
      pair<long double, long double>(A.first, A.second);
  long double ang = atan2l(a.second, a.first);
  long double d = sqrtl((long double)(A.first * A.first + A.second * A.second));
  pair<long double, long double> b =
      rotate(pair<long double, long double>(B.first, B.second), -ang);
  b.first /= d;
  b.second /= d;
  b.first = fabsl(b.first);
  b.second = fabsl(b.second);
  if (integer(b.first) && integer(b.second)) return 1;
  return 0;
}
int main() {
  cin >> A.first >> A.second;
  cin >> B.first >> B.second;
  cin >> C.first >> C.second;
  for (int i = 0; i < (int)(4); i++) {
    pair<long long, long long> D = B - A;
    if (check(C, D)) {
      cout << "YES\n";
      return 0;
    }
    A = rotate(A);
  }
  cout << "NO\n";
  return 0;
}
