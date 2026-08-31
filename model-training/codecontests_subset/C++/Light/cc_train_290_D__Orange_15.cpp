#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[101];
  int n;
  cin >> s >> n;
  int len = strlen(s);
  for (int i = 0; i < len; i++) {
    if (tolower(s[i]) < n + 97)
      s[i] = toupper(s[i]);
    else
      s[i] = tolower(s[i]);
  }
  cout << s << endl;
  return 0;
}
