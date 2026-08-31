#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int x, y;
    int flag = 0;
    cin >> x >> y;
    int a;
    vector<int> b(y);
    set<int> s;
    for (int i = 0; i < x; i++) {
      cin >> a;
      s.insert(a);
    }
    for (int j = 0; j < y; j++) {
      cin >> b[j];
    }
    for (int i = 0; i < y; i++) {
      if (s.find(b[i]) != s.end()) {
        cout << "YES" << endl;
        cout << 1 << " " << b[i] << endl;
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      cout << "NO" << endl;
    }
  }
  return 0;
}
