#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c = 0;
  cin >> n;
  for (int x1 = -(1 << 30), h1 = 0, x, h; cin >> x >> h; ++c, x1 = x, h1 = h) {
    if (x1 + h1 >= x) --c, h1 = 0;
    if (x - h > x1 + h1) h = 0;
  }
  cout << c << "\n";
}
