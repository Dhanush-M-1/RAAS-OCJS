#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, s1;
  cin >> s;
  char c;
  for (int i = 0; i < s.size(); i += 2) {
    s1 += s[i];
  }
  std::sort(s1.begin(), s1.end());
  if (s1.size() == 1)
    cout << s1;
  else {
    for (int i = 0; i <= s1.size() - 2; i++) cout << s1[i] << "+";
    cout << s1[s1.size() - 1];
  }
}
