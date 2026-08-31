#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int cy = n * y / 100 - x;
  double cx = n * y * 1.00 / 100 - x;
  if (cx == 0 || (cx == cy && cx > 0))
    cout << cy;
  else if (cx < 0 || cy < 0)
    cout << 0;
  else
    cout << cy + 1;
}
