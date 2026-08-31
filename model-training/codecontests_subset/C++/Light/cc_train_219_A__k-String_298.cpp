#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, i;
  string s;
  string out = "";
  int count[26] = {0};
  cin >> k;
  cin >> s;
  for (i = 0; i < s.size(); i++) count[s[i] - 'a']++;
  for (i = 0; i < 26; i++)
    if (count[i] && count[i] % k) {
      cout << -1 << endl;
      return 0;
    } else if (count[i]) {
      int t = count[i] / k;
      while (t--) out.push_back(i + 'a');
    }
  while (k--) cout << out;
  cout << endl;
  return 0;
}
