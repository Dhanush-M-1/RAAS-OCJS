#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<ll>;
const int maxn = 80;
ll n, dp[maxn][maxn], p[maxn][maxn];
vector<pair<ll, ll>> a;
vi used;
map<pair<ll, ll>, vi> idx;
vi ans;
void track(int n, int k) {
  if (!n) return;
  if (p[n][k] == 2) {
    track(n - 1, k - 1);
    used[idx[a[n - 1]].back()] = 1;
    ans.push_back(idx[a[n - 1]].back());
    idx[a[n - 1]].pop_back();
  } else
    track(n - 1, k);
}
void solve() {
  int n, k;
  cin >> n >> k;
  memset(dp, -1, sizeof dp);
  a = vector<pair<ll, ll>>(n);
  dp[0][0] = 0;
  for (auto &i : a) cin >> i.second >> i.first;
  for (int i = 0; i < n; i++) idx[{a[i].second, a[i].first}].push_back(i + 1);
  sort(a.begin(), a.end());
  for (auto &i : a) swap(i.first, i.second);
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= k; j++) {
      if (dp[i][j] < 0) continue;
      dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] + (k - 1) * a[i].second);
      if (dp[i + 1][j] == dp[i][j] + (k - 1) * a[i].second) p[i + 1][j] = 1;
      if (j < k) {
        dp[i + 1][j + 1] =
            max(dp[i + 1][j + 1], dp[i][j] + j * a[i].second + a[i].first);
        if (dp[i + 1][j + 1] == dp[i][j] + j * a[i].second + a[i].first)
          p[i + 1][j + 1] = 2;
      }
    }
  }
  used = vi(n + 1, 0);
  ans.clear();
  track(n, k);
  int ab = ans.back();
  ans.pop_back();
  for (int i = 1; i <= n; i++)
    if (!used[i]) ans.push_back(i), ans.push_back(-i);
  ans.push_back(ab);
  cout << ans.size() << '\n';
  for (auto i : ans) cout << i << " ";
  cout << '\n';
}
int main() {
  cin.tie(0)->sync_with_stdio(0);
  int t;
  cin >> t;
  while (t--) solve();
}
