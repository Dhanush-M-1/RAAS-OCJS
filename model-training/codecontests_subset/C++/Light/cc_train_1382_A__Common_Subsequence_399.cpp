#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n], b[m];
    int flag = 0;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          flag = 1;
          cout << "YES" << endl;
          cout << 1 << " " << a[i] << endl;
          break;
        }
      }
      if (flag == 1) break;
    }
    if (flag == 0) cout << "NO" << endl;
  }
  return 0;
}
