#include <bits/stdc++.h>
int main() {
  int k, c = 0;
  std ::cin >> k;
  std ::string s;
  std ::cin >> s;
  std ::sort(s.begin(), s.end());
  std ::vector<int> v;
  std ::vector<char> v1, v2;
  for (int i = 0; i < s.length(); ++i) {
    c++;
    if (s[i] != s[i + 1] || i == s.length() - 1) {
      if (c % k != 0) {
        std ::cout << -1;
        return 0;
      } else {
        v.push_back(c / k);
        c = 0;
      }
    }
  }
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] == s[i + 1]) {
      s.erase(i + 1, 1);
      i--;
    }
  }
  for (int i = 0; i < s.size(); ++i) {
    v1.push_back(s[i]);
  }
  for (int i = 0; i < v1.size(); ++i) {
    for (int j = 0; j < v[i]; ++j) {
      v2.push_back(v1[i]);
    }
  }
  while (k--) {
    for (int i = 0; i < v2.size(); ++i) {
      std ::cout << v2[i];
    }
  }
  return 0;
}
