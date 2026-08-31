#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < s.size(); i++)
    if (s[i] >= 'A' and s[i] < 'a') s[i] = 'a' + (s[i] - 'A');
  for (int i = 0; i < (int)s.size(); i++) {
    char tmp = s[i];
    if (tmp < (n + 97)) {
      s[i] = 'A' + s[i] - 'a';
    } else {
    }
  }
  cout << s << endl;
  return 0;
}
