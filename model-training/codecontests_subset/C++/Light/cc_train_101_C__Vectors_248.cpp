#include <bits/stdc++.h>
long long a, b, x, y, p, q, d;
long long c(long long a, long long b) {
  d = p * p + q * q;
  if (d == 0) return a == 0 && b == 0;
  return (a * p + b * q) % d == 0 && (b * p - a * q) % d == 0;
}
int main() {
  std::cin >> a >> b >> x >> y >> p >> q;
  std::cout << (c(a - x, b - y) || c(a + x, b + y) || c(a - y, b + x) ||
                        c(a + y, b - x)
                    ? "YES"
                    : "NO");
}
