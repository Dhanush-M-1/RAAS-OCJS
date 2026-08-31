#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, q = "";
  cin >> s;
  int n;
  cin >> n;
  transform(s.begin(), s.end(), s.begin(), ::tolower);
  for (int i = 0; i < s.length(); i++) {
    char c = s[i];
    if (c < n + 97) {
      if (c > 'Z') {
        c -= 'a';
        c += 'A';
      }
      q += c;
    } else {
      if (c < 'A') {
        c -= 'A';
        c += 'a';
      }
      q += c;
    }
  }
  cout << q;
}
