#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int i, p, count = 0;
  int H[3];
  memset(H, 0, sizeof(H));
  for (i = 0; i < s.size(); i = i + 2) {
    if (s[i] == '1') {
      H[0] += 1;
    } else if (s[i] == '2') {
      H[1] += 1;
    } else {
      H[2] += 1;
    }
  }
  if (s.size() == 1) {
    cout << s[0];
  } else {
    for (i = 0; i < 3; i++) {
      p = H[i];
      while (p) {
        cout << i + 1;
        count++;
        if (count == s.size()) {
          cout << "";
        } else {
          cout << '+';
        }
        count++;
        p--;
      }
    }
  }
  return 0;
}
