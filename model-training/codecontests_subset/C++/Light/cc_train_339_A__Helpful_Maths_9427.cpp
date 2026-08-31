#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  if (s.size() == 1)
    cout << s << endl;
  else {
    string ans;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '1') ans = ans + s[i] + '+';
    }
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '2') ans = ans + s[i] + '+';
    }
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == '3') ans = ans + s[i] + '+';
    }
    for (int i = 0; i < ans.size() - 1; i++) {
      cout << ans[i];
    }
    cout << endl;
  }
  return 0;
}
