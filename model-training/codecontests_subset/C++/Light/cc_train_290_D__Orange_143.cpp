#include <bits/stdc++.h>
using namespace std;
char uppercase(char x) {
  if (x >= 'a' && x <= 'z')
    return x + 'A' - 'a';
  else
    return x;
}
char lowercase(char x) {
  if (x >= 'A' && x <= 'Z')
    return x - 'A' + 'a';
  else
    return x;
}
int main() {
  string s;
  int a;
  cin >> s >> a;
  for (int i = 0; i < (int)s.size(); i++) s[i] = lowercase(s[i]);
  for (int i = 0; i < (int)s.size(); i++) {
    char temp = s[i];
    if (temp < a + 97)
      temp = uppercase(temp);
    else
      temp = lowercase(temp);
    s[i] = temp;
  }
  cout << s << endl;
  return 0;
}
