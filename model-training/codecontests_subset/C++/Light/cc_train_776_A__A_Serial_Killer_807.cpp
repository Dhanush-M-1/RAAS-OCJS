#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  string s1, s2, s[1000], t[1000];
  cin >> s1;
  cin >> s2;
  cin >> n;
  for (i = 0; i < n; i++) cin >> s[i] >> t[i];
  cout << s1 << " " << s2 << "\n";
  if (s[0] != s1)
    s[0] = s1;
  else
    s[0] = s2;
  for (i = 1; i < n; i++) {
    if (s[i] == s[i - 1])
      s[i] = t[i - 1];
    else
      s[i] = s[i - 1];
  }
  for (i = 0; i < n; i++) cout << s[i] << " " << t[i] << "\n";
}
