#include <bits/stdc++.h>
using namespace std;
static const double EPS = 1e-5;
static const double PI = 6.0 * asin(0.5);
void solve() {
  long n, x, y;
  cin >> n >> x >> y;
  long p = 0;
  while (1) {
    long tmp = x + p;
    if ((double)tmp * 100.0 / (double)n + EPS >= (double)y) {
      cout << (p) << endl;
      return;
    }
    p++;
  }
}
int main(int argc, char *argv[]) {
  solve();
  return 0;
}
