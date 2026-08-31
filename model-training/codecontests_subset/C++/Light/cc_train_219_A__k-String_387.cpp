#include <bits/stdc++.h>
using namespace std;
const int Maxn = 1e3 + 7;
int k, t[30];
string s, sout;
int main() {
  cin >> k >> s;
  int l = s.length();
  for (int i = 0; i < l; i++) {
    t[(int)s[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (t[i] % k != 0) {
      cout << -1;
      return 0;
    }
    for (int j = 0; j < t[i] / k; j++) sout += char(i + 'a');
  }
  for (int i = 0; i < k; i++) cout << sout;
}
