#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m, flag = 0;
    cin >> n >> m;
    long long a[n], b[m];
    vector<long long> c;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          c.push_back(a[i]);
          flag = 1;
          break;
        }
      }
    }
    if (flag == 1) {
      cout << "YES\n";
      cout << "1"
           << " " << c[0] << "\n";
    } else
      cout << "NO\n";
  }
}
