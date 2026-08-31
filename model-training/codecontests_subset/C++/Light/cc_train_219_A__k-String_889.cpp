#include <bits/stdc++.h>
using namespace std;
int k;
string s;
int cnt[100];
int main() {
  while (cin >> k) {
    cin >> s;
    memset(cnt, 0, sizeof(cnt));
    for (int i = 0; i < s.size(); i++) cnt[s[i] - 'a']++;
    bool ok = 1;
    string ans;
    for (int i = 0; i < 26; i++) {
      if (cnt[i] % k == 0) {
        ans.append(cnt[i] / k, i + 'a');
      } else
        ok = 0;
    }
    if (ok) {
      string a;
      int t = s.size() / ans.size();
      for (int i = 0; i < t; i++) a += ans;
      cout << a << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
