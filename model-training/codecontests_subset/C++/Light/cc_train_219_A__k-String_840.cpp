#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, f = 0;
  cin >> n;
  string s;
  vector<char> ans;
  cin >> s;
  map<char, int> mp;
  set<char> alp;
  for (i = 0; i < s.size(); i++) {
    mp[s[i]]++;
    alp.insert(s[i]);
  }
  for (auto x : alp) {
    if (mp[x] % n != 0) f++;
  }
  if (f != 0)
    cout << -1;
  else {
    for (auto x : alp) {
      for (i = 0; i < mp[x] / n; i++) ans.push_back(x);
    }
    for (j = 0; j < n; j++) {
      for (i = 0; i < ans.size(); i++) cout << ans[i];
    }
  }
}
