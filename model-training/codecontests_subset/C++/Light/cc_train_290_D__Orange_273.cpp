#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int n;
  cin >> s;
  for (int i = 0; i < s.length(); i++)
    if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] - 'A' + 'a';
  cin >> n;
  for (int i = 0; i < s.length(); i++)
    if (s[i] < n + 97) s[i] = s[i] - 'a' + 'A';
  cout << s << endl;
  return 0;
}
