#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e14;
const long long N = 2e3 + 1;
const long long mod = 1e9 + 7;
const long double eps = 1E-7;
long long n, m, a[N], b[N], cnt, ans;
string s[N], h[N], r, x, y;
pair<string, string> p[N];
int main() {
  string dp[2] = {"NO", "YES"};
  ios_base::sync_with_stdio(0);
  ;
  cin >> s[0] >> h[0] >> n;
  for (int i = 1; i <= n; i++) cin >> s[i] >> h[i];
  if (s[0] == s[1])
    r = h[0];
  else
    r = s[0], cout << s[0] << ' ' << h[0] << endl;
  for (int i = 0; i < n; i++) {
    if (r != s[i + 1]) {
      if ((s[i + 1] != y and r != x) and (s[i + 1] != h[i]))
        cout << s[i + 1] << ' ' << r << endl;
      cout << h[i + 1] << ' ' << r << endl;
    } else if (r == s[i + 1]) {
      r = h[i];
      cout << r << ' ' << h[i + 1] << endl;
      x = r, y = h[i + 1];
    }
  }
}
