#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n], b[m];
    unordered_set<int> s;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      s.insert(a[i]);
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    bool flag = false;
    for (int i = 0; i < m; i++) {
      if (s.find(b[i]) != s.end()) {
        cout << "YES" << endl;
        cout << "1"
             << " " << b[i] << endl;
        flag = true;
        break;
      }
    }
    if (flag == false) cout << "NO" << endl;
  }
  return 0;
}
