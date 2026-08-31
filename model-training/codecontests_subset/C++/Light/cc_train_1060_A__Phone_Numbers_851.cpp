#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  ;
  int n, e8 = 0, ans;
  cin >> n;
  string s;
  ans = n / 11;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] - '0' == 8) e8++;
  }
  if (e8 < ans) ans = e8;
  cout << ans << endl;
  return 0;
}
