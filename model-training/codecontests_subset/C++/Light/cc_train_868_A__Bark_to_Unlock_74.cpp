#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  int x = 0;
  int y = 0;
  for (int i = 0; i < n; i++) {
    string two;
    cin >> two;
    if (two[0] == s[0] && two[1] == s[1]) {
      cout << "YES" << endl;
      return 0;
    }
    if (s[0] == two[1]) {
      if (x == 0) {
        x += 1;
      }
    }
    if (two[0] == s[1]) {
      if (y == 0) {
        y += 1;
      }
    }
  }
  if (x + y == 2) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
