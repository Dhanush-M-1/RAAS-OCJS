#include <bits/stdc++.h>
using namespace std;
char toLow(char c) {
  if (c >= 'a' && c <= 'z') {
    return c;
  }
  return c - 'A' + 'a';
}
char toUp(char c) {
  c = toLow(c);
  return c - 'a' + 'A';
}
int main() {
  string s;
  cin >> s;
  int x;
  cin >> x;
  for (int i = 0; i < s.length(); i++) {
    if (toLow(s[i]) - 'a' < x) {
      s[i] = toUp(s[i]);
    } else {
      s[i] = toLow(s[i]);
    }
  }
  cout << s;
  return 0;
}
