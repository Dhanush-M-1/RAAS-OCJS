#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int k, alph[26] = {};
  string s;
  cin >> k >> s;
  int sz = s.size();
  for (int i = 0; i < sz; i++) alph[s[i] - 'a']++;
  bool f = true;
  for (int i = 0; i < 26; i++)
    if (alph[i] % k != 0) f = false;
  if (f) {
    for (int i = 0; i < k; i++)
      for (int j = 0; j < 26; j++) {
        int x = alph[j] / k;
        for (int m = 0; m < x; m++)
          if (alph[j] > 0) cout << char('a' + j);
      }
  } else
    cout << "-1";
  return 0;
}
