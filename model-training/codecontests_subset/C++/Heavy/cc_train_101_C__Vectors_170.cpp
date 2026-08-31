#include <bits/stdc++.h>
using namespace std;
int T;
long long xa, xb, xc, ya, yb, yc;
long long dx, dy;
bool gao(long long xc, long long yc) {
  if (xc == 0 && yc == 0) return false;
  return (dx * xc + dy * yc) % (xc * xc + yc * yc) == 0;
}
bool check(long long xa, long long ya) {
  dx = xb - xa;
  dy = yb - ya;
  if (dx == 0 && dy == 0) return true;
  return gao(xc, yc) && gao(-yc, xc);
}
bool judge() {
  if (check(xa, ya)) return true;
  if (check(-ya, xa)) return true;
  if (check(-xa, -ya)) return true;
  if (check(ya, -xa)) return true;
  return false;
}
int main() {
  scanf("%lld%lld%lld%lld%lld%lld", &xa, &ya, &xb, &yb, &xc, &yc);
  printf("%s\n", judge() ? "YES" : "NO");
  return 0;
}
