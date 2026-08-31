#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int s[1000005], a[1000005];
int bf[2000005];
long long ans = 0x7fffffffffffffff;
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= n * 2; i++) {
    bf[i] = i;
  }
  for (int i = 1; i <= m; i++) {
    cin >> s[i];
    bf[s[i]] = bf[s[i] - 1];
    if (s[i] == 0 || s[i] - bf[s[i]] > k) {
      cout << -1;
      return 0;
    }
  }
  for (int i = 1; i <= k; i++) {
    cin >> a[i];
    long long rem = 0, id = 0;
    for (id = 0; id < n && bf[id + i] != id; id = bf[id + i]) {
      rem += a[i];
    }
    if (id >= n) {
      ans = min(ans, rem);
    }
  }
  if (ans == 0x7fffffffffffffff) {
    cout << -1;
    return 0;
  }
  cout << ans;
  return 0;
}
