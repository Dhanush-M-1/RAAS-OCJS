#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, cnt = 0;
  string s;
  cin >> n >> s;
  for (size_t i = 0; i < s.size(); i++) {
    if (s[i] == '8') {
      cnt++;
    }
  }
  cout << min(n / 11, cnt);
}
int main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  int t = 1;
  while (t--) solve();
  return 0;
}
