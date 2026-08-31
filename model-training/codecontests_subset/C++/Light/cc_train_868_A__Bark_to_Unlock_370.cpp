#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int N = (int)2e5 + 5;
const double pi = 3.14159265359;
int cnt[26], res[26];
void solve() {
  string s;
  cin >> s;
  int n;
  cin >> n;
  bool ok = 0;
  for (int i = 0; i < n; ++i) {
    string t;
    cin >> t;
    if (t == s) {
      ok = 1;
    }
    cnt[t[0] - 'a']++, res[t[1] - 'a']++;
  }
  if (ok) {
    cout << "YES";
    return;
  }
  if ((cnt[s[1] - 'a'] && res[s[0] - 'a']))
    cout << "YES";
  else
    cout << "NO";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
