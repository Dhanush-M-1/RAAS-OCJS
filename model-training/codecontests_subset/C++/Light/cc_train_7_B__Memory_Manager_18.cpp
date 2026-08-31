#include <bits/stdc++.h>
using namespace std;
int i, j, t, m, k = 0, f[1000], f1[1000], p, q;
int main() {
  string s;
  cin >> t >> m;
  memset(f, 0, sizeof(f));
  getline(cin, s);
  for (i = 1; i <= t; i++) {
    getline(cin, s);
    if (s[0] == 'a') {
      int x = 0;
      for (j = 6; j < s.size(); j++) x = x * 10 + s[j] - 48;
      p = 1;
      bool flag = false;
      while (p <= m) {
        while (f[p] != 0 && p <= m) p++;
        q = p;
        while (f[q] == 0 && q <= m) q++;
        if (q - p >= x) {
          k++;
          cout << k << endl;
          for (j = p; j <= p + x - 1; j++) f[j] = k;
          flag = true;
          break;
        }
        p = q;
      }
      if (flag == false) cout << "NULL" << endl;
    } else if (s[0] == 'e') {
      p = 1;
      int x = 0;
      for (j = 6; j < s.size(); j++) x = x * 10 + s[j] - 48;
      while (f[p] != x && p <= m) p++;
      if (p > m || x == 0)
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        while (f[p] == x && p <= m) {
          f[p] = 0;
          p++;
        }
      }
    } else {
      int d = 0;
      memset(f1, 0, sizeof(f1));
      for (j = 1; j <= m; j++)
        if (f[j] != 0) f1[++d] = f[j];
      memcpy(f, f1, sizeof(f));
    }
  }
  return 0;
}
