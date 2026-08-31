#include <bits/stdc++.h>
using namespace std;
int c[26] = {0};
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  int l = s.length();
  for (int i = 0; i < l; i++) {
    int x = (int)(s[i] - 'a');
    c[x]++;
  }
  for (int i = 0; i < 26; i++) {
    if (c[i] % k != 0) {
      cout << -1;
      return 0;
    }
  }
  string an = "";
  for (int i = 0; i < 26; i++) {
    int a = c[i] / k;
    int le = an.length();
    char ch = (char)(i + 'a');
    an.insert(le, a, ch);
  }
  string ans = "";
  for (int i = 1; i <= k; i++) {
    ans += an;
  }
  cout << ans;
  return 0;
}
