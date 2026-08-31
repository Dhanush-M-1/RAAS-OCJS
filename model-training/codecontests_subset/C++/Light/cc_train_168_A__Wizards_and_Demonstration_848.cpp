#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  double n, x, y;
  cin >> n >> x >> y;
  double needed = ceil(y / 100 * n);
  if (needed <= x) {
    cout << 0;
  } else {
    cout << needed - x;
  }
}
