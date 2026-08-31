#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> s >> n;
  for (typeof(0) i = (0); i < (((int)(s).size())); ++i) s[i] = tolower(s[i]);
  string ans;
  for (int i = 0; i < ((int)(s).size()); ++i) {
    char ch = s[i];
    if (ch < n + 97)
      ans += toupper(ch);
    else
      ans += tolower(ch);
  }
  cout << ans << endl;
  return 0;
}
