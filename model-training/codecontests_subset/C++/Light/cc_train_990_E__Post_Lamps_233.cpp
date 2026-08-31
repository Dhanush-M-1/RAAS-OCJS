#include <bits/stdc++.h>
using namespace std;
const int N = 1000100;
namespace Solver {
int64_t n, m, maxPow, cost[N], last[N];
void solve() {
  cin >> n >> m >> maxPow;
  for (int i = 1, x; i <= m; ++i) {
    cin >> x;
    last[x] = 1;
  }
  if (last[0] == 1) {
    cout << -1 << "\n";
    exit(0);
  }
  for (int i = 1; i <= maxPow; ++i) {
    cin >> cost[i];
  }
  int64_t leastPow = 1;
  for (int i = 1; i < n; ++i) {
    if (last[i] == 1) {
      last[i] = last[i - 1];
    } else {
      last[i] = i;
    }
    leastPow = max(leastPow, (int64_t)(i - last[i] + 1));
  }
  if (leastPow > maxPow) {
    cout << -1 << "\n";
    exit(0);
  }
  int64_t ans = n * 10000000LL;
  for (int d = leastPow; d <= maxPow; ++d) {
    int pos = 0;
    int64_t res = 0;
    do {
      res += cost[d];
      pos += d;
      if (pos < n && last[pos] <= pos - d) {
        res = n * 10000000LL + 1;
        break;
      }
      if (pos < n) pos = last[pos];
    } while (pos < n);
    if (ans > res) {
      ans = res;
    }
  }
  if (ans <= n * 1000000LL) {
    cout << ans << "\n";
    exit(0);
  } else {
    cout << -1 << "\n";
    exit(0);
  }
}
}  // namespace Solver
int main() {
  ios::sync_with_stdio(0);
  Solver::solve();
  return 0;
}
