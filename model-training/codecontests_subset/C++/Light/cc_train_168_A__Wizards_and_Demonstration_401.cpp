#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-6;
int main() {
  int n, x, y;
  while (scanf("%d%d%d", &n, &x, &y) != EOF) {
    int i = 0;
    for (i = x;; i++) {
      if (i * 1.0 / n * 100 - y >= 0) break;
    }
    cout << i - x << endl;
  }
  return 0;
}
