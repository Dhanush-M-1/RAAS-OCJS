#include <bits/stdc++.h>
using namespace std;
int Arr[105];
int main() {
  int t, m;
  cin >> t >> m;
  int id = 1, i;
  string s;
  while (t--) {
    cin >> s;
    if (s[0] == 'a') {
      int p;
      cin >> p;
      int cnt = 0, idx = 0;
      bool ok = false;
      for (i = 0; i < m; i++) {
        if (!Arr[i])
          cnt++;
        else {
          cnt = 0;
          idx = i + 1;
        }
        if (cnt == p) {
          ok = true;
          break;
        }
      }
      if (ok) {
        for (i = idx; i < idx + p; i++) Arr[i] = id;
        cout << id++ << endl;
      } else
        puts("NULL");
    } else if (s[0] == 'e') {
      int p;
      cin >> p;
      if (p > id || p <= 0)
        puts("ILLEGAL_ERASE_ARGUMENT");
      else {
        int f = false;
        for (i = 0; i < m; i++) {
          if (Arr[i] == p) break;
        }
        while (Arr[i] == p) {
          Arr[i] = 0;
          i++;
          f = true;
        }
        if (!f) puts("ILLEGAL_ERASE_ARGUMENT");
      }
    } else {
      int idx = 0;
      for (i = 0; i < m; i++) {
        if (Arr[i]) Arr[idx++] = Arr[i];
      }
      for (i = idx; i < m; i++) Arr[i] = 0;
    }
  }
  return 0;
}
