#include <bits/stdc++.h>
using namespace std;
int main() {
  int tc;
  cin >> tc;
  while (tc--) {
    int n, m, c = 0;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) {
      cin >> b[i];
      for (int j = 0; j < n; j++) {
        if (b[i] == a[j]) {
          c = b[i];
          break;
        }
        if (c) break;
      }
    }
    if (c)
      cout << "YES\n1 " << c << endl;
    else
      cout << "NO\n";
  }
}
