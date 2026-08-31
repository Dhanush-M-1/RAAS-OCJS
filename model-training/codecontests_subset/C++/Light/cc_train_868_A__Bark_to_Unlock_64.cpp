#include <bits/stdc++.h>
using namespace std;
string toupper_str(string s) {
  transform(s.begin(), s.end(), s.begin(), ::toupper);
  return s;
}
string tolower_str(string s) {
  transform(s.begin(), s.end(), s.begin(), ::tolower);
  return s;
}
int main() {
  string p, s;
  int n, f = 0;
  cin >> p >> n;
  map<char, int> mp1, mp2;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s == p) {
      cout << "YES\n";
      f = 1;
    }
    mp1[s[0]]++, mp2[s[1]]++;
  }
  if (f == 0) {
    if (mp2[p[0]] > 0 && mp1[p[1]] > 0)
      cout << "YES\n";
    else
      cout << "NO\n";
  }
  return 0;
}
