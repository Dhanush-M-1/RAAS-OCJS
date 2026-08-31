#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int k;
  cin >> k;
  string s;
  cin >> s;
  vector<long long> freq(26, 0);
  for (int i = 0; i < s.length(); i++) {
    freq[s[i] - 'a']++;
  }
  string ans = "";
  for (int i = 0; i < 26; i++) {
    if (freq[i] % k != 0) {
      cout << -1;
      return 0;
    }
    for (int j = 1; j <= (freq[i] / k); j++) ans += ('a' + i);
  }
  string f_ans = ans;
  for (int i = 2; i <= k; i++) f_ans += ans;
  cout << f_ans;
  return 0;
}
