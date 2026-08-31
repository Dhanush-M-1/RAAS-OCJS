#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int l = s.length();
  sort(s.begin(), s.end());
  s.erase(0, l / 2);
  for (int i = 0; i < l / 2; i++) {
    cout << s[i] << '+';
  }
  cout << s[(l / 2)];
}
