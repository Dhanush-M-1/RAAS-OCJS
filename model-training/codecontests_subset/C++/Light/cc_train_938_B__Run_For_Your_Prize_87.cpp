#include <bits/stdc++.h>
using namespace std;
const int N = 200200;
const int mod = 1e9 + 7;
int a[N];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i];
  const int mil = 1e6;
  int res = min(a[n] - 1, mil - a[1]);
  for (int i = 1; i < n; ++i) res = min(res, max(a[i] - 1, mil - a[i + 1]));
  cout << res;
  return 0;
}
