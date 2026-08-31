#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  string res = "";
  int f[26] = {0};
  for (int i = 0; i < s.size(); i++) {
    f[s[i] - 'a']++;
  }
  int i;
  for (i = 0; i < 26; i++)
    if ((f[i] % k)) break;
  if (i < 26) {
    cout << "-1" << endl;
    return 0;
  }
  for (int i = 0; i < 26; i++) {
    for (int j = 0; j < (f[i] / k); j++) {
      res += i + 'a';
    }
  }
  for (int i = 0; i < k; i++) cout << res;
  cout << endl;
  return 0;
}
