#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, s1;
  cin >> s;
  sort(s.begin(), s.end());
  for (int i = 0; i < s.size(); i++) {
    if (s[i] != '+') {
      s1 += s[i];
    }
  }
  for (int i = 0; i < s1.size(); i++) {
    if (i == s1.size() - 1)
      cout << s1[i];
    else
      cout << s1[i] << "+";
  }
  return 0;
}
