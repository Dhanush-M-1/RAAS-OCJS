#include <bits/stdc++.h>
using namespace std;
string mp[210];
int n;
bool func(char x, char y) {
  int res = (mp[1][0] == x) + (mp[0][1] == x) + (mp[n - 1][n - 2] == y) +
            (mp[n - 2][n - 1] == y);
  if (res <= 2) {
    cout << res << "\n";
    if (mp[1][0] != y)
      cout << "2 1"
           << "\n";
    if (mp[0][1] != y)
      cout << "1 2"
           << "\n";
    if (mp[n - 1][n - 2] != x) cout << n << " " << n - 1 << "\n";
    if (mp[n - 2][n - 1] != x) cout << n - 1 << " " << n << "\n";
    return true;
  }
  return false;
}
int main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  int i, j, k, a, b, c, x, y, z, m, t;
  cin >> t;
  string s;
  while (t--) {
    cin >> n;
    getline(cin, s);
    for (i = 0; i < n; i++) {
      getline(cin, mp[i]);
    }
    if (!func('0', '1')) func('1', '0');
  }
}
