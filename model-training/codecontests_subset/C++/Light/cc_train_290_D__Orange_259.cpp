#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int a;
  cin >> a;
  string ans;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] < 'a') s[i] += ('a' - 'A');
  }
  for (int i = 0; i < s.size(); i++) {
    if (s[i] < a + 97) {
      ans += (s[i] - 'a' + 'A');
    } else
      ans += s[i];
  }
  cout << ans << endl;
}
