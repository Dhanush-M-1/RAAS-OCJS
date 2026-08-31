#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  int id = 1;
  vector<int> v(m);
  for (int c = 0; c < m; c++) v[c] = 0;
  for (int c = 0; c < t; c++) {
    string s;
    cin >> s;
    if (s == "defragment") {
      int c3 = 0;
      for (int c2 = 0; c2 < v.size(); c2++) {
        if (v[c2] != 0) {
          v[c3++] = v[c2];
          if (c2 != c3 - 1) v[c2] = 0;
        }
      }
    } else {
      long long int n;
      cin >> n;
      if (s == "alloc") {
        int act = 0;
        bool flag = false;
        for (int c2 = 0; c2 < v.size() && !flag; c2++) {
          if (v[c2] != 0)
            act = 0;
          else
            act++;
          if (act == n) {
            for (int c3 = c2; c3 > c2 - n; c3--) v[c3] = id;
            flag = true;
            id++;
          }
        }
        if (flag)
          cout << id - 1 << endl;
        else
          cout << "NULL" << endl;
      } else {
        bool flag = false;
        for (int c2 = 0; c2 < v.size(); c2++) {
          if (v[c2] == n) {
            flag = true;
            v[c2] = 0;
          }
        }
        if (!flag || n <= 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    }
  }
}
