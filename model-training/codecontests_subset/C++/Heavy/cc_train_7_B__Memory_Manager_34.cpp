#include <bits/stdc++.h>
using namespace std;
int a[100 + 5];
char s[15];
int t, m;
int check(int x, int c) {
  int i, j, f;
  for (i = 1; i <= m - x + 1; i++) {
    f = 0;
    for (j = i; j < i + x; j++)
      if (a[j] != 0) f = 1;
    if (f == 0) {
      for (j = i; j < i + x; j++) a[j] = c;
      return 1;
    }
  }
  return 0;
}
int main() {
  int i, j, c, x, f;
  while (cin >> t >> m) {
    c = 1;
    memset(a, 0, sizeof(a));
    while (t--) {
      cin >> s;
      if (s[0] == 'a') {
        cin >> x;
        if (check(x, c) == 1)
          cout << c++ << endl;
        else
          cout << "NULL" << endl;
      } else if (s[0] == 'e') {
        cin >> x;
        if (x == 0)
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        else {
          f = 0;
          for (i = 1; i <= m; i++) {
            if (a[i] == x) {
              a[i] = 0;
              f = 1;
            }
          }
          if (f == 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        }
      } else if (s[0] == 'd') {
        i = j = 1;
        while (j <= m) {
          a[i] = a[j];
          if (a[i] != 0) {
            if (j > i) a[j] = 0;
            i++;
          }
          j++;
        }
      }
    }
  }
  return 0;
}
