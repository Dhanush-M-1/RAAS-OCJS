#include <bits/stdc++.h>
using namespace std;
int a[2000005], n, pre[2000005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long m, k, ans = 1e15;
  cin >> n >> m >> k;
  for (int i = 0; i < 2000005; ++i) a[i] = 1;
  for (int i = 0, x; i < m; ++i) {
    cin >> x;
    a[x] = 0;
  }
  for (int i = 0, last = -1; i < 2000005; ++i) {
    if (a[i]) last = i;
    pre[i] = last;
  }
  if (!a[0]) return cout << -1, 0;
  for (int i = 1; i <= k; cin >> a[i++])
    ;
  for (int i = 1; i <= k; ++i) {
    int cur = 0;
    long long cost = 0;
    while (cur < n) {
      cost += a[i];
      if (pre[cur + i] == cur) {
        cost = 1e17;
        break;
      }
      cur = pre[cur + i];
    }
    ans = min(ans, cost);
  }
  cout << (ans > 1e13 ? -1 : ans);
}
