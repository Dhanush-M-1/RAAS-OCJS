#include <bits/stdc++.h>
using namespace std;
int main() {
  long t, n, i;
  cin >> t;
  while (t--) {
    cin >> n;
    int a[n], x = 0;
    for (i = 0; i < n; i++) cin >> a[i];
    for (i = 2; i < n; i++) {
      if ((a[0] + a[1]) <= a[i]) {
        cout << "1"
             << " "
             << "2"
             << " " << i + 1 << endl;
        x = 1;
        break;
      }
    }
    if (x == 0) cout << "-1" << endl;
  }
  return 0;
}
