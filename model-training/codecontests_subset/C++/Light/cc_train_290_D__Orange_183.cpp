#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, r;
  cin >> s;
  int a;
  cin >> a;
  for (long i = 0; i < s.size(); i++) s[i] = tolower(s[i]);
  for (long i = 0; i < s.size(); i++) {
    char c = s[i];
    if (c < a + 97)
      r += toupper(c);
    else
      r += tolower(c);
  }
  cout << r;
  return 0;
}
