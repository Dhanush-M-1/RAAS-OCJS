#include <bits/stdc++.h>
using namespace std;
void solve() {
  string s;
  cin >> s;
  long long one = 0, two = 0, three = 0, n = s.length();
  for (long long i = 0; i < n; i++) {
    if (s[i] == '1')
      one++;
    else if (s[i] == '2')
      two++;
    else if (s[i] == '3')
      three++;
  }
  for (long long i = 0; i < one; i++) {
    cout << 1;
    if (i != one - 1 || two != 0 || three != 0) cout << "+";
  }
  for (long long i = 0; i < two; i++) {
    cout << 2;
    if (i != two - 1 || three != 0) cout << "+";
  }
  for (long long i = 0; i < three; i++) {
    cout << 3;
    if (i != three - 1) cout << "+";
  }
}
void champ() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
signed main() {
  champ();
  solve();
  return 0;
}
