#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int ans = (n * y - 1) / 100 + 1 - x;
  if (ans > 0)
    cout << ans << endl;
  else
    cout << 0 << endl;
}
