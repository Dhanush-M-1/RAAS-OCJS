#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, q, r, t;
  string s;
  cin >> s;
  int n;
  cin >> n;
  string a[n];
  for (i = 0; i < n; i++) cin >> a[i];
  int temp = 0;
  for (i = 0; i < n; i++) {
    if (a[i] == s) {
      temp = 1;
      cout << "YES";
      break;
    }
  }
  if (!temp) {
    temp = 0;
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        if (a[i][1] == s[0] && a[j][0] == s[1]) {
          temp = 1;
          cout << "YES";
          break;
        }
      }
      if (temp) break;
    }
    if (!temp) {
      cout << "NO";
    }
  }
  return 0;
}
