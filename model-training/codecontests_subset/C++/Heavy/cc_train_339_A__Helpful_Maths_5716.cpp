#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int a = 0, b = 0, c = 0;
  int n = s.size();
  for (int i = 0; i < n; i++) {
    if (s[i] == '1') {
      a++;
    } else if (s[i] == '2') {
      b++;
    } else if (s[i] == '3') {
      c++;
    }
  }
  if (n == 1) {
    cout << s;
  } else {
    while (a--) {
      cout << 1;
      if (a == 0 && b == 0 && c == 0) {
      } else
        cout << "+";
    }
    a = 0;
    while (b--) {
      cout << 2;
      if (a == 0 && b == 0 && c == 0) {
      } else
        cout << "+";
    }
    b = 0;
    while (c--) {
      cout << 3;
      if (a == 0 && b == 0 && c == 0) {
      } else
        cout << "+";
    }
  }
}
