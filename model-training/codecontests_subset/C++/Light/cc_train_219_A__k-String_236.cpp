#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, l, i, f = 0, j;
  char c;
  string s;
  cin >> k >> s;
  sort(s.begin(), s.end());
  l = s.length();
  for (i = 0; i < l; i++) {
    if (i % k == 0) {
      c = s[i];
    }
    if (c == s[i]) {
      f++;
    }
  }
  if (f == l && f % k == 0) {
    for (i = 0; i < k; i++) {
      for (j = 0; j < l; j += k) {
        cout << s[j];
      }
    }
    cout << endl;
  } else {
    cout << "-1" << endl;
  }
}
