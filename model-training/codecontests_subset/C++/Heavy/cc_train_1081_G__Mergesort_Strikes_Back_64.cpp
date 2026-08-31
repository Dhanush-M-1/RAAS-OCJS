#include <bits/stdc++.h>
using namespace std;
int n, k, mo;
int n1, n2, len, ans = 0;
int Sum(int x, int y) {
  x += y;
  return (x >= mo) ? x - mo : x;
}
int Sub(int x, int y) {
  x -= y;
  return (x < 0) ? x + mo : x;
}
int Mul(int x, int y) { return (long long)x * y % mo; }
int Pow(int x, int y = mo - 2) {
  int z = 1;
  while (y) {
    if (y & 1) z = Mul(z, x);
    y >>= 1;
    x = Mul(x, x);
  }
  return z;
}
int C(int x) { return Mul(x, Mul(x - 1, (mo + 1) / 2)); }
namespace task1 {
int Calc(int x) { return Mul((mo + 1) / 2, C(x)); }
}  // namespace task1
namespace task2 {
int Calc(int x, int y) {
  int ans = Mul(x, y);
  for (int i = 2; i <= x + y; i++) {
    int l = max(1, i - y);
    int r = min(x, i - 1);
    if (l <= r) ans = Sub(ans, Mul(Pow(i), (r - l + 1) * 2));
  }
  return Mul(ans, (mo + 1) / 2);
}
}  // namespace task2
int main() {
  scanf("%d%d%d", &n, &k, &mo);
  if (k > 30) {
    len = 0;
    n2 = n;
    n1 = 0;
  } else {
    len = n / (1 << (k - 1));
    n2 = n - len * (1 << (k - 1));
    n1 = (1 << (k - 1)) - n2;
  }
  ans = Sum(ans, Mul(n1, task1::Calc(len)));
  ans = Sum(ans, Mul(n2, task1::Calc(len + 1)));
  ans = Sum(ans, Mul(C(n1), task2::Calc(len, len)));
  ans = Sum(ans, Mul(C(n2), task2::Calc(len + 1, len + 1)));
  ans = Sum(ans, Mul(Mul(n1, n2), task2::Calc(len, len + 1)));
  printf("%d\n", ans);
  return 0;
}
