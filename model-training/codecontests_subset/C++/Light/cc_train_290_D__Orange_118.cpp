#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  string ss;
  int num;
  cin >> s >> num;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] = (char)((int)s[i] - 'A' + 'a');
  }
  for (int i = 0; i < s.size(); i++) {
    char c = s[i];
    if ((int)c < num + 97) {
      ss += (char)((int)c - 'a' + 'A');
    } else {
      ss += c;
    }
  }
  cout << ss << endl;
  return 0;
}
