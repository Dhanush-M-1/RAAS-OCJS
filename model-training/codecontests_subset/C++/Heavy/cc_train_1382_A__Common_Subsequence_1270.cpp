#include <bits/stdc++.h>
using namespace std;
int bs(int a[], int val, int m) {
  int start = 0, end = m - 1, mid = (start + end) / 2;
  while (end >= start) {
    mid = (start + end) / 2;
    if (a[mid] == val)
      return 1;
    else if (a[mid] > val)
      end = mid - 1;
    else
      start = mid + 1;
  }
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m, f = 0;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    sort(a, a + n);
    sort(b, b + m);
    for (int i = 0; i < n; i++) {
      if (bs(b, a[i], m) == 1) {
        cout << "YES\n";
        cout << 1 << " " << a[i] << "\n";
        f = 1;
        break;
      }
    }
    if (f == 0) cout << "NO\n";
  }
  return 0;
}
