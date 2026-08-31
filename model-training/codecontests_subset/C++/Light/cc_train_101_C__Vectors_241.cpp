#include <bits/stdc++.h>
long long a, b, c, d, e, f, i = 4, r, z, x, y;
int main() {
  std::cin >> a >> b >> c >> d >> e >> f;
  for (z = f * f + e * e; i--; x = c - a, y = d - (b = -b),
      r |= (!z && !x && !y) | (z && !((x * e + y * f) % z) &&
                               !((y * e - x * f) % z)))
    std::swap(a, b);
  puts(r ? "YES" : "NO");
}
