#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  long long n;
  cin >> n;
  for (long long i = 0; i < s.size(); i++) s[i] = tolower(s[i]);
  string ans = "";
  for (long long i = 0; i < s.size(); i++) {
    if (s[i] >= n + 97)
      ans += tolower(s[i]);
    else
      ans += toupper(s[i]);
  }
  cout << ans << endl;
}
