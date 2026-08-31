#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
const int N = 100;
array<long long, 3> a[N];
long long dp[N][N];
int anc[N][N];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
      cin >> a[i][1] >> a[i][0];
      a[i][2] = i;
    }
    sort(a, a + n);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        dp[i][j] = -INF;
      }
    }
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= k; j++) {
        if (dp[i][j] != -INF) {
          if (dp[i + 1][j] < dp[i][j] + (k - 1) * a[i][0]) {
            dp[i + 1][j] = dp[i][j] + (k - 1) * a[i][0];
            anc[i + 1][j] = j;
          }
          if (dp[i + 1][j + 1] < dp[i][j] + a[i][1] + a[i][0] * j) {
            dp[i + 1][j + 1] = dp[i][j] + a[i][1] + a[i][0] * j;
            anc[i + 1][j + 1] = j;
          }
        }
      }
    }
    vector<int> taken, killed;
    int x = n, y = k;
    while (x > 0) {
      if (anc[x][y] == y)
        killed.push_back(x - 1);
      else
        taken.push_back(x - 1);
      y = anc[x][y];
      x--;
    }
    reverse(taken.begin(), taken.end());
    cout << taken.size() + killed.size() * 2 << "\n";
    for (int i = 0; i + 1 < taken.size(); i++) {
      cout << a[taken[i]][2] + 1 << " ";
    }
    for (int i = 0; i < killed.size(); i++) {
      cout << (a[killed[i]][2] + 1) << " ";
      cout << -(a[killed[i]][2] + 1) << " ";
    }
    cout << a[taken.back()][2] + 1 << "\n";
  }
  return 0;
}
