#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j;
  int k;
  string s;
  while (cin >> k) {
    j = 0;
    cin >> s;
    sort(s.begin(), s.end());
    for (i = 0; i < s.length(); i++) {
      if (i % k == 0) j = i;
      if (s[i] != s[j]) break;
    }
    if (i < s.length() || s.length() % k)
      cout << "-1";
    else
      for (i = 0; i < k; i++)
        for (j = i; j < s.length(); j += k) cout << s[j];
    cout << endl;
  }
  return 0;
}
