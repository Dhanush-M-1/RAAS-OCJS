#include <bits/stdc++.h>
using namespace std;
string s;
int n, i;
int main() {
  getline(cin, s);
  cin >> n;
  for (i = 0; i < s.length(); i++)
    if (s[i] < 'a') s[i] = (char)((int)s[i] + 32);
  for (i = 0; i < s.length(); i++) {
    if ((int)s[i] < (char)(n + 97)) {
      if (s[i] >= 'a') s[i] = (char)((int)s[i] - 32);
    } else if (s[i] < 'a')
      s[i] = (char)((int)s[i] + 32);
  }
  cout << s << endl;
  return 0;
}
