#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, k, ans = INT_MAX;
  cin >> n >> k;
  for (long long int i = 0; i < n; i++) {
    long long int x;
    cin >> x;
    if (k % x == 0) {
      ans = min(ans, k / x);
    }
  }
  cout << ans;
  return 0;
}
