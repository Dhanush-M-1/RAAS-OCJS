#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  vector<int> v(m, 1000000000);
  int c = 1;
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int x;
      cin >> x;
      int r = 0;
      bool found = false;
      for (int i = 0; i < m; i++) {
        if (v[i] == 1000000000) {
          r++;
        } else {
          r = 0;
        }
        if (r == x) {
          found = true;
          for (int j = i - r + 1; j <= i; j++) {
            v[j] = c;
          }
          break;
        }
      }
      if (found) {
        cout << c << endl;
        c++;
      } else {
        cout << "NULL" << endl;
      }
    } else if (s == "erase") {
      int x;
      cin >> x;
      bool b = false;
      for (int i = 0; i < m; i++) {
        if (v[i] == x) {
          b = true;
          v[i] = 1000000000;
        }
      }
      if (!b) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      vector<int> v1;
      for (int i = 0; i < m; i++) {
        if (v[i] != 1000000000) {
          v1.push_back(v[i]);
        }
      }
      while (v1.size() < m) {
        v1.push_back(1000000000);
      }
      v = v1;
    }
  }
  return 0;
}
