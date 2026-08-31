#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, s1 = "";
  cin >> s;
  for (int i = 0; i < s.length(); i++)
    if (s[i] != '+') s1.push_back(s[i]);
  sort(s1.begin(), s1.end());
  for (int i = 0; i < s1.length() - 1; i++) cout << s1[i] << '+';
  cout << s1[s1.length() - 1];
  return 0;
}
