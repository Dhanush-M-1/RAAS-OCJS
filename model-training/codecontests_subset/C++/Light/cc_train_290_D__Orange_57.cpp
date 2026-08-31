#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int t;
  cin >> s >> t;
  for (int i = 0; i < s.size(); i++) {
    s[i] &= ~32;
    if (s[i] >= 'A' + t) {
      s[i] ^= 32;
    }
  }
  cout << s << endl;
}
