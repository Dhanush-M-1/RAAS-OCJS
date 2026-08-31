#include <bits/stdc++.h>
using namespace std;
int main() {
  int i;
  string s;
  cin >> s;
  sort(s.begin(), s.end());
  for (int i = s.size() / 2; i < s.size(); i++) {
    if (i == s.size() - 1)
      cout << s[i];
    else
      cout << s[i] << '+';
  }
  cout << endl;
  return 0;
}
