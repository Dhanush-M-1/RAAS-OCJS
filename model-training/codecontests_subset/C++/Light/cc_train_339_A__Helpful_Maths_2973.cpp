#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int c1 = 0, c2 = 0, c3 = 0, i, flag = 0;
  cin >> s;
  for (i = 0; i < s.size(); i++) {
    if (s[i] == '1')
      c1++;
    else if (s[i] == '2')
      c2++;
    else if (s[i] == '3')
      c3++;
  }
  while (c1--) {
    if (flag == 0) {
      cout << 1;
      flag = 1;
    } else
      cout << "+" << 1;
  }
  while (c2--) {
    if (flag == 0) {
      cout << 2;
      flag = 1;
    } else
      cout << "+" << 2;
  }
  while (c3--) {
    if (flag == 0) {
      cout << 3;
      flag = 1;
    } else
      cout << "+" << 3;
  }
  return 0;
}
