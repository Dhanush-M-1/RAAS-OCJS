#include <bits/stdc++.h>
using namespace std;
const int oo = (int)1e9;
const double PI = 2 * acos(0.0);
const double eps = 1e-9;
int dcmp(double a, double b) {
  return (fabs(a - b) <= eps) ? 0 : ((a < b) ? -1 : 1);
}
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  if (cin.fail()) return 0;
  for (int t = 0;; t++) {
    int tot = t * b + c * b;
    if (tot >= c * a) {
      cout << t << endl;
      break;
    }
  }
  return 0;
}
