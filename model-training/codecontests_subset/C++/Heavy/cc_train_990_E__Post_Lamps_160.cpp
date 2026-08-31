#include <bits/stdc++.h>
using namespace std;
int a[1000005], last[1000005];
bool second[1000005];
int n, m, k;
int get(int l) {
  int i = -1, r = 0, res = 0;
  while (r < n) {
    if (last[r] <= i) return 1000000007;
    i = last[r];
    r = last[r] + l;
    ++res;
  }
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int i, x;
  cin >> n >> m >> k;
  for (i = 0; i < m; i++) cin >> x, second[x] = 1;
  for (i = 0; i < k; i++) cin >> a[i];
  last[0] = -1;
  for (i = 0; i < n; i++) {
    if (second[i] && i)
      last[i] = last[i - 1];
    else if (!second[i]) {
      last[i] = i;
    }
  }
  long long int ans = (long long int)1e18;
  for (i = 1; i <= k; i++) {
    int res = get(i);
    if (res != 1000000007) {
      ans = min(ans, (long long int)a[i - 1] * res);
    }
  }
  if (ans == (long long int)1e18) ans = -1;
  cout << ans << endl;
  return 0;
}
