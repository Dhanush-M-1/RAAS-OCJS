#include <bits/stdc++.h>
using namespace std;
char to_da(char c) {
  if (c >= 'A' && c <= 'Z')
    return c;
  else
    return c - 32;
}
char to_xiao(char c) {
  if (c >= 'A' && c <= 'Z')
    return c + 32;
  else
    return c;
}
int main() {
  string s;
  int a;
  while (cin >> s >> a) {
    int len = s.length();
    for (int i = 0; i < len; i++) {
      s[i] = to_xiao(s[i]);
      if (s[i] < a + 97)
        s[i] = to_da(s[i]);
      else
        s[i] = to_xiao(s[i]);
    }
    cout << s << endl;
  }
  return 0;
}
