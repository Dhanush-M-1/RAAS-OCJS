#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[1005];
  int s2[1005];
  while (cin >> s) {
    int m = strlen(s), l = 0;
    if (m == 1) {
      cout << s << endl;
      continue;
    }
    for (int i = 0; i < m; i++) {
      if (s[i] != '+') s2[l++] = s[i] - '0';
    }
    sort(s2, s2 + l);
    cout << s2[0];
    for (int i = 1; i < l; i++) printf("+%d", s2[i]);
    cout << endl;
  }
  return 0;
}
