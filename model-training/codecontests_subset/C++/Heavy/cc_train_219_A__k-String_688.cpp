#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int k;
  cin >> k;
  string s;
  cin >> s;
  int i;
  int len = s.length();
  if (len % k != 0) {
    cout << -1 << "\n";
    return 0;
  }
  int new_len = len / k;
  vector<int> c(26, 0);
  for (i = 0; i < len; i++) {
    c[s[i] - 'a'] += 1;
  }
  string ans = "";
  for (i = 0; i < 26; i++) {
    if (c[i] != 0) {
      if (c[i] % k == 0) {
        int j = c[i] / k;
        while (j > 0) {
          ans += (i + 'a');
          j--;
        }
      } else {
        cout << -1 << "\n";
        return 0;
      }
    }
  }
  string temp = ans;
  for (i = 1; i < k; i++) {
    ans += temp;
  }
  cout << ans << "\n";
}
