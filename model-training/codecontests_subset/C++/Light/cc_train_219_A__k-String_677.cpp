#include <bits/stdc++.h>
using namespace std;
string s;
int k;
int f[500];
int main() {
  cin >> k;
  cin >> s;
  int len = s.size();
  for (int i = 0; i < len; i++) f[s[i] - 'a']++;
  for (int i = 0; i < 26; i++)
    if (f[i] % k != 0) {
      cout << -1;
      return 0;
    }
  for (int k1 = 1; k1 <= k; k1++)
    for (int i = 0; i < 26; i++)
      for (int j = 1; j <= (f[i] / k); j++) cout << (char)('a' + i);
}
