#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  cin >> str;
  int one = 0, two = 0, three = 0;
  for (int i = 0; i < str.length(); i += 2) {
    if ((str[i] - '0') == 1) {
      one += 1;
    } else if ((str[i] - '0') == 2) {
      two += 1;
    } else if ((str[i] - '0') == 3) {
      three += 1;
    }
  }
  for (int i = 0; i < str.length(); i += 2) {
    if (one > 0) {
      str[i] = '1';
      one--;
    } else if (two > 0) {
      str[i] = '2';
      two--;
    } else if (three > 0) {
      str[i] = '3';
      three--;
    }
  }
  cout << str;
  return 0;
}
