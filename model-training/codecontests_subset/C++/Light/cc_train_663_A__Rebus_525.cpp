#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  int addcnt = 1, recnt = 0, n, n0;
  getline(cin, str);
  int pos = 0;
  while ((pos = str.find_first_of("+-", pos)) != string::npos) {
    if (str[pos] == '+')
      addcnt++;
    else
      recnt++;
    pos++;
  }
  n0 = n = stoi(str.substr(str.find_first_of("1234567890")));
  n0 = max(n + recnt, addcnt);
  if (n0 / addcnt + (n0 % addcnt != 0) > n || addcnt > n * (recnt + 1))
    cout << "Impossible" << endl;
  else {
    cout << "Possible" << endl;
    if (n0 == addcnt) {
      int negcnt = 0;
      bool positive = true;
      for (int i = 0; i < str.length(); i++) {
        if (str[i] == '?') {
          if (positive)
            cout << 1;
          else {
            cout << (addcnt - n) / recnt + (negcnt++ < (addcnt - n) % recnt);
          }
        } else {
          if (str[i] == '+') positive = true;
          if (str[i] == '-') positive = false;
          cout << str[i];
        }
      }
    } else {
      int poscnt = 0;
      bool positive = true;
      for (int i = 0; i < str.length(); i++) {
        if (str[i] == '?') {
          if (positive) {
            cout << n0 / addcnt + (poscnt++ < n0 % addcnt);
          } else
            cout << 1;
        } else {
          if (str[i] == '+') positive = true;
          if (str[i] == '-') positive = false;
          cout << str[i];
        }
      }
      cout << endl;
    }
  }
  return 0;
}
