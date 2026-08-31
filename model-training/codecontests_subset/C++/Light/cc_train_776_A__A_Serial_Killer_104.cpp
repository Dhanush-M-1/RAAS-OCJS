#include <bits/stdc++.h>
using namespace std;
string ans[5];
int main() {
  ios::sync_with_stdio(false);
  string s1, s2, t1, t2;
  map<string, int> mp;
  while (cin >> s1 >> s2) {
    mp[s1] = 1;
    mp[s2] = 2;
    ans[1] = s1, ans[2] = s2;
    int n;
    cin >> n;
    cout << ans[1] << " " << ans[2] << endl;
    for (int i = 0; i < n; i++) {
      cin >> t1 >> t2;
      if (mp[t1] == 1 || mp[t1] == 2)
        ans[mp[t1]] = t2, mp[t2] = mp[t1], mp[t1] = 0;
      else
        ans[mp[t2]] = t1, mp[t1] = mp[t2], mp[t2] = 0;
      cout << ans[1] << " " << ans[2] << endl;
    }
  }
  return 0;
}
