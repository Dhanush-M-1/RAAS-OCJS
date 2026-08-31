#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, k;
  cin >> n >> x >> y;
  k = ceil(y * n / 100.0 - x);
  cout << max(0, k);
  return 0;
}
