#include <bits/stdc++.h>
using namespace std;
long long x[3], y[3];
bool ok(long long a, long long b) {
  if (b < 0) b = -b;
  if (b == 0) {
    return a == 0;
  }
  return a % b == 0;
}
bool check(long long xx, long long yy) {
  long long ex = x[1] - xx;
  long long ey = y[1] - yy;
  long long dx = x[2];
  long long dy = y[2];
  if (dx == 0 && dy == 0 && (ex != 0 || ey != 0)) return false;
  if (ok(ex * dx + ey * dy, dx * dx + dy * dy) &&
      ok(ex * dy - ey * dx, dy * dy + dx * dx)) {
    return true;
  }
  return false;
}
bool work() {
  if (check(x[0], y[0]) || check(-y[0], x[0]) || check(-x[0], -y[0]) ||
      check(y[0], -x[0]))
    return true;
  return false;
}
int main() {
  for (int i = 0; i < 3; i++) {
    scanf("%I64d%I64d", &x[i], &y[i]);
  }
  puts(work() ? "YES" : "NO");
  return 0;
}
