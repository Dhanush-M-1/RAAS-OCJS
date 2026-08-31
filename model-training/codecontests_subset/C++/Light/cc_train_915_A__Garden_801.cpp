#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, i, a, mx = -1, ans;
  cin >> n >> k;
  for (i = 1; i <= n; i++) {
    cin >> a;
    if (k % a == 0) {
      mx = max(mx, a);
      ans = k / mx;
    }
  }
  cout << ans;
}
