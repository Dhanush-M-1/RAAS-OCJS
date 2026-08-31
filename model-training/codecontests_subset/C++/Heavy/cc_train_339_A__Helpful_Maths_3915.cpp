#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, a = 0, b = 0, c = 0;
  string s;
  cin >> s;
  for (i = 0; i < s.length(); i++) {
    if (s[i] == '1') a++;
  }
  for (i = 0; i < s.length(); i++) {
    if (s[i] == '2') b++;
  }
  for (i = 0; i < s.length(); i++) {
    if (s[i] == '3') c++;
  }
  for (i = 0; i < a - 1; i++) cout << "1+";
  if (b == 0 && c == 0 && a != 0)
    cout << "1";
  else if (a != 0)
    cout << "1+";
  for (i = 0; i < b - 1; i++) cout << "2+";
  if (c == 0 && b != 0)
    cout << "2";
  else if (b != 0)
    cout << "2+";
  for (i = 0; i < c - 1; i++) cout << "3+";
  if (c != 0) cout << "3";
  return 0;
  ;
}
