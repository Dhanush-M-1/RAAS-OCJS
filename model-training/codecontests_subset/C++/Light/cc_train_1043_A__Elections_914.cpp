#include <bits/stdc++.h>
using namespace std;
int n, t, s, ma;
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> t;
    s += t;
    ma = max(ma, t);
  }
  cout << max(ma, (2 * s + n) / n);
  return 0;
}
