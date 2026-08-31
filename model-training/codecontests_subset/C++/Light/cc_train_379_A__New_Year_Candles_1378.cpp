#include <bits/stdc++.h>
void solve() {
  int n, b;
  std::cin >> n >> b;
  int s = 0;
  while (n) {
    if (n < b) {
      s += n;
      break;
    }
    s += b * (n / b);
    n = n / b + n % b;
  }
  std::cout << s;
}
int main() {
  solve();
  return 0;
}
