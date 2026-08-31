#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[101];
  int i, flag, c1, c2, c3, l;
  while (cin >> s) {
    c1 = 0;
    c2 = 0;
    c3 = 0;
    for (i = 0, l = strlen(s); i < l; i += 2) {
      if (s[i] == '1')
        c1++;
      else if (s[i] == '2')
        c2++;
      else
        c3++;
    }
    flag = 0;
    for (i = 0; i < c1; i++) {
      if (flag) cout << "+";
      cout << "1";
      flag = 1;
    }
    for (i = 0; i < c2; i++) {
      if (flag) cout << "+";
      cout << "2";
      flag = 1;
    }
    for (i = 0; i < c3; i++) {
      if (flag) cout << "+";
      cout << "3";
      flag = 1;
    }
    cout << "\n";
  }
  return 0;
}
