#include <bits/stdc++.h>
using namespace std;
double f(double x) { return x >= 0 ? x : -x; }
const double e = 1e-9;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  double goal = 1.0 * n * y / 100;
  int g = n * y / 100;
  if (f(goal - g) < e) {
    if (g > x)
      cout << g - x << endl;
    else
      cout << 0;
  } else {
    if (g + 1 > x)
      cout << g - x + 1 << endl;
    else
      cout << 0;
  }
}
