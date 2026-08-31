#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, x, y;
  cin >> n >> x >> y;
  double procent = (double)y / 100 * n, cnt = 0;
  if (x > procent)
    cout << 0;
  else {
    while (x < procent) {
      x++;
      cnt++;
    }
    cout << cnt;
  }
}
