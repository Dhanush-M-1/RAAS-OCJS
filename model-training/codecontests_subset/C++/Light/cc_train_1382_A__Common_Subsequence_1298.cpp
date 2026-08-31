#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int n, m;
    cin >> n >> m;
    int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    int b[m];
    for (int i = 0; i < m; i++) cin >> b[i];
    int f = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          f = a[i];
          break;
        }
      }
      if (f != -1) break;
    }
    if (f == -1)
      cout << "NO\n";
    else
      cout << "YES\n" << 1 << " " << f << endl;
  }
  return 0;
}
