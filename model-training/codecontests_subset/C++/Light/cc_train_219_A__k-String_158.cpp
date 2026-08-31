#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, c = 0;
  cin >> k;
  string s, s1;
  cin >> s;
  int hash[26] = {0};
  for (int i = 0; i < s.size(); i++) {
    hash[s[i] - 'a']++;
  }
  int p;
  for (int i = 0; i < 26; i++) {
    if (hash[i] != 0 && hash[i] % k == 0) {
      p = hash[i] / k;
      while (p--) {
        s1 += char(i + 'a');
      }
    } else if (hash[i] != 0 && hash[i] % k != 0)
      c++;
  }
  string s2;
  while (k--) {
    s2 += s1;
  }
  if (c)
    cout << "-1";
  else
    cout << s2;
  return 0;
}
