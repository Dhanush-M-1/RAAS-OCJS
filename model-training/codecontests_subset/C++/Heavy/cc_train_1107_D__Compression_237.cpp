#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long inf = 2e18;
const long double eps = 1e-9;
const long long NN = 1e5 + 2;
vector<vector<long long> > adj;
bool mat[5201][5201];
vector<long long> to[16];
bool checker(long long n, long long x) {
  for (long long i = 0; i < n / x; i++) {
    for (long long j = 0; j < n / x; j++) {
      bool val = mat[i * x][j * x];
      for (long long ii = i * x; ii < (i + 1) * x; ii++) {
        for (long long jj = j * x; jj < (j + 1) * x; ++jj) {
          if (mat[ii][jj] != val) return 0;
        }
      }
    }
  }
  return 1;
}
void solve() {
  long long i = 0, j = 0, k = 0, n = 0, m = 0;
  cin >> n;
  for (i = 0; i < (n); i++) {
    string s;
    cin >> s;
    for (j = 0; j < n / 4; j++) {
      vector<long long>& v = s[j] >= 'A' ? to[s[j] - 'A' + 10] : to[s[j] - '0'];
      for (k = 4 * j, m = 0; m < 4; k++, m++) mat[i][k] = v[m];
    }
  }
  vector<long long> divs;
  for (i = 1; i <= n; i++) {
    if (n % i == 0) divs.push_back(i);
  }
  long long ans = 1;
  vector<bool> p(100, 1);
  for (i = 1; i < divs.size(); i++) {
    if (!p[i]) continue;
    if (checker(n, divs[i])) {
      ans = divs[i];
    } else {
      for (j = i + 1; j < divs.size(); j++) {
        if (divs[j] % divs[i] == 0) p[j] = 0;
      }
    }
  }
  cout << ans << '\n';
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long T = 1, tc;
  for (long long i = 0; i < 16; i++) {
    to[i].resize(4);
    long long cp = i;
    for (long long j = 0; j < 4; j++) {
      to[i][j] = cp % 2;
      cp >>= 1;
    }
    reverse(to[i].begin(), to[i].end());
  }
  for (tc = 1; tc <= T; tc++) {
    solve();
  }
  return 0;
}
