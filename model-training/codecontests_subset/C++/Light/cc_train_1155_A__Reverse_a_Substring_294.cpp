#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 50, MOD = 1e9 + 7;
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  string s;
  long long n;
  cin >> n;
  char c = 'A';
  long long imax = 0;
  cin >> s;
  for (long long i = 0; i < s.size(); i++) {
    if (c == 'A') c = s[i], imax = 0;
    if (c < s[i])
      c = s[i], imax = i;
    else if (c > s[i]) {
      cout << "YES" << endl;
      cout << imax + 1 << ' ' << i + 1;
      return 0;
    }
  }
  cout << "NO";
}
