#include <bits/stdc++.h>
using namespace std;
int a;
string s;
int main() {
  cin >> s >> a;
  for (int i = 0; i < s.size(); i++) s[i] = tolower(s[i]);
  for (int i = 0; i < s.size(); i++)
    if (s[i] - 'a' < a) s[i] = toupper(s[i]);
  cout << s << endl;
  return 0;
}
