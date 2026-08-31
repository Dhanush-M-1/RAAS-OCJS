#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int ans = -1;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (k % x == 0) {
      if (ans == -1)
        ans = k / x;
      else
        ans = min(ans, k / x);
    }
  }
  cout << ans;
}
