#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, s1;
  string s;
  cin >> s >> a;
  for (unsigned int i = 0; i < s.length(); i++) {
    s[i] = tolower(s[i]);
  }
  for (unsigned int i = 0; i < s.length(); i++) {
    s1 = s[i];
    if (s1 < a + 97) {
      s[i] = toupper(s[i]);
    }
  }
  cout << s;
  return 0;
}
