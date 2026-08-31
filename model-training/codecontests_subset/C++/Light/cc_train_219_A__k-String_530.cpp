#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int cnt[26] = {};
  for (int i = 0; i < s.size(); ++i) {
    cnt[s[i] - 'a']++;
  }
  for (int i = 0; i < 26; ++i) {
    if (cnt[i] % n != 0) {
      cout << -1 << endl;
      return 0;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < 26; ++j) {
      for (int k = 0; k < cnt[j] / n; ++k) {
        cout << char('a' + j);
      }
    }
  }
  cout << endl;
}
