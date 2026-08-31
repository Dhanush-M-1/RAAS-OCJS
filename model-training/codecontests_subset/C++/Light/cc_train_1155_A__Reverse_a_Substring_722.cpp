#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long a = 0, b = 0, c, d, e, f = 0, l, g, m, n, k, i, j, t, p, q;
  string s, ss;
  cin >> l >> s;
  ss = s;
  sort(ss.begin(), ss.end());
  if (s == ss) {
    cout << "NO\n";
    return 0;
  }
  cout << "YES\n";
  for (i = 1; i < l; i++) {
    if (s[i] < s[i - 1]) {
      cout << i << ' ' << i + 1 << '\n';
      return 0;
    }
  }
  return 0;
}
