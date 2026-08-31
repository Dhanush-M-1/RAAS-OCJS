#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n, f = 0;
  cin >> n;
  string st[n];
  for (int i = 0; i < n; ++i) {
    cin >> st[i];
    if (st[i] == s) f = 1;
  }
  if (f == 1) {
    cout << "YES";
    return 0;
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if ((st[i][1] == s[0] && st[j][0] == s[1])) {
        cout << "YES";
        return 0;
      }
    }
  }
  cout << "NO";
}
