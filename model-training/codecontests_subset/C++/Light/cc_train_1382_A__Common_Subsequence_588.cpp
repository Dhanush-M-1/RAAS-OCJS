#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int i, n, m, d = -1;
    cin >> m >> n;
    vector<int> a(m), b(n), c(10000, 0);
    for (i = 0; i < m; i++) {
      cin >> a[i];
      c[a[i]]++;
    }
    for (i = 0; i < n; i++) {
      cin >> b[i];
      if (c[b[i]] > 0) {
        d = b[i];
      }
    }
    if (d != -1)
      cout << "YES\n1 " << d << '\n';
    else
      cout << "NO\n";
  }
  return 0;
}
