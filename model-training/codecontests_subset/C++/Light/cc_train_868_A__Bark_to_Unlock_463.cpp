#include <bits/stdc++.h>
using namespace std;
int main() {
  int n = 0;
  bool check = false;
  bool check2 = false;
  char *str = new char[2];
  cin >> str >> n;
  for (int i = 0; i < n; i++) {
    string str3;
    cin >> str3;
    if (str == str3) {
      check = true;
      check2 = true;
      break;
    }
    if (str3[0] == str[1] || str3[1] == str[0]) {
      if (str3[0] == str[1]) {
        check = true;
      }
      if (str3[1] == str[0]) {
        check2 = true;
      }
    }
  }
  if (check && check2) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
