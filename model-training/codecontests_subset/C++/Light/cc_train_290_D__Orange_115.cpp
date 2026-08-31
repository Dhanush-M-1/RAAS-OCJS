#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  string s;
  char c;
  cin >> s >> a;
  for (int i = 0; i < s.size(); i++) {
    c = s[i];
    if ('A' <= c && c <= 'Z') c += 'a' - 'A';
    if (c < a + 97)
      s[i] = c - 'a' + 'A';
    else
      s[i] = c;
  }
  cout << s;
  cout << '\n';
  return 0;
}
