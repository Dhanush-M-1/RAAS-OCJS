#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, n, x, y;
  cin >> n >> x >> y;
  for (i = 0;; i++) {
    if (n * y <= (x + i) * 100) break;
  }
  cout << i << endl;
  return 0;
}
