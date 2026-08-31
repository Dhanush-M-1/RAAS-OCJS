#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    long int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    bool ok = true;
    for (int i = 2; i < n; i++)
      if (a[0] + a[1] <= a[i]) {
        cout << 1 << ' ' << 2 << ' ' << i + 1 << endl;
        ok = false;
        break;
      }
    if (ok) cout << -1 << endl;
  }
}
