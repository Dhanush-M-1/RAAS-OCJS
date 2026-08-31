#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int cnt[26] = {};
  string s;
  cin >> s;
  for (char c : s) cnt[c - 'a']++;
  string ans;
  for (int i = 0; i < 26; i++) {
    if (cnt[i] % n != 0) {
      cout << "-1\n";
      return 0;
    }
    ans += string(cnt[i] / n, i + 'a');
  }
  while (n--) cout << ans;
  cout << '\n';
  return 0;
}
