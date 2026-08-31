#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int temp = ceil(y * 0.01 * n);
  if (temp <= x)
    cout << 0;
  else {
    int ans = temp - x;
    cout << ans;
  }
  return 0;
}
