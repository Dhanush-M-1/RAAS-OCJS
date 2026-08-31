#include <bits/stdc++.h>
using namespace std;
constexpr static int MAXN = 80;
int n, k;
int a[MAXN], b[MAXN];
int dp[MAXN][MAXN];
bool added[MAXN][MAXN];
bool used[MAXN];
void solve() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  vector<pair<int, int>> bval(n);
  for (int i = 0; i < n; i++) bval[i] = {b[i], i};
  sort(bval.begin(), bval.end());
  for (int i = 0; i <= n; i++)
    for (int j = 0; j <= k; j++) dp[i][j] = -1e9, added[i][j] = false;
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    int l = bval[i].second;
    for (int j = 0; j <= k; j++) {
      dp[i + 1][j] = dp[i][j] + (k - 1) * b[l];
      if (j == 0) continue;
      int cost = a[l] + (j - 1) * b[l];
      if (dp[i + 1][j] < dp[i][j - 1] + cost) {
        dp[i + 1][j] = dp[i][j - 1] + cost;
        added[i + 1][j] = true;
      }
    }
  }
  for (int i = 0; i < n; i++) used[i] = false;
  vector<int> c;
  int j = k;
  for (int i = n; i > 0; i--) {
    if (added[i][j]) {
      c.push_back(bval[i - 1].second);
      used[c.back()] = true;
      j--;
    }
  }
  reverse(c.begin(), c.end());
  vector<int> moves;
  for (int i = 0; i + 1 < c.size(); i++) moves.push_back(c[i] + 1);
  for (int i = 0; i < n; i++)
    if (!used[i]) moves.push_back(i + 1), moves.push_back(-(i + 1));
  moves.push_back(c.back() + 1);
  cout << moves.size() << endl;
  for (int i = 0; i < moves.size(); i++)
    cout << moves[i] << (i + 1 == moves.size() ? '\n' : ' ');
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int T;
  cin >> T;
  while (T--) {
    solve();
  }
}
