#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n;
    cin >> n;
    long long int a[n];
    for (long long int i = 0; i < n; i++) {
      cin >> a[i];
    }
    sort(a, a + n);
    if (a[0] + a[1] > a[n - 1])
      cout << -1 << endl;
    else
      cout << 1 << " " << 2 << " " << n << endl;
  }
  return 0;
}
