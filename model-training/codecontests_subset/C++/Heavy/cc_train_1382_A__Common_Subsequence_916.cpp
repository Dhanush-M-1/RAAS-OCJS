#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int tc;
  cin >> tc;
  while (tc--) {
    long long int n, m;
    cin >> n >> m;
    long long int i, j, flg = 1;
    vector<long long int> a, b;
    for (i = 0; i < n; i++) {
      long long int k;
      cin >> k;
      a.push_back(k);
    }
    for (i = 0; i < m; i++) {
      long long int k;
      cin >> k;
      b.push_back(k);
    }
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          flg = 0;
          break;
        }
      }
      if (flg == 0) break;
    }
    if (flg == 1)
      cout << "NO"
           << "\n";
    else
      cout << "YES"
           << "\n"
           << 1 << " " << a[i] << "\n";
  }
}
