#include <bits/stdc++.h>
using namespace std;
void solve() {
  int k;
  cin >> k;
  string str;
  cin >> str;
  unordered_map<char, int> mp;
  for (int i = 0; i < str.size(); i++) mp[str[i]]++;
  bool t = 1;
  for (auto i = mp.begin(); i != mp.end(); i++) {
    if (i->second % k) t = 0;
  }
  if (t) {
    string res = "";
    for (auto i = mp.begin(); i != mp.end(); i++) {
      int j = i->second / k;
      while (j--) res += i->first;
    }
    k = str.size() / res.size();
    while (k--) cout << res;
  } else
    cout << -1;
}
int main() {
  std::ios_base::sync_with_stdio(false);
  solve();
  return 0;
}
