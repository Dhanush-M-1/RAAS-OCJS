#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a;
  cin >> s >> a;
  transform(s.begin(), s.end(), s.begin(), ::tolower);
  char c = (char)('a' + a);
  for (int i = 0; i < s.size(); i++) {
    if (s[i] < c)
      s[i] = toupper(s[i]);
    else
      s[i] = tolower(s[i]);
  }
  cout << s << endl;
  return 0;
}
