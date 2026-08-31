#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j;
  string s, s1 = "", s2 = "";
  cin >> s;
  for (int i = 0; i < s.length(); i++)
    if (s[i] != '+') s1 += s[i];
  sort(s1.begin(), s1.end());
  for (int i = 0; i < s1.length(); i++) {
    s2 += s1[i];
    s2 += "+";
  }
  s2.erase(s2.begin() + s2.length() - 1);
  cout << s2;
}
