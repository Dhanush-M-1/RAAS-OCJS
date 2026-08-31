#include <bits/stdc++.h>
const int MAXN = 105;
const long long INF = (long long)1e18 + 5;
using namespace std;
struct Mon {
  long long a, b, id;
  bool operator<(const Mon &m) const { return b < m.b; }
};
long long n;
Mon mon[MAXN];
long long dp[MAXN][MAXN], from[MAXN][MAXN];
vector<int> ans;
long long solve(int take) {
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
      dp[i][j] = -INF;
    }
  }
  dp[0][0] = 0;
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j <= n; j++) {
      if (dp[i][j] == -INF) continue;
      if (j < n) {
        long long prof = dp[i][j] + mon[i + 1].a + j * mon[i + 1].b;
        if (dp[i + 1][j + 1] < prof) {
          dp[i + 1][j + 1] = prof;
          from[i + 1][j + 1] = 1;
        }
      }
      long long prof = dp[i][j] + (take - 1) * mon[i + 1].b;
      if (dp[i + 1][j] < prof) {
        dp[i + 1][j] = prof;
        from[i + 1][j] = 0;
      }
    }
  }
  int cur = take;
  vector<int> yes, no;
  for (int i = n; i >= 1; i--) {
    if (from[i][cur]) {
      yes.push_back(mon[i].id);
      cur--;
    } else {
      no.push_back(mon[i].id);
    }
  }
  reverse(yes.begin(), yes.end());
  ans.clear();
  for (int i = 0; i < take - 1; i++) {
    ans.push_back(yes[i]);
  }
  for (int x : no) {
    ans.push_back(x);
    ans.push_back(-x);
  }
  ans.push_back(yes.back());
  return dp[n][take];
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int tc;
  cin >> tc;
  while (tc--) {
    int k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
      int a, b;
      cin >> a >> b;
      mon[i] = {a, b, i};
    }
    long long best = 0, who = 0;
    sort(mon + 1, mon + 1 + n);
    for (int i = 1; i <= k; i++) {
      long long val = solve(i);
      if (val > best) {
        best = val;
        who = i;
      }
    }
    solve(who);
    cout << ans.size() << '\n';
    for (int i = 0; i < ans.size(); i++) {
      cout << ans[i] << " \n"[i + 1 == ans.size()];
    }
  }
}
