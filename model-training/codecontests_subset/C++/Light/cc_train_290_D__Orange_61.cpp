#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, sz;
  string str, ans = "";
  cin >> str;
  cin >> x;
  sz = str.size();
  for (int i = 0; i < sz; i++) {
    str[i] = tolower(str[i]);
    if (str[i] < x + 97) str[i] = toupper(str[i]);
  }
  cout << str << endl;
  return 0;
}
