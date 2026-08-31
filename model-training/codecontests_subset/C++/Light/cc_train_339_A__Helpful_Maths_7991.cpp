#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  string str = "";
  for (char ch : s)
    if (ch != '+') str += ch;
  sort(str.begin(), str.end());
  for (int i = 0; i < str.size(); i++) {
    if (i == str.size() - 1)
      cout << str[i];
    else
      cout << str[i] << "+";
  }
  return 0;
}
