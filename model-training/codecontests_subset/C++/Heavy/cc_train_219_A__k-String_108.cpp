#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  while (cin >> k) {
    string s;
    cin >> s;
    sort(s.begin(), s.end());
    string ans;
    int cnt = 1, n = s.size();
    for (int i = 0; i < n; ++i) {
      if (i == n - 1 || s[i] != s[i + 1]) {
        if (cnt % k != 0) {
          ans = "-1";
          break;
        } else {
          for (int j = 0; j < cnt / k; ++j) {
            ans += s[i];
          }
          cnt = 1;
        }
      } else {
        ++cnt;
      }
    }
    if (ans != "-1") {
      string t = ans;
      for (int i = 1; i < k; ++i) {
        ans += t;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
