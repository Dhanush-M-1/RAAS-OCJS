#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  for (int t = 0; t < T; ++t) {
    int n;
    int m;
    cin >> n >> m;
    vector<int> a;
    vector<int> b;
    for (int i = 0; i < n; ++i) {
      int x;
      cin >> x;
      a.push_back(x);
    }
    for (int i = 0; i < m; ++i) {
      int x;
      cin >> x;
      b.push_back(x);
    }
    int common_num = -1;
    bool found = false;
    for (int i = 0; i < n; ++i) {
      if (found) {
        break;
      }
      for (int j = 0; j < m; ++j) {
        if (a[i] == b[j]) {
          found = true;
          common_num = a[i];
          break;
        }
      }
    }
    if (!found) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
      cout << 1 << " " << common_num << endl;
    }
  }
  return 0;
}
