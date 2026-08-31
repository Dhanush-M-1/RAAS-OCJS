#include <bits/stdc++.h>
void proc() {
  int n;
  long long l, r;
  std::cin >> n >> l >> r;
  if (l == 1LL * n * (n - 1) + 1) {
    std::cout << 1 << std::endl;
    return;
  }
  int i = 0;
  long long t = 0;
  while (t + 2 * (n - 1 - i) < l) {
    t += 2 * (n - 1 - i);
    i++;
  }
  std::clog << i << std::endl;
  int j = i + 1 + (l - t - 1) / 2;
  std::clog << j << std::endl;
  for (; l <= r; l++) {
    std::cout << (l % 2 ? i + 1 : j + 1) << ' ';
    if (l % 2 == 0) j++;
    if (j == n) {
      i = (i + 1) % (n - 1);
      j = i + 1;
    }
  }
  std::cout << std::endl;
}
int main() {
  std::cin.tie(0);
  std::cin.sync_with_stdio(false);
  int t = 1;
  std::cin >> t;
  while (t--) proc();
  return 0;
}
