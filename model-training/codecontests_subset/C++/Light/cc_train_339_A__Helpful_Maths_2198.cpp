#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int e = s.size();
  sort(s.begin(), s.end());
  for (int i = (s.size() / 2); i < s.size() - 1; i++) {
    cout << s[i] << "+";
  }
  cout << s[s.size() - 1];
  return 0;
}
