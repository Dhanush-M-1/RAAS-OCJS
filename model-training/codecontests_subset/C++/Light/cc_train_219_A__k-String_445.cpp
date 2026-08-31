#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int sz = 2e5 + 10;
int k, fl, ar[26];
string s;
int main() {
  while (cin >> k >> s) {
    memset(ar, 0, sizeof ar);
    for (char c : s) {
      ar[c - 'a']++;
    }
    fl = 1;
    for (int i = 0; i < 26; i++)
      if (ar[i] % k) fl = 0;
    if (fl) {
      string ans;
      for (int i = 0; i < 26; i++) {
        if (ar[i]) ans += string(ar[i] / k, i + 'a');
      }
      for (int i = k; i > 0; i--) {
        cout << ans;
      }
      cout << "\n";
    } else {
      cout << "-1\n";
    }
  }
  return 0;
}
