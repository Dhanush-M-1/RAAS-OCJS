#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  string o;
  int n;
  cin >> s >> n;
  for (int i = 0; i < (int)s.size(); i++) {
    if (isupper(s[i])) s[i] = tolower(s[i]);
  }
  for (int i = 0; i < (int)s.size(); i++) {
    char d = s[i];
    if (d < n + 97) {
      o += toupper(d);
    } else {
      o += tolower(d);
    }
  }
  cout << o << endl;
  return 0;
}
