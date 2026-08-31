#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  int n, c;
  c = 0;
  string s;
  cin >> n;
  cin >> s;
  if (n < 11) {
    cout << "0" << endl;
  } else {
    for (int i = 0; i < s.length(); i++) {
      if (s[i] == '8') {
        c++;
      }
    }
    if (c == 0) {
      cout << "0" << endl;
    } else {
      if (c == 1)
        cout << "1" << endl;
      else {
        for (int x = 1;; x++) {
          if (n < 11 * x) {
            if (c >= x - 1) {
              cout << x - 1 << endl;
              exit(0);
            } else {
              cout << c << endl;
              exit(0);
            }
          }
        }
      }
    }
  }
}
