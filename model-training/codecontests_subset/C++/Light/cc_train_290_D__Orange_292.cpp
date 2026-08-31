#include <bits/stdc++.h>
using namespace std;
string s, t;
int num;
int main() {
  cin >> s;
  cin >> num;
  int n = s.length();
  for (int i = 0; i < n; i++) {
    if (isupper(s[i])) s[i] = tolower(s[i]);
  }
  for (int i = 0; i < n; i++) {
    char u = s[i];
    if ((int)u < num + 97)
      t += toupper(s[i]);
    else
      t += tolower(s[i]);
  }
  cout << t << endl;
  return 0;
}
