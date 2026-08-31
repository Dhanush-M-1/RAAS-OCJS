#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  string c;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] < 'a') s[i] = s[i] + 32;
  }
  for (int i = 0; i < s.size(); i++) {
    char e = s[i];
    if (e < n + 97) {
      if (e < 'a')
        c = c + e;
      else {
        e = e - 32;
        c = c + (e);
      }
    } else
      c = c + e;
  }
  cout << c << endl;
}
