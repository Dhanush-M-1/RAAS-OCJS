#include <bits/stdc++.h>
using namespace std;
int t, m;
int a[101];
int xx = 0;
int x;
string s;
int main() {
  cin >> t >> m;
  for (int i = 0; i < t; i++) {
    cin >> s;
    if (s == "defragment") {
      for (int j = 0; j < m; j++) {
        if (a[j] == 0) {
          int find = -1;
          for (int k = m - 1; k > j; k--) {
            if (a[k] != 0) find = k;
          }
          if (find != -1) {
            a[j] = a[find];
            a[find] = 0;
          }
        }
      }
    } else {
      if (s.find("alloc") != -1) {
        cin >> x;
        bool ok1 = false;
        for (int j = 0; j < m; j++) {
          if (!ok1) {
            bool ok = true;
            for (int k = 0; k < x; k++)
              if ((j + k >= m) || (a[j + k] != 0)) ok = false;
            if (ok) {
              ok1 = true;
              xx++;
              for (int k = j; k < j + x; k++) a[k] = xx;
            }
          }
        }
        if (!ok1)
          cout << "NULL" << endl;
        else
          cout << xx << endl;
      } else {
        cin >> x;
        bool ok = false;
        for (int j = 0; j < m; j++)
          if (a[j] == x) {
            ok = true;
            a[j] = 0;
          }
        if (x == 0) ok = false;
        if (!ok) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    }
  }
  return 0;
}
