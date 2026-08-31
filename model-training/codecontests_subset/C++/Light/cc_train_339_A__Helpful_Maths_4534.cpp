#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, i, l, v;
  string s;
  getline(cin, s);
  l = s.length();
  for (i = 0; i < l - 2; i++) {
    for (int j = 0; j < l - 1; j = j + 2) {
      if (s[j] > s[j + 2]) {
        int t = s[j];
        s[j] = s[j + 2];
        s[j + 2] = t;
      }
    }
  }
  cout << s;
  return 0;
}
