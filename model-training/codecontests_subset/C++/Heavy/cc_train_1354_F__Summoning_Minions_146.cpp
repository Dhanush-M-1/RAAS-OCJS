#include <bits/stdc++.h>
using namespace std;
const int N = (1e2) + 10;
const int M = (1e5) + 10;
const int INF = (1e9) + 10;
const int maxn = 5e6 + 100;
int dp[N][N];
int p[N][N];
struct trr {
  int first;
  int second;
  int poz;
};
bool comp(trr a, trr b) { return a.first < b.first; }
void solve() {
  int n, k;
  cin >> n >> k;
  vector<trr> arr(n);
  vector<int> ans[2];
  for (int i = int(0); i < int(n); i++) {
    int a, b;
    cin >> a >> b;
    arr[i] = {b, a, i + 1};
  }
  sort(arr.begin(), arr.end(), comp);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = int(0); i < int(n); i++) {
    for (int j = int(0); j < int(k + 1); j++)
      if (dp[i][j] >= 0) {
        if (dp[i + 1][j + 1] < dp[i][j] + arr[i].first * j + arr[i].second) {
          dp[i + 1][j + 1] = dp[i][j] + arr[i].first * j + arr[i].second;
          p[i + 1][j + 1] = 1;
        }
        if (dp[i + 1][j] < dp[i][j] + arr[i].first * (k - 1)) {
          dp[i + 1][j] = dp[i][j] + arr[i].first * (k - 1);
          p[i + 1][j] = 0;
        }
      }
  }
  int pos = k;
  for (int i = n; i >= 1; i--) {
    ans[p[i][pos]].push_back(arr[i - 1].poz);
    pos -= p[i][pos];
  }
  reverse(ans[0].begin(), ans[0].end());
  reverse(ans[1].begin(), ans[1].end());
  cout << ans[0].size() * 2 + ans[1].size() << endl;
  for (int i = int(0); i < int(ans[1].size() - 1); i++)
    cout << ans[1][i] << ' ';
  for (int i = int(0); i < int(ans[0].size()); i++)
    cout << ans[0][i] << ' ' << -ans[0][i] << ' ';
  cout << ans[1][ans[1].size() - 1];
  cout << endl;
}
int main() {
  int t = 1;
  cin >> t;
  while (t) {
    solve();
    t--;
  }
  return 0;
}
