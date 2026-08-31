#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int inf = (int)1e9;
const int MAX_N = 100 * 1000 + 1000;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  for (int t = 0;; t++) {
    if ((t + c) * b >= c * a) {
      cout << t << endl;
      return 0;
    }
  }
  return 0;
}
