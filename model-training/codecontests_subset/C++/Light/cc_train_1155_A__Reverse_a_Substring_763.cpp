#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  string s;
  cin >> s;
  string s1 = s;
  sort(s1.begin(), s1.end());
  if (s == s1) {
    cout << "NO";
    return 0;
  }
  int pos[26];
  for (int j = 0; j <= 25; j++) pos[j] = -1;
  cout << "YES" << '\n';
  for (int i = 0; i < (int)s.size(); i++) {
    for (int j = 25; j > s[i] - 'a'; j--) {
      if (pos[j] != -1) {
        cout << pos[j] + 1 << " " << i + 1 << '\n';
        return 0;
      }
    }
    pos[s[i] - 'a'] = i;
  }
  return 0;
}
