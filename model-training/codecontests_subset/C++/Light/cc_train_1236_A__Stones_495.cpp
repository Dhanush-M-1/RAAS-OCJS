#include <bits/stdc++.h>
int main() {
  int ans = 0;
  int t, a, b, c;
  std::cin >> t;
  for (int i = 0; i < t; i++) {
    std::cin >> a >> b >> c;
    int interm1 = c / 2;
    if (b >= interm1)
      b -= interm1;
    else {
      interm1 = b;
      b = 0;
    }
    int interm2 = b / 2;
    if (a < interm2) interm2 = a;
    std::cout << 3 * (interm1 + interm2) << std::endl;
  }
  return 0;
}
