#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int num1 = 0;
  int num2 = 0;
  int num3 = 0;
  cin >> s;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == '1') {
      num1++;
    } else if (s[i] == '2') {
      num2++;
    } else if (s[i] == '3') {
      num3++;
    }
  }
  for (int j = 0; j < num1; j++) {
    if (j == 0) {
      cout << "1";
    } else {
      cout << "+1";
    }
  }
  for (int k = 0; k < num2; k++) {
    if (k == 0 && num1 == 0) {
      cout << "2";
    } else {
      cout << "+2";
    }
  }
  for (int l = 0; l < num3; l++) {
    if (l == 0 && num1 == 0 && num2 == 0) {
      cout << "3";
    } else {
      cout << "+3";
    }
  }
  return 0;
}
