#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int k;
  string s, ans = "";
  cin >> k >> s;
  int freq[30] = {};
  for (int i = 0; i < s.size(); i++) freq[s[i] - 'a']++;
  for (char c = 'a'; c <= 'z'; c++) {
    if (freq[c - 'a'] % k != 0) return cout << -1, 0;
    ans += string(freq[c - 'a'] / k, c);
  }
  for (int i = 0; i < k; i++) cout << ans;
  return 0;
}
