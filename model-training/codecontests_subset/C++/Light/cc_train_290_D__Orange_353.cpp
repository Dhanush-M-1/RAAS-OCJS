#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a;
  while (cin >> s >> a) {
    int n = s.size();
    for (int i = 0; i < n; ++i) {
      s[i] = tolower(s[i]);
      if (s[i] < 'a' + a) {
        s[i] = toupper(s[i]);
      }
    }
    cout << s << endl;
  }
  return 0;
}
