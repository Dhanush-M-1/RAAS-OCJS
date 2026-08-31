#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    vector<string> arr(n);
    for (long long i = 0; i < n; i++) cin >> arr[i];
    char sa = arr[0][1], sb = arr[1][0], fa = arr[n - 1][n - 2],
         fb = arr[n - 2][n - 1];
    vector<vector<long long>> res;
    if (sa == sb) {
      if (fa == sa) res.push_back({n - 1, n - 2});
      if (fb == sa) res.push_back({n - 2, n - 1});
    } else if (fa == fb) {
      if (fa == sa) res.push_back({0, 1});
      if (fa == sb) res.push_back({1, 0});
    } else {
      if (sa == '0') res.push_back({0, 1});
      if (sb == '0') res.push_back({1, 0});
      if (fa == '1') res.push_back({n - 1, n - 2});
      if (fb == '1') res.push_back({n - 2, n - 1});
    }
    cout << res.size() << endl;
    for (auto v : res) cout << v[0] + 1 << " " << v[1] + 1 << endl;
  }
}
