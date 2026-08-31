#include <bits/stdc++.h>
using namespace std;
int main() {
  int x1 = 0, x2 = 0, x3 = 0, x = 0;
  string str;
  cin >> str;
  for (int i = 0; i < str.size(); i++) {
    if (str[i] == '1')
      ++x1;
    else if (str[i] == '2')
      ++x2;
    else if (str[i] == '3')
      ++x3;
    else if (str[i] == '+')
      ++x;
    else
      return 0;
  }
  while (x1) {
    cout << "1";
    --x1;
    if (x) cout << "+";
    --x;
  }
  while (x2) {
    cout << "2";
    --x2;
    if (x) cout << "+";
    --x;
  }
  while (x3) {
    cout << "3";
    --x3;
    if (x) cout << "+";
    --x;
  }
  return 0;
}
