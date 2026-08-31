#include <bits/stdc++.h>
using namespace std;
using lint = long long;
int a[111];
void solve(istream& cin, ostream& cout) {
  int t, m;
  cin >> t >> m;
  int id = 0;
  for (int i = 0; i < (int)(t); ++i) {
    string s;
    int x;
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      bool success = false;
      for (int j = 0; j + x <= m; j++) {
        bool all = true;
        for (int k = 0; k < x; k++) {
          if (a[k + j] != 0) {
            all = false;
            break;
          }
        }
        if (all) {
          ++id;
          for (int k = 0; k < x; k++) {
            a[k + j] = id;
          }
          success = true;
          break;
        }
      }
      if (!success) {
        cout << "NULL\n";
      } else {
        cout << id << "\n";
      }
    } else if (s == "erase") {
      cin >> x;
      int p = -1;
      for (int j = 0; j < m; j++) {
        if (a[j] == x) {
          p = j;
          break;
        }
      }
      if (x <= 0 || p == -1) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      } else {
        for (; p < m && a[p] == x; p++) {
          a[p] = 0;
        }
      }
    } else {
      int l = 0;
      for (int r = 0; r < m; r++) {
        if (a[r] != 0) {
          a[l++] = a[r];
        }
      }
      for (; l < m; l++) {
        a[l] = 0;
      }
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve(cin, cout);
  return 0;
}
