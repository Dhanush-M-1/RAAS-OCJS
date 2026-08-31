#include <bits/stdc++.h>
using namespace std;
int n, k;
int a, ans;
int main() {
  cin >> n >> k;
  ans = k;
  for (int i = 1; i <= n; ++i) {
    cin >> a;
    if (k % a == 0) ans = min(ans, k / a);
  }
  cout << ans << endl;
  return 0;
}
