#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int y = k;
  for (int x, i = 0; i < n; i++) {
    cin >> x;
    if (k % x) continue;
    y = min(k / x, y);
  }
  cout << y;
  return 0;
}
