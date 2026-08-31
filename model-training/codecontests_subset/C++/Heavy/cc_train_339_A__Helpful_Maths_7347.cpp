#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int i = 0, c1 = 0, c2 = 0, c3 = 0;
  if (s[0] == '1')
    c1++;
  else if (s[0] == '2')
    c2++;
  else
    c3++;
  i += 2;
  while (s[i - 1] != '\0') {
    if (s[i] == '1')
      c1++;
    else if (s[i] == '2')
      c2++;
    else
      c3++;
    i += 2;
  }
  i = 0;
  if (c1 != 0) {
    cout << "1";
    c1--;
  } else if (c2 != 0) {
    cout << "2";
    c2--;
  } else {
    cout << "3";
    c3--;
  }
  while (i < c1) {
    cout << "+1";
    i++;
  }
  i = 0;
  while (i < c2) {
    cout << "+2";
    i++;
  }
  i = 0;
  while (i < c3) {
    cout << "+3";
    i++;
  }
  return 0;
}
