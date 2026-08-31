#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    set<int> s;
    vector<int> a(n), b(m);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      s.insert(a[i]);
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    vector<int> c;
    for (int i = 0; i < m; i++) {
      if (s.count(b[i])) {
        c.push_back(b[i]);
        break;
      }
    }
    if (c.size()) {
      cout << "YES"
           << "\n";
      cout << 1 << " " << c[0] << "\n";
    } else {
      cout << "NO"
           << "\n";
    }
  }
}
