#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, t;
  while (cin >> n >> x >> y) {
    t = n * y;
    if (t / 100 + (t % 100 ? 1 : 0) < x)
      cout << 0 << endl;
    else
      cout << t / 100 + (t % 100 ? 1 : 0) - x << endl;
  }
  return 0;
}
