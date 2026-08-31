#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j;
  string s;
  char c;
  getline(cin, s);
  for (i = 0; i < s.length(); i++)
    for (j = i + 1; j < s.length(); j++)
      if (isdigit(s[i]) && isdigit(s[j]) && s[i] >= s[j]) {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
      }
  cout << s;
  return 0;
}
