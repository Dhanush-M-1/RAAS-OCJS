#include <bits/stdc++.h>
using namespace std;
int n;
bool a[5500][5500];
bool f[5500];
int checked[5500];
int spf[5500];
const int N = 5500;
int prime[N];
bool check2(int jj, int pf) {
  vector<vector<bool> > vv;
  for (int i = 0; i < n * pf / jj; ++i) {
    vector<bool> kg;
    for (int j = 0; j < n * pf / jj; ++j) {
      kg.push_back(a[i * jj / pf][j * jj / pf]);
    }
    vv.push_back(kg);
  }
  for (int i = 0; i < (int)vv.size(); ++i)
    for (int j = 0; j < (int)vv.size(); ++j) {
      int i2 = i - i % pf;
      int j2 = j - j % pf;
      if (vv[i][j] != vv[i2][j2]) return 0;
    }
  return 1;
}
bool check(int kk) {
  vector<int> pff;
  bool ok = true;
  int num = kk;
  while (num != 1) {
    int cnt = 1;
    int j = spf[num];
    while (num % j == 0) {
      num /= j;
      cnt *= j;
    }
    ok &= f[cnt];
  }
  return ok;
}
void solve() {
  int ndash = N - 1;
  for (int i = 2; i <= ndash; ++i) {
    if (!spf[i]) {
      for (int j = i; j <= ndash; j += i)
        if (!spf[j]) spf[j] = i;
    }
  }
  f[1] = 1;
  cin >> n;
  char s;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n / 4; ++j) {
      int num = 0;
      cin >> s;
      if (s >= '0' and s <= '9')
        num = s - '0';
      else
        num = 10 + s - 'A';
      for (int k = 0; k < 4; ++k) a[i][j * 4 + k] = (num & (1 << (3 - k)));
    }
  }
  vector<int> facts;
  vector<int> pfs;
  int nn = n;
  for (int i = 2; i < n + 1; ++i) {
    if (nn % i == 0) pfs.push_back(i);
    while (nn % i == 0) nn /= i;
  }
  for (int i = 0; i < (int)pfs.size(); ++i) {
    bool ok = true;
    int jj = pfs[i];
    while (jj <= n) {
      ok &= f[jj / pfs[i]];
      if (ok) ok &= check2(jj, pfs[i]);
      f[jj] = ok;
      jj *= pfs[i];
    }
  }
  int ans = 1;
  for (int i = 1; i < n + 1; ++i)
    if (n % i == 0 and check(i)) ans = i;
  cout << ans << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
