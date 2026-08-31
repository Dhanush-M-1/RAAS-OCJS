#include <bits/stdc++.h>
using namespace std;
const long long MAX = 1000005;
const long long mod = 1e18;
const long long N = 1e5 + 5;
long long T = 0;
const string alphabet = {"abcdefghijklmnopqrstuvwxyz"};
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
void solve() {
  long long n = 0, i, a, b;
  cin >> n;
  string s[n];
  for (i = 0; i < n; i++) cin >> s[i];
  long long cnt = 0;
  vector<pair<long long, long long> > ans;
  if (s[0][1] == s[1][0]) {
    if (s[0][1] == '0') {
      if (s[n - 1][n - 2] == '0') {
        cnt++;
        ans.push_back({n, n - 1});
      }
      if (s[n - 2][n - 1] == '0') {
        cnt++;
        ans.push_back({n - 1, n});
      }
    } else {
      if (s[n - 1][n - 2] == '1') {
        cnt++;
        ans.push_back({n, n - 1});
      }
      if (s[n - 2][n - 1] == '1') {
        cnt++;
        ans.push_back({n - 1, n});
      }
    }
  } else {
    long long k = (s[n - 1][n - 2] - '0') + (s[n - 2][n - 1] - '0');
    if (k == 0) {
      cout << 1 << endl;
      cout << (s[0][1] == '1' ? "2 1" : "1 2") << endl;
    } else if (k == 1) {
      cout << 2 << endl;
      if (s[n - 1][n - 2] == '0')
        cout << n << " " << n - 1 << endl;
      else
        cout << n - 1 << " " << n << endl;
      cout << (s[0][1] == '0' ? "2 1" : "1 2") << endl;
    } else {
      cout << 1 << endl;
      cout << (s[0][1] == '0' ? "2 1" : "1 2") << endl;
    }
    return;
  }
  cout << cnt << endl;
  for (auto z : ans) cout << z.first << " " << z.second << endl;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
