#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:64000000")
using namespace std;
long long x1, botva, x2, y2, x3, y3;
void sw(long long &x, long long &y) {
  swap(x, y);
  y *= (-1);
}
long long abs1(long long a) {
  if (a < 0) return -a;
  return a;
}
bool f(long long x, long long y, long long k1, long long k2) {
  if (x * x + y * y == 0) return (k1 == 0 && k2 == 0);
  return ((abs1(k2 * x - k1 * y) % (x * x + y * y)) == 0 &&
          (abs1(k1 * x + k2 * y) % (x * x + y * y)) == 0);
}
int main() {
  cin >> x1 >> botva >> x2 >> y2 >> x3 >> y3;
  bool q = false;
  for (int i = 0; i < int(4); i++) {
    q |= f(x3, y3, x2 - x1, y2 - botva);
    sw(x2, y2);
  }
  if (!q)
    printf("NO");
  else
    printf("YES");
  return 0;
}
