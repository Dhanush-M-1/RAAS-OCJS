#include <bits/stdc++.h>
using namespace std;
const int N = 1005;
int t, n, m, b, a[N];
bool y[N];
int main() {
  cin >> t;
  while (t--) {
    cin >> n >> m;
    int e = -1;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      y[a[i]] = true;
    }
    for (int i = 0; i < m; i++) {
      cin >> b;
      if (y[b]) e = b;
    }
    for (int i = 0; i < n; i++) y[a[i]] = false;
    if (e == -1)
      cout << "NO\n";
    else
      cout << "YES\n1 " << e << " "
           << "\n";
  }
}
