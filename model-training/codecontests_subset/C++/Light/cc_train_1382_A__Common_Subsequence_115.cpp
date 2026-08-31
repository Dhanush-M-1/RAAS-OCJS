#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m, flag = 0;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    sort(a, a + n);
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    for (int i = 0; i < m; i++) {
      if (binary_search(a, a + n, b[i])) {
        cout << "YES\n" << 1 << " " << b[i] << "\n";
        flag = 1;
        break;
      }
    }
    if (flag == 0) cout << "NO\n";
  }
  return 0;
}
