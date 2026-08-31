#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int len = s.length();
  sort(s.begin(), s.end());
  for (int i = 0; i < len - 1; i++) {
    if (s[i] == '+') continue;
    cout << s[i] << "+";
  }
  cout << s[len - 1];
  return 0;
}
