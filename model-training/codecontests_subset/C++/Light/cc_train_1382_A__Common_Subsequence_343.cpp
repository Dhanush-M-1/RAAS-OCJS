#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, m;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n >> m;
    int a[1001] = {}, b[1001] = {}, p;
    for (int j = 0; j < n; j++) {
      cin >> p;
      a[p]++;
    }
    for (int j = 0; j < m; j++) {
      cin >> p;
      b[p]++;
    }
    for (int j = 1; j <= 1000; j++) {
      if (a[j] > 0 && b[j] > 0) {
        cout << "YES" << endl << 1 << " " << j << endl;
        break;
      }
      if (j == 1000) cout << "NO" << endl;
    }
  }
}
