#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y;
  cin >> n >> x >> y;
  double t = x / n;
  int ans = 0;
  while (t + 1e-7 < y / 100) {
    ans++;
    t = (x + ans) / n;
  }
  cout << ans;
  return 0;
}
