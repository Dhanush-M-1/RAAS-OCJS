#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int no1 = 0, no2 = 0, no3 = 0, nop = 0;
  cin >> s;
  int i;
  for (i = 0; i < s.length(); i++) {
    if (s[i] == '1') no1++;
    if (s[i] == '2') no2++;
    if (s[i] == '3') no3++;
    if (s[i] == '+') nop++;
  }
  for (i = 0; i < no1; i++) {
    cout << "1";
    if (nop > 0) {
      cout << "+";
      nop--;
    }
  }
  for (i = 0; i < no2; i++) {
    cout << "2";
    if (nop > 0) {
      cout << "+";
      nop--;
    }
  }
  for (i = 0; i < no3; i++) {
    cout << "3";
    if (nop > 0) {
      cout << "+";
      nop--;
    }
  }
  return 0;
}
