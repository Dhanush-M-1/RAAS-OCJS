#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  for (long long i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      cout << "YES" << '\n';
      cout << i << " " << i + 1;
      return;
    }
  }
  cout << "NO";
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
