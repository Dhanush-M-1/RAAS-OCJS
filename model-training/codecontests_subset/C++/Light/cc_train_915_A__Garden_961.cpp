#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, ans = 9999999, d, n, k, t, i;
  cin >> n >> k;
  for (i = 0; i < n; i++) {
    cin >> t;
    if (k % t == 0) {
      ans = min(k / t, ans);
    }
  }
  cout << ans;
}
