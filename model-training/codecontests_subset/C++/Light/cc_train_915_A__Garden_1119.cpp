#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  ;
  long long int n, k;
  cin >> n >> k;
  long long int m = 101;
  for (long long int i = 0; i <= n - 1; i++) {
    long long int x;
    cin >> x;
    if (k % x == 0) m = min(m, k / x);
  }
  cout << m;
  return 0;
}
