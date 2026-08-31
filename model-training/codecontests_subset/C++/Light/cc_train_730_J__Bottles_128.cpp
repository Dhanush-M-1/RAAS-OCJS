#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100;
int memo[MAXN + 1][100 * MAXN + 1];
bool vis[MAXN + 1][100 * MAXN + 1];
int main() {
  int n;
  cin >> n;
  int total = 0;
  int arr[n];
  int kek[n];
  for (int i = 0; i != n; ++i) {
    cin >> arr[i];
    total += arr[i];
  }
  for (int i = 0; i != n; ++i) cin >> kek[i];
  vis[0][0] = 1;
  for (int i = 0; i != n; ++i) {
    for (int j = n; j != 0; --j) {
      for (int k = 100 * n; k >= kek[i]; --k) {
        if (vis[j - 1][k - kek[i]]) {
          vis[j][k] = 1;
          memo[j][k] = max(memo[j][k], memo[j - 1][k - kek[i]] + arr[i]);
        }
      }
    }
  }
  int ans1, ans2 = 1000000000;
  for (int i = 1; i <= n; ++i) {
    bool done = 0;
    for (int j = total; j <= 100 * n; ++j) {
      if (vis[i][j]) {
        done = 1;
        ans1 = i;
        ans2 = min(ans2, total - memo[i][j]);
      }
    }
    if (done) break;
  }
  cout << ans1 << ' ' << ans2 << '\n';
  return 0;
}
