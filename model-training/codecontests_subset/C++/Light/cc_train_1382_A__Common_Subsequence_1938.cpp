#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, m;
  cin >> n >> m;
  int a[n], b[m];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < m; i++) cin >> b[i];
  sort(a, a + n);
  sort(b, b + m);
  int i = 0, j = 0;
  while (i < n && j < m) {
    if (a[i] == b[j]) {
      cout << "YES" << endl;
      cout << 1 << " " << a[i] << endl;
      return;
    } else if (a[i] < b[j])
      i++;
    else
      j++;
  }
  cout << "NO" << endl;
  return;
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
