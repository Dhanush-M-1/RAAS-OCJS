#include <bits/stdc++.h>
int xa, xb, xc, ya, yb, yc;
bool judge() {
  long long x = xc, y = yc, u = xb - xa, v = yb - ya;
  if (!u && !v) return 1;
  long long f = x * u + y * v, g = x * x + y * y;
  if (g == 0 || f % g != 0) return 0;
  long long a = f / g;
  if (x)
    f = v - a * y, g = x;
  else
    f = u, g = -y;
  if (f % g != 0) return 0;
  return 1;
}
int main() {
  scanf("%d%d%d%d%d%d", &xa, &ya, &xb, &yb, &xc, &yc);
  bool flag = 0;
  flag |= judge();
  std::swap(xb, yb), xb *= -1;
  flag |= judge();
  std::swap(xb, yb), xb *= -1;
  flag |= judge();
  std::swap(xb, yb), xb *= -1;
  flag |= judge();
  printf("%s\n", flag ? "YES" : "NO");
  return 0;
}
