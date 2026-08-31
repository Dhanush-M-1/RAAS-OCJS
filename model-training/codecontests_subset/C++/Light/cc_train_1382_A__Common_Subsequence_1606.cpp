#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, m, n, i, j, p, c;
  long long int x[100000], y[100000];
  cin >> t;
  while (t--) {
    p = 0;
    cin >> n >> m;
    for (i = 0; i < n; i++) {
      cin >> x[i];
    }
    for (i = 0; i < m; i++) {
      cin >> y[i];
    }
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        if (x[i] == y[j]) {
          p = 1;
          c = x[i];
          break;
        }
      }
      if (p) {
        break;
      }
    }
    if (p) {
      cout << "YES" << endl;
      cout << p << " " << c << endl;
    } else {
      cout << "NO" << endl;
    }
  }
}
