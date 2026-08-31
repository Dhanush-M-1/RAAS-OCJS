#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, n, x;
  float y;
  cin >> n >> x >> y;
  a = ceil(y / 100 * n) - x;
  if (a < 0) {
    cout << 0 << endl;
    return 0;
  }
  cout << a << endl;
  return 0;
}
