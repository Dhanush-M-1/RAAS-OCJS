#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  string res;
  std::transform(s.begin(), s.end(), s.begin(), ::tolower);
  for (int i = 0; i < s.length(); i++) {
    char c = s[i];
    if (c < n + 97) {
      res = res + (char)toupper(c);
    } else {
      res = res + (char)tolower(c);
    }
  }
  cout << res;
  return 0;
}
