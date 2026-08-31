#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:33554432")
using namespace std;
const double PI = 2 * acos(0.0);
const double EPS = 1e-8;
const int INF = (1 << 30) - 1;
long long x0, yyyyy0, x1, yyyyy1, x, y;
bool can(long long x0, long long yyyyy0, long long x, long long y) {
  long long n = ((x0 * x + yyyyy0 * y) >= 0 ? (x0 * x + yyyyy0 * y)
                                            : -(x0 * x + yyyyy0 * y));
  ;
  long long d = x * x + y * y;
  if (d == 0) {
    return (x0 == 0 && yyyyy0 == 0);
  };
  if (n % d > 0) return false;
  n = ((x0 * y - yyyyy0 * x) >= 0 ? (x0 * y - yyyyy0 * x)
                                  : -(x0 * y - yyyyy0 * x));
  ;
  if (n % d > 0) return false;
  return true;
};
int main() {
  cin >> x0 >> yyyyy0 >> x1 >> yyyyy1 >> x >> y;
  for (int i = 0; i < 4; ++i) {
    if (can(x1 - x0, yyyyy1 - yyyyy0, x, y)) {
      cout << "YES";
      return 0;
    };
    long long tx, ty;
    tx = yyyyy1;
    ty = -x1;
    x1 = tx;
    yyyyy1 = ty;
  };
  cout << "NO";
  return 0;
};
