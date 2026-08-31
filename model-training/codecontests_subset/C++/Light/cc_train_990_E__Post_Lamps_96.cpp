#include <bits/stdc++.h>
using namespace std;
const long long mod = (long long)1e9 + 7;
const int N = (int)(2e6 + 5);
int n, m, k, s;
bool block[N];
int pr[N];
int check(int len) {
  int res = 0;
  int p = 0;
  while (p < n) {
    ++res;
    p += len;
    if (block[p]) p = pr[p];
  }
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie();
  cin >> n >> m >> k;
  for (int i = 0; i < m; i++) cin >> s, block[s] = true;
  if (block[0]) {
    cout << -1 << endl;
    return 0;
  }
  int mx = 0;
  int c = 0;
  for (int i = 0; i < n; i++) {
    if (block[i])
      pr[i] = pr[i - 1], ++c;
    else
      pr[i] = i, c = 0;
    mx = max(mx, c);
  }
  long long res = 1LL * N * N;
  int a;
  for (int i = 1; i <= mx; i++) cin >> a;
  for (int i = mx + 1; i <= k; i++)
    cin >> a, res = min(res, 1LL * check(i) * a);
  if (res == 1LL * N * N) res = -1;
  cout << res << endl;
  return 0;
}
