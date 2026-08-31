#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, l, count = 0;
  char ch;
  string s;
  cin >> k;
  cin >> s;
  l = s.size();
  sort(s.begin(), s.begin() + s.size());
  for (int i = 0; i < s.size(); i++) {
    if (i % k == 0) {
      ch = s[i];
    }
    if (s[i] == ch) {
      count++;
    }
  }
  if (l == count && count % k == 0) {
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < s.size(); j += k) {
        cout << s[j];
      }
    }
  } else {
    cout << "-1";
  }
  return 0;
}
