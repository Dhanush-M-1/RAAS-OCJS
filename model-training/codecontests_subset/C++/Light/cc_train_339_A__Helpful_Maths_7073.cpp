#include <bits/stdc++.h>
using namespace std;
string s1;
string s2 = "";
int main() {
  cin >> s1;
  for (int i = 0; i < s1.length(); i++)
    if (i % 2 == 0) s2 += s1[i];
  sort(s2.begin(), s2.end());
  for (int i = 0; i < s2.length(); i++) {
    cout << s2[i];
    if (i != s2.length() - 1) cout << '+';
  }
  return 0;
}
