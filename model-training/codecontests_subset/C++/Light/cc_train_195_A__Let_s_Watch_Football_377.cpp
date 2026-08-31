#include <bits/stdc++.h>
using ll = long long;
int main() {
  int a, b, c;
  std::cin >> a >> b >> c;
  int mt = (a * c + b - 1) / b;
  for (int t = 0; t <= mt; t++) {
    int rest = a * c - b * t;
    int rt = (rest + b - 1) / b;
    bool isPause = false;
    for (int tt = 0; tt <= rt; tt++) {
      int load = a * tt;
      int download = b * (t + tt);
      if (load > download) {
        isPause = true;
        break;
      }
    }
    if (!isPause) {
      std::cout << t << std::endl;
      return 0;
    }
  }
  return 0;
}
