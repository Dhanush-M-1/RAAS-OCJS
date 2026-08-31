#include <bits/stdc++.h>
using namespace std;
template <class T>
T abs(T x) {
  return x > 0 ? x : (-x);
}
template <class T>
T sqr(T x) {
  return x * x;
}
long long x3982098543, y3982098543, x2, y2, x3, y3;
bool check(long long X, long long Y) {
  long long d = sqr(x3) + sqr(y3);
  long long dx = X * x3 + Y * y3;
  long long dy = x3 * Y - y3 * X;
  if (d == 0) {
    if (dx == 0 && dy == 0 && X == 0 && Y == 0)
      return true;
    else
      return false;
  } else {
    if (dx % d == 0 && dy % d == 0)
      return true;
    else
      return false;
  }
}
int main() {
  cin >> x3982098543 >> y3982098543 >> x2 >> y2 >> x3 >> y3;
  for (int it = 0; it < 8; ++it) {
    long long X = x2 - x3982098543, Y = y2 - y3982098543;
    if (check(X, Y)) {
      printf("YES\n");
      return 0;
    }
    long long x = y3982098543, y = -x3982098543;
    x3982098543 = x, y3982098543 = y;
  }
  printf("NO\n");
  return 0;
}
