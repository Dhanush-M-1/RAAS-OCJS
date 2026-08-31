#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  char temp;
  for (int i = 0; i < s.length(); i++) {
    for (int j = i; j < s.length(); j++) {
      if (s[i] == '3' && s[j] == '1' || s[i] == '3' && s[j] == '2' ||
          s[i] == '2' && s[j] == '1') {
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
      }
    }
  }
  cout << s;
}
