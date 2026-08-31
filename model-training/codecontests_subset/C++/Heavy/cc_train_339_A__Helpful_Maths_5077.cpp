#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int c1, c2, c3;
  c1 = c2 = c3 = 0;
  cin >> str;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '+') {
      str.erase(i, 1);
      i--;
    }
  }
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '1')
      c1++;
    else if (str[i] == '2')
      c2++;
    else
      c3++;
  }
  if (c1 == 0) {
    if (c2 == 0) {
      if (c3 == 0)
        cout << "";
      else {
        cout << "3";
        for (int i = 0; i < c3 - 1; i++) {
          cout << "+3";
        }
      }
    } else {
      if (c3 == 0) {
        cout << "2";
        for (int i = 0; i < c2 - 1; i++) {
          cout << "+2";
        }
      } else {
        cout << "2";
        for (int i = 0; i < c2 - 1; i++) {
          cout << "+2";
        }
        for (int i = 0; i < c3; i++) {
          cout << "+3";
        }
      }
    }
  } else {
    cout << "1";
    for (int i = 0; i < c1 - 1; i++) {
      cout << "+1";
    }
    if (c2 == 0) {
      if (c3 == 0)
        cout << "";
      else {
        for (int i = 0; i < c3; i++) {
          cout << "+3";
        }
      }
    } else {
      if (c3 == 0) {
        for (int i = 0; i < c2; i++) {
          cout << "+2";
        }
      } else {
        for (int i = 0; i < c2; i++) {
          cout << "+2";
        }
        for (int i = 0; i < c3; i++) {
          cout << "+3";
        }
      }
    }
  }
  return 0;
}
