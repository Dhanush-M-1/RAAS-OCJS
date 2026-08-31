#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  t = 1;
  while (t--) {
    double n, x, y, k;
    cin >> n >> x >> y;
    k = ceil((y / 100) * n) - x;
    if (k >= 0)
      cout << k;
    else
      cout << 0;
  }
  cerr << "Time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs" << endl;
  return 0;
}
