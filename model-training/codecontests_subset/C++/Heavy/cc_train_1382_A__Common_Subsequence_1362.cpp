#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    for (long long int i = 0; i < n; i++) cin >> a[i];
    for (long long int i = 0; i < m; i++) cin >> b[i];
    long long int flag = 0, ans = 0;
    for (long long int i = 0; i < n; i++) {
      for (long long int j = 0; j < m; j++)
        if (a[i] == b[j]) {
          flag = 1;
          ans = a[i];
          break;
        }
      if (flag == 1) break;
    }
    if (flag == 0)
      cout << "NO" << endl;
    else
      cout << "YES" << endl << 1 << " " << ans << endl;
  }
}
