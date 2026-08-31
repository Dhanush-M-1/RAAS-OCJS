#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int x;
  cin >> x;
  string k = s;
  s = "";
  for (int i = 0, _e(k.size()); i < _e; i++) s += tolower(k[i]);
  string res = "";
  for (int i = 0, _e(s.size()); i < _e; i++) {
    char k = s[i];
    if (k < x + 97)
      res += toupper(k);
    else
      res += tolower(k);
  }
  cout << res << endl;
  return 0;
}
