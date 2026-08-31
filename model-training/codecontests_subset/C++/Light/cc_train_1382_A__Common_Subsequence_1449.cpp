#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, i, j, n, m;
  cin >> t;
  while (t--) {
    int flag = 0;
    cin >> n >> m;
    int a[n];
    int b[m];
    int p[1001] = {0};
    int q[1001] = {0};
    for (i = 0; i < n; i++) {
      cin >> a[i];
      p[a[i]]++;
    }
    for (i = 0; i < m; i++) {
      cin >> b[i];
      q[b[i]]++;
    }
    for (i = 0; i <= 1000; i++) {
      if (q[i] >= 1 && p[i] >= 1) {
        cout << "YES" << endl;
        cout << "1"
             << " " << i << endl;
        flag = 1;
        break;
      }
    }
    if (!flag) {
      cout << "NO" << endl;
    }
  }
}
