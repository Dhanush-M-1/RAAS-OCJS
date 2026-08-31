#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, count = 0;
  cin >> k;
  char ch;
  string s;
  cin >> s;
  int l = s.length();
  sort(s.begin(), s.begin() + s.size());
  for (int i = 0; i < l; i++) {
    if (i % k == 0) {
      ch = s[i];
    }
    if (ch == s[i]) count++;
  }
  if (count == l && count % k == 0) {
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < l; j += k) {
        cout << s[j];
      }
    }
  } else
    cout << "-1";
  return 0;
}
