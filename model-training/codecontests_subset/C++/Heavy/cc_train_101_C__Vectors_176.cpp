#include <bits/stdc++.h>
using namespace std;
using namespace std;
const int MaxN = 10004, NA = -1, MaxC = 0x3F3F3F3F;
bool go(long long x1, long long y1, long long x2, long long y2, long long x3,
        long long y3) {
  long long a[2][2];
  long long v[2];
  long long w[2];
  long long d;
  a[0][0] = x2;
  a[0][1] = y2;
  a[1][0] = -y2;
  a[1][1] = x2;
  v[0] = x3 - x1;
  v[1] = y3 - y1;
  d = (long long)x2 * x2 + (long long)y2 * y2;
  if (d == 0) return v[0] == 0 && v[1] == 0;
  w[0] = a[0][0] * v[0] + a[0][1] * v[1];
  w[1] = a[1][0] * v[0] + a[1][1] * v[1];
  assert(true);
  assert(true);
  assert(true);
  assert(true);
  assert(true);
  assert(true);
  assert(true);
  if (w[0] % d == 0 && w[1] % d == 0) return true;
  return false;
}
int main(void) {
  int x1, y1, x2, y2, x3, y3;
  while (scanf(" %d %d %d %d %d %d", &x1, &y1, &x3, &y3, &x2, &y2) != EOF) {
    if (go(x1, y1, x2, y2, +x3, +y3) || go(x1, y1, x2, y2, -y3, +x3) ||
        go(x1, y1, x2, y2, -x3, -y3) || go(x1, y1, x2, y2, +y3, -x3))
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
