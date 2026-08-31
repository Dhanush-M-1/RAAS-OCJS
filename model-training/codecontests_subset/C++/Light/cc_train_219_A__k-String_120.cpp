#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s, ans;
  cin >> s;
  int a[26] = {0};
  for (int i = 0; i < s.length(); i++) {
    a[s[i] - 'a']++;
  }
  int t;
  for (int i = 0; i < 26; i++) {
    if (a[i] % k == 0) {
      t = a[i] / k;
      while (t--) ans += (i + 'a');
    } else {
      cout << "-1";
      return 0;
    }
  }
  for (int i = 0; i < k; i++) cout << ans;
}
