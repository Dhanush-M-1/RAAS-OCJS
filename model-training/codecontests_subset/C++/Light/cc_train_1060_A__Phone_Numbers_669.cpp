#include <bits/stdc++.h>
using namespace ::std;
int n;
int q8;
string s;
int main() {
  cin >> n >> s;
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '8') q8++;
  }
  int ans = q8;
  ans = min(ans, n / 11);
  cout << ans << endl;
  return 0;
}
