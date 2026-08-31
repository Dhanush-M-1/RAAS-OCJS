#include <bits/stdc++.h>
using namespace std;
int t, m, n, cnt = 0, mem[105], def[105];
string s;
bool flag, found;
int main() {
  cin >> t >> m;
  memset(mem, 0, sizeof(mem));
  for (int i = 0; i < t; i++) {
    cin >> s;
    if (s != "defragment") cin >> n;
    if (s == "alloc") {
      found = false;
      for (int j = 0; j <= m - n; j++) {
        flag = true;
        for (int k = 0; k < n; k++) {
          if (mem[j + k] != 0) {
            flag = false;
            break;
          }
        }
        if (flag) {
          found = true;
          ++cnt;
          for (int k = 0; k < n; k++) {
            mem[j + k] = cnt;
          }
          cout << cnt << endl;
          break;
        }
      }
      if (!found) cout << "NULL" << endl;
    }
    if (s == "erase") {
      if (n == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      }
      flag = true;
      for (int j = 0; j < m; j++) {
        if (mem[j] == n) flag = false, mem[j] = 0;
      }
      if (flag) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    }
    if (s == "defragment") {
      int ccnt = 0;
      for (int j = 0; j < m; j++)
        if (mem[j] != 0) def[ccnt++] = mem[j];
      memset(mem, 0, sizeof(mem));
      for (int j = 0; j < ccnt; j++) mem[j] = def[j];
    }
  }
  return 0;
}
