#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  int mem[101] = {};
  int id = 1;
  for (int i = 0; i < t; i++) {
    string c;
    cin >> c;
    if (c == "alloc") {
      int s;
      cin >> s;
      int w = 0;
      for (int i = 0; i < m; i++) {
        if (mem[i]) {
          w = 0;
        } else {
          w++;
          if (w == s) {
            for (int j = i - w + 1; j <= i; j++) {
              mem[j] = id;
            }
            cout << id << endl;
            id++;
            break;
          }
        }
      }
      if (w != s) {
        cout << "NULL" << endl;
      }
    } else if (c == "erase") {
      long long s;
      cin >> s;
      bool found = false;
      for (int i = 0; i < m; i++) {
        if (mem[i] == s && s) {
          found = true;
          mem[i] = 0;
        }
      }
      if (!found) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      int p = 0;
      for (int i = 0; i < m; i++) {
        if (mem[i]) {
          mem[p] = mem[i];
          p++;
        }
      }
      for (; p < m; p++) {
        mem[p] = 0;
      }
    }
  }
  return 0;
}
