#include <bits/stdc++.h>
using namespace std;
bool Check(char x) {
  if (x <= '3' && x >= '1')
    return true;
  else
    return false;
}
int main() {
  char s[1000];
  cin >> s;
  char x;
  for (int i = 0; i < strlen(s); ++i) {
    for (int j = i + 1; j < strlen(s); ++j) {
      if (s[j] < s[i] && Check(s[i]) && Check(s[j])) {
        x = s[i];
        s[i] = s[j];
        s[j] = x;
      }
    }
  }
  for (int i = 0; i < strlen(s); i++) {
    cout << s[i];
  }
  return 0;
}
