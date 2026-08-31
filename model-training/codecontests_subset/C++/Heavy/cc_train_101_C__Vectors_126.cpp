#include <bits/stdc++.h>
int main() {
  std::ios_base::sync_with_stdio(false);
  int64_t a1, a2, b1, b2, c1, c2, D, m[4], n[4];
  std::cin >> a1 >> a2 >> b1 >> b2 >> c1 >> c2;
  if (c1 == 0 && c2 == 0) {
    if ((a1 == b1 && a2 == b2) || (a1 == -b1 && a2 == -b2) ||
        (a1 == b2 && a2 == -b1) || (a1 == -b2 && a2 == b1))
      std::cout << "YES" << std::endl;
    else
      std::cout << "NO" << std::endl;
    return 0;
  }
  D = c1 * c1 + c2 * c2;
  m[0] = (b1 + a1) * c1 + (b2 + a2) * c2;
  n[0] = (b1 + a1) * c2 - (b2 + a2) * c1;
  m[1] = (b1 - a1) * c1 + (b2 - a2) * c2;
  n[1] = (b1 - a1) * c2 - (b2 - a2) * c1;
  m[2] = (b1 - a2) * c1 + (b2 + a1) * c2;
  n[2] = (b1 - a2) * c2 - (b2 + a1) * c1;
  m[3] = (b1 + a2) * c1 + (b2 - a1) * c2;
  n[3] = (b1 + a2) * c2 - (b2 - a1) * c1;
  bool ok = false;
  for (int i = 0; i != 4; ++i) ok |= !((m[i] % D) || (n[i] % D));
  std::cout << (ok ? "YES" : "NO") << std::endl;
  return 0;
}
