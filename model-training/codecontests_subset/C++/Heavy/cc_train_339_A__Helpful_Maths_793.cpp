#include <bits/stdc++.h>
using namespace std;
int main() {
  int one = 0, two = 0, three = 0;
  string a;
  string s;
  cin >> s;
  int n = s.length();
  for (int i = 0; i < n; i += 2) {
    if (s[i] == '1') {
      one++;
    } else {
      if (s[i] == '2') {
        two++;
      } else {
        three++;
      }
    }
  }
  for (int i = 0; i < one - 1; i++) {
    cout << "1+";
  }
  if (one > 0) {
    if (three == 0 && two == 0) {
      cout << '1';
    } else {
      cout << "1+";
    }
  }
  for (int i = 0; i < two - 1; i++) {
    cout << "2+";
  }
  if (two > 0) {
    if (three == 0) {
      cout << '2';
    } else {
      cout << "2+";
    }
  }
  for (int i = 0; i < three - 1; i++) {
    cout << "3+";
  }
  if (three > 0) {
    cout << '3';
  }
}
