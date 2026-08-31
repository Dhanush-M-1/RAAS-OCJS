#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  unordered_map<char, int> mp;
  for (int i = 0; i < s.length(); i++) {
    mp[s[i]]++;
  }
  string ans = "";
  for (auto f : mp) {
    if (f.second % k == 0) {
      for (int i = 0; i < (f.second / k); i++) {
        ans += f.first;
      }
    } else {
      cout << -1 << endl;
      return 0;
    }
  }
  string gg = "";
  while (k--) {
    gg += ans;
  }
  cout << gg << endl;
}
