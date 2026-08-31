#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  string s, ans;
  int n, i, j, k, x, r;
  cin >> s >> r;
  n = s.length();
  ans = s;
  for (i = 0; i < n; i++) {
    if (s[i] >= 'a')
      x = s[i] - 'a';
    else
      x = s[i] - 'A';
    if (x < r)
      ans[i] = 'A' + x;
    else
      ans[i] = 'a' + x;
  }
  cout << ans << "\n";
  return 0;
}
