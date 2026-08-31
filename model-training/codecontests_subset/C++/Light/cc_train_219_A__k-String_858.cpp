#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  int n = s.length();
  int *cnt = new int[26];
  memset(cnt, 0, sizeof(cnt) * 26);
  for (int i = 0; i < n; ++i) ++cnt[s[i] - 'a'];
  for (int i = 0; i < 26; ++i)
    if (cnt[i] % k) {
      cout << -1;
      return 0;
    }
  for (int i = 0; i < k; ++i)
    for (int j = 0; j < 26; ++j)
      for (int t = 0; t < cnt[j] / k; ++t) cout << (char)('a' + j);
  cout << endl;
  return 0;
}
