#include <bits/stdc++.h>
using namespace std;
const int inf = 1 << 28;
const double INF = 1e12, EPS = 1e-9;
bool _(long long x, long long y, long long a, long long b) {
  if (a == b && b == 0) return x == 0 && y == 0;
  return (a * y - b * x) % (a * a + b * b) == 0 &&
         (a * x + b * y) % (a * a + b * b) == 0;
}
void run() {
  int a1, a2, b1, b2, c1, c2;
  cin >> a1 >> a2 >> c1 >> c2 >> b1 >> b2;
  cout << (_(c1 - a1, c2 - a2, b1, b2) || _(c1 + a2, c2 - a1, b1, b2) ||
                   _(c1 + a1, c2 + a2, b1, b2) || _(c1 - a2, c2 + a1, b1, b2)
               ? "YES"
               : "NO")
       << endl;
}
int main() { run(); }
