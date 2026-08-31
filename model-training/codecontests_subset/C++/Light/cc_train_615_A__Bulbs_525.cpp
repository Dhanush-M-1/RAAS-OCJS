#include <bits/stdc++.h>
using namespace std;
int main() {
  int m, n;
  set<int> set;
  cin >> n >> m;
  cin.get();
  if (n >= 1 && m <= 100) {
    for (int i = 0; i < n; i++) {
      string s;
      int x;
      stringstream ss;
      getline(cin, s);
      ss << s;
      ss >> x;
      if (x >= 0 && x <= m) {
        int y;
        while (ss >> y) set.insert(y);
      }
    }
    if (set.size() >= m)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}
