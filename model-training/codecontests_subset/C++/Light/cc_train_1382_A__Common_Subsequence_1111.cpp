#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, flag = 0, i, x;
    cin >> n >> m;
    map<int, int> a;
    vector<int> b;
    for (i = 0; i < n; i++) {
      cin >> x;
      a.insert({x, 1});
    }
    for (i = 0; i < m; i++) {
      int y;
      cin >> y;
      b.push_back(y);
    }
    for (i = 0; i < m; i++) {
      if (a.find(b[i]) != a.end()) {
        flag = 1;
        break;
      }
    }
    if (flag == 1) {
      cout << "YES" << endl;
      cout << 1 << " " << b[i] << endl;
    } else
      cout << "NO" << endl;
  }
  return 0;
}
