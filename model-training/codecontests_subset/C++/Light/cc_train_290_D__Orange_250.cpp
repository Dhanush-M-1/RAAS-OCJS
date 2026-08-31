#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int t;
  getline(cin, s);
  cin >> t;
  for (int i = 0; i < s.length(); i++)
    if (s[i] >= 'A' && s[i] <= 'Z') {
      s[i] = s[i] - 'A' + 'a';
    }
  for (int i = 0; i < s.length(); i++) {
    char c = s[i];
    if (c < t + 97) {
      s[i] = s[i] - 'a' + 'A';
    }
  }
  cout << s << endl;
  return 0;
}
