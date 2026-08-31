#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, m, a[1000], b[1000], c[1000], k = 0, j;
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < m; i++) cin >> b[i];
  for (int i = 0; i < m; i++) {
    j = 0;
    while (k == 0 && j < n) {
      if (a[j] == b[i]) {
        c[k] = b[i];
        k++;
        break;
      }
      j++;
    }
  }
  if (k == 0)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    cout << k << " ";
    cout << c[k - 1];
  }
  cout << endl;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
