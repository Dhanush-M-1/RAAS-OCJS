#include <bits/stdc++.h>
using namespace std;
int main() {
  string str_27;
  getline(cin, str_27);
  int i16;
  cin >> i16;
  string res = "";
  for (int i26 = 0; i26 < str_27.size(); i26++) {
    char c19 = tolower(str_27[i26]);
    if (c19 < i16 + 97) {
      res.push_back(toupper(c19));
    } else {
      res.push_back(tolower(c19));
    }
  }
  cout << res;
  return 0;
}
