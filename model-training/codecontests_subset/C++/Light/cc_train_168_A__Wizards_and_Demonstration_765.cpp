#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  while (cin >> n >> x >> y) {
    int t = int(ceil(y * 0.01 * n));
    cout << max(0, t - x) << endl;
  }
  return 0;
}
