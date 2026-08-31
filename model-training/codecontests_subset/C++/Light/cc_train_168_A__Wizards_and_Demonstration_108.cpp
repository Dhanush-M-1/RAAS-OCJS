#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  if (y < 100) {
    float tmp = (float(y) / 100) * n;
    tmp = ceil(tmp);
    if (tmp > x) {
      cout << tmp - x;
    } else {
      cout << 0;
    }
  } else {
    float y2 = (float(y) / 100) * 1;
    float tmp = y2 * n;
    tmp = ceil(tmp);
    cout << tmp - x;
  }
  return 0;
}
