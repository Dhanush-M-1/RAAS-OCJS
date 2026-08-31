#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  s.erase(std::remove(s.begin(), s.end(), '+'), s.end());
  sort(s.begin(), s.end());
  cout << s[0];
  for (int i = 1; i < s.size(); i++) cout << '+' << s[i];
  return 0;
}
