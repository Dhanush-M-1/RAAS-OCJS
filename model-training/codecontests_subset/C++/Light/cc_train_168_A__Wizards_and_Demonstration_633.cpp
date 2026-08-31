#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  int tot = ceil(y * n / 100);
  int ans = tot - x;
  (ans > 0) ? cout << ans : cout << 0;
}
