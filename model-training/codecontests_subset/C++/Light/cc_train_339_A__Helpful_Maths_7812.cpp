#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, ans;
  cin >> s;
  if (s.size() / sizeof(s[0]) < 2) {
    cout << s;
    return 0;
  }
  for (int j = 0; j < s.size(); j++) {
    for (int i = 0; i < s.size() - 2; i++) {
      if (int(s[i]) > int(s[i + 2])) {
        int x = s[i];
        s[i] = s[i + 2];
        s[i + 2] = x;
      }
      i++;
    }
  }
  cout << s;
}
