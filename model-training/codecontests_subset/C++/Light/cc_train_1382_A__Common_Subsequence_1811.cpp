#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n], b[m], i, j;
    for (i = 0; i < n; i++) cin >> a[i];
    for (i = 0; i < m; i++) cin >> b[i];
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          cout << "YES" << endl
               << "1"
               << " " << a[i] << endl;
          goto s;
        }
      }
    }
    cout << "NO" << endl;
  s : {}
  }
}
