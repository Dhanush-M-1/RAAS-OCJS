#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int a;
  cin >> s >> a;
  for (int i = 0; i < s.size(); ++i) {
    s[i] = tolower(s[i]);
    if (s[i] < a + 97) {
      s[i] = toupper(s[i]);
    }
  }
  cout << s << endl;
  return 0;
}
