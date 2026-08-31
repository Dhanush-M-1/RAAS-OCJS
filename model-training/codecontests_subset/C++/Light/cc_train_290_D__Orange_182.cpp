#include <bits/stdc++.h>
using namespace std;
const double PI = 3.1415926535;
int main() {
  string s, ans = "";
  int t;
  cin >> s;
  cin >> t;
  for (int i = 0; i < s.size(); ++i) s[i] = tolower(s[i]);
  for (int i = 0; i < s.size(); ++i) {
    char c = s[i];
    if ((int)c < t + 97)
      ans += toupper(c);
    else
      ans += c;
  }
  cout << ans;
  return 0;
}
