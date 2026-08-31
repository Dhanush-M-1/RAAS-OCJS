#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    long long a[n];
    for (long long i = 0; i < n; i++) cin >> a[i];
    if (a[0] + a[1] <= a[n - 1])
      cout << "1 2 " << n << "\n";
    else
      cout << "-1"
           << "\n";
  }
  return 0;
}
