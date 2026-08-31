#include <bits/stdc++.h>
using namespace std;
const long long MAX = 2e5 + 5;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, m, k, x;
  cin >> n >> m >> k;
  vector<long long> b(n, 1);
  for (int i = 0; i < m; i++) {
    cin >> x;
    b[x] = 0;
  }
  long long seg_l = 0;
  vector<long long> cs(n, 0);
  for (int i = 0; i < n; i++) {
    if (!b[i]) {
      cs[i] = 1;
      if (i) cs[i] += cs[i - 1];
    }
    seg_l = max(seg_l, cs[i]);
  }
  vector<long long> v(k + 1, 0);
  for (int i = 1; i <= k; i++) {
    cin >> v[i];
  }
  if (!b[0]) {
    cout << "-1" << endl;
    return 0;
  }
  long long ans = 1e18;
  for (int i = seg_l + 1; i <= k; i++) {
    long long j = 0;
    long long cnt = 0;
    while (j < n) {
      if (!b[j]) {
        j -= cs[j];
      } else {
        j += i;
        cnt += v[i];
      }
    }
    if (cnt != 0) ans = min(cnt, ans);
  }
  if (ans != 1e18)
    cout << ans << endl;
  else
    cout << "-1" << endl;
  return 0;
}
