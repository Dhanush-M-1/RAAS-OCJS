#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m, x, f, it = 0, z = 0, j, k, e = 0;
  string s;
  cin >> t >> m;
  f = m;
  int mem[m];
  for (int i = 0; i < m; i++) mem[i] = 0;
  for (int i = 0; i < t; i++) {
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      if (x > f)
        cout << "NULL" << endl;
      else {
        for (j = 0; j <= m - x; j++) {
          for (k = j; k < x + j; k++) {
            if (mem[k] != 0) break;
          }
          if (k == x + j) {
            it++;
            f = f - x;
            for (int l = j; l < x + j; l++) mem[l] = it;
            cout << it << endl;
            ;
            break;
          }
        }
        if (j == m - x + 1) cout << "NULL" << endl;
      }
    }
    if (s == "erase") {
      cin >> x;
      if (x > it || x < 1)
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        for (j = 0; j < m; j++) {
          if (mem[j] == x) {
            mem[j] = 0;
            f++;
            e++;
          }
        }
        if (e == 0)
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        else
          e = 0;
      }
    }
    if (s == "defragment") {
      for (j = 0; j < m - 1; j++) {
        if (mem[j] == 0 && mem[j + 1] == 0) z++;
        if (mem[j] == 0 && mem[j + 1] != 0) {
          mem[j - z] = mem[j + 1];
          mem[j + 1] = 0;
        }
      }
      z = 0;
    }
  }
  return 0;
}
