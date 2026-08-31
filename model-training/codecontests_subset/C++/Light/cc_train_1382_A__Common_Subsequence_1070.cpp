#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    int b[m];
    for (int i = 0; i < m; i++) cin >> b[i];
    int check = 0;
    for (int i = 0; i < n; i++) {
      if (check == 1) break;
      for (int j = 0; j < m; j++)
        if (a[i] == b[j]) {
          cout << "YES" << endl;
          cout << 1 << " " << b[j] << endl;
          check = 1;
          break;
        }
    }
    if (check == 0) cout << "NO" << endl;
  }
  return 0;
}
