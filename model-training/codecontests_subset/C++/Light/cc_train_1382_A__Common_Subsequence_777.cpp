#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int m, n;
    cin >> m >> n;
    int a[m];
    for (int i = 0; i < m; i++) cin >> a[i];
    int b[n];
    for (int i = 0; i < n; i++) cin >> b[i];
    unordered_set<int> s;
    for (int i = 0; i < m; i++) s.insert(a[i]);
    int flag = 1;
    for (int i = 0; i < n; i++) {
      if (s.find(b[i]) != s.end()) {
        cout << "YES" << endl;
        cout << 1 << " " << b[i] << endl;
        flag = 0;
        break;
      }
    }
    if (flag == 1) cout << "NO" << endl;
  }
}
