#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int ans = INT_MAX;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (!(k % x)) {
      ans = min(ans, k / x);
    }
  }
  cout << ans << "\n";
  return 0;
}
