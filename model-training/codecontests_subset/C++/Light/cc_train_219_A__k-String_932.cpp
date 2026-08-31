#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, n, i, c = 0, j;
  string s, str;
  map<char, int> mp;
  cin >> k;
  cin >> s;
  sort(s.begin(), s.end());
  for (i = 0; i < s.size(); i++) {
    mp[s[i]]++;
  }
  n = s.size();
  for (char ch = 'a'; ch <= 'z'; ch++) {
    if (mp[ch] >= 1 && mp[ch] % k != 0) {
      cout << -1;
      return 0;
    }
  }
  while (c < n) {
    for (char ch = 'a'; ch <= 'z' && c < n; ch++) {
      if (mp[ch] >= 1) {
        for (j = 1; j <= mp[ch] / k && c < n; j++) {
          cout << ch;
          c++;
        }
      }
    }
  }
  return 0;
}
