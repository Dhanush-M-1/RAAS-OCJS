#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i < n; i++, cout << '\n')
    for (int j = 1; j < n; j++) {
      int t = i * j;
      string s;
      while (t) s += t % n + '0', t /= n;
      reverse(s.begin(), s.end());
      cout << s << ' ';
    }
  return 0;
}
