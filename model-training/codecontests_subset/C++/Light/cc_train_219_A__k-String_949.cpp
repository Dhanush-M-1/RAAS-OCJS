#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  string s, ans = "";
  cin >> k >> s;
  map<char, int> mp;
  for (int i = 0; i < s.size(); i++) mp[s[i]]++;
  for (auto i : mp) {
    if (i.second % k != 0) {
      cout << "-1";
      return 0;
    }
    ans.resize(ans.size() + i.second / k, i.first);
  }
  for (int i = 0; i < k; i++) cout << ans;
}
