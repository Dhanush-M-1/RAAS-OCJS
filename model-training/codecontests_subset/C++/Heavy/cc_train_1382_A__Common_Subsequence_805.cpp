#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m, i;
    vector<long long int> v;
    cin >> n >> m;
    long long int a[n], b[m], c = 0, j, p;
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (i = 0; i < m; i++) {
      cin >> b[i];
    }
    sort(a, a + n);
    sort(b, b + m);
    if (m > n) {
      for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
          if (b[i] == a[j]) {
            p = a[j];
            c++;
            break;
          }
          if (c != 0 && p != 1) break;
        }
      }
    } else {
      for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
          if (b[j] == a[i]) {
            p = a[i];
            c++;
            break;
          }
          if (c != 0 && p != 1) break;
        }
      }
    }
    if (c != 0) {
      cout << "YES" << endl;
      cout << 1 << " " << p << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
