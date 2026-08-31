#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f, mod = 1000000007;
const double pi = 3.1415926535897932, eps = 1e-6;
int n, m, k, p[1000005], lst[1000005];
bool a[1000005];
long long ans = 0x3f3f3f3f3f3f3f3f;
int solve(int x) {
  int las = -1, p = 0, ans = 0;
  while (p < n) {
    las = p;
    p = lst[p] + x;
    ans++;
    if (p <= las) return -1;
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (int(i) = (1); (i) <= (m); (i)++) {
    int tmp;
    cin >> tmp;
    a[tmp] = 1;
  }
  for (int(i) = (1); (i) <= (k); (i)++) cin >> p[i];
  if (a[0]) {
    cout << "-1";
    return 0;
  }
  for (int(i) = (0); (i) < (n); (i)++)
    if (a[i])
      lst[i] = lst[i - 1];
    else
      lst[i] = i;
  for (int(i) = (1); (i) <= (k); (i)++) {
    int cur = solve(i);
    if (cur != -1) ans = min(ans, (long long)cur * p[i]);
  }
  if (ans > 1e18)
    cout << "-1";
  else
    cout << ans;
  return 0;
}
