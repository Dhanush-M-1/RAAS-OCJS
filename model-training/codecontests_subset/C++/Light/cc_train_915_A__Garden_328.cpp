#include <bits/stdc++.h>
int main(int argc, char const *argv[]) {
  int n, k;
  std::cin >> n >> k;
  int max = 0;
  for (int i = 0; i < n; ++i) {
    int elem;
    std::cin >> elem;
    if (k % elem == 0) {
      if (elem > max) {
        max = elem;
      }
    }
  }
  std::cout << k / max << "\n";
  return 0;
}
