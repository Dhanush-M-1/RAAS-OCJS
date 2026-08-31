#include <bits/stdc++.h>
const int MAXINT = 2147483640;
const long long MAXLL = 9223372036854775800LL;
const long long MAXN = 423456;
const long long MOD = 1123456769;
using namespace std;
int a[MAXN];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  srand(time(0));
  int n, i, ans = MAXINT;
  cin >> n;
  a[0] = 1;
  for (i = 1; i <= n; i++) cin >> a[i];
  a[n + 1] = 1000000;
  for (i = 0; i <= n; i++) ans = min(ans, max(a[i] - 1, 1000000 - a[i + 1]));
  cout << ans << "\n";
  return 0;
}
