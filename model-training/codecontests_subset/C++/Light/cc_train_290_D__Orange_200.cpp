#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < s.length(); i++) {
    s[i] = tolower(s[i]);
  }
  for (int i = 0; i < s.length(); i++) {
    if (s[i] < 97 + n) {
      s[i] = toupper(s[i]);
    } else {
      s[i] = tolower(s[i]);
    }
  }
  cout << s << endl;
  return 0;
}
