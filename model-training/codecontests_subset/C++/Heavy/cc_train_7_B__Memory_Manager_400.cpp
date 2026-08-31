#include <bits/stdc++.h>
using namespace std;
int t, m;
const int N = 105;
int st[N];
int l[N], r[N];
int main() {
  cin >> t >> m;
  int cnt = 0;
  while (t--) {
    string str;
    int state;
    cin >> str;
    if (str[0] != 'd') cin >> state;
    if (str[0] == 'a') {
      int alloc_ok = 0;
      for (int i = 1; i <= m - state + 1; i++) {
        int ok = 1;
        for (int j = i; j <= i + state - 1; j++) {
          if (st[j]) {
            ok = 0;
            i = j + 1 - 1;
            break;
          }
        }
        if (ok) {
          alloc_ok = 1;
          l[++cnt] = i;
          r[cnt] = i + state - 1;
          for (int k = l[cnt]; k <= r[cnt]; k++) st[k] = 1;
          break;
        }
      }
      if (alloc_ok)
        cout << cnt << endl;
      else
        cout << "NULL" << endl;
    } else if (str[0] == 'e') {
      if (state > 0 && l[state] != -1 && r[state] != -1 && state <= cnt) {
        for (int i = l[state]; i <= r[state]; i++) st[i] = 0;
        l[state] = -1;
        r[state] = -1;
      } else
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else if (str[0] == 'd') {
      for (int i = 1; i <= cnt; i++) {
        if (l[i] == -1) continue;
        int pos = 0;
        for (int j = 1; j <= l[i]; j++)
          if (!st[j]) pos++;
        l[i] -= pos;
        r[i] -= pos;
      }
      memset(st, 0, sizeof(st));
      for (int i = 1; i <= cnt; i++) {
        if (l[i] == -1) continue;
        for (int j = l[i]; j <= r[i]; j++) st[j] = 1;
      }
    }
  }
  return 0;
}
