#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  cin >> n >> x >> y;
  int ans = ceil(n * y * 1.0 / 100);
  cout << max(ans - x, 0);
}
