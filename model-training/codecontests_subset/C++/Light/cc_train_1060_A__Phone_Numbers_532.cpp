#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, c = 0;
  cin >> n;
  bool flag = false;
  string s;
  cin >> s;
  for (int i = 0; i < n; ++i) {
    if (s[i] == '8') {
      flag = true;
      c++;
    }
  }
  if (!flag)
    cout << "0\n";
  else
    cout << min(c, n / 11) << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int tc = 1;
  while (tc--) {
    solve();
  }
  return 0;
}
