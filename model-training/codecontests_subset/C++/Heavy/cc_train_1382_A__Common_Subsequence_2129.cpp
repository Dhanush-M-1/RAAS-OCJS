#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    int f = 0, ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          f = 1;
          ans = a[i];
          break;
        }
      }
      if (f == 1) {
        break;
      }
    }
    if (f == 0) {
      cout << "NO";
    } else {
      cout << "YES" << endl;
      cout << "1"
           << " " << ans;
    }
    cout << endl;
  }
}
