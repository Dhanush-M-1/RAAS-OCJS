#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int arr[1001] = {0};
    for (long long int i = 0; i < n; i++) {
      long long int x;
      cin >> x;
      arr[x]++;
    }
    bool ans = true;
    for (long long int i = 0; i < m; i++) {
      long long int x;
      cin >> x;
      if (arr[x] > 0 && ans) {
        cout << "YES" << endl;
        cout << 1 << " " << x << endl;
        ans = false;
      }
    }
    if (ans) cout << "NO" << endl;
  }
}
