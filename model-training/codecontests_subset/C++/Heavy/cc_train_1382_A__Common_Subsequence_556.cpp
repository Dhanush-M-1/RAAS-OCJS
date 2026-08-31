#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, m, n, ans;
  cin >> t;
  while (t--) {
    ans = 0;
    cin >> m >> n;
    set<long long int> s;
    long long int a[m];
    long long int b[n];
    for (long long int i = 0; i < m; i++) {
      cin >> a[i];
      s.insert(a[i]);
    }
    for (long long int i = 0; i < n; i++) {
      cin >> b[i];
    }
    for (long long int i = 0; i < n; i++) {
      if (s.find(b[i]) != s.end()) {
        ans = b[i];
        break;
      }
    }
    if (ans == 0) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl << 1 << " " << ans << endl;
    }
  }
  return 0;
}
