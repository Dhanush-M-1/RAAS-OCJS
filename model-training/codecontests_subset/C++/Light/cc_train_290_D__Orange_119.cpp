#include <bits/stdc++.h>
#pragma comment(linker, "/stack:256000000")
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  for (int i = 0; i < (int)(s).size(); i++) {
    int x;
    if (islower(s[i]))
      x = s[i] - 'a';
    else
      x = s[i] - 'A';
    if (x < n) {
      if (islower(s[i])) s[i] = toupper(s[i]);
    } else {
      if (isupper(s[i])) s[i] = tolower(s[i]);
    }
  }
  cout << s;
  return 0;
}
