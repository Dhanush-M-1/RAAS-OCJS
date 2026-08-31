#include <bits/stdc++.h>
using namespace std;
constexpr int MAXN = 2e5 + 25;
constexpr int MOD = 1e9 + 7;
constexpr int INF = (1 << 31);
constexpr int LOG = 60;
int n, d, a[MAXN], ans, sum, added;
int main() {
  cin >> n >> d;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    if (a[i] != 0) {
      sum += a[i];
      if (sum > d) {
        return cout << -1, 0;
      }
    }
    if (a[i] == 0) {
      if (sum < 0) {
        added += -sum;
        sum = 0;
      }
    }
  }
  int sum = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] != 0) {
      sum += a[i];
      if (sum > d) {
        added += sum - d;
        sum = d;
      }
    }
    if (a[i] == 0) {
      if (sum < 0) {
        added -= -sum;
        sum = 0;
        sum += min(d, added);
        added -= min(d, added);
        ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
