#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> card[200005][4];
long long dp[200005][10], dp2[4][2], ans;
int main() {
  for (int i = 0; i < 200005; i++)
    for (int j = 0; j < 10; j++) dp[i][j] = -1e18;
  dp[0][0] = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int k;
    scanf("%d", &k);
    for (int j = 1; j <= k; j++) {
      int c, d;
      scanf("%d%d", &c, &d);
      card[i][c].push_back(d);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= 3; j++) {
      int s = (j == 1 ? 3 : 1);
      sort(card[i][j].begin(), card[i][j].end());
      reverse(card[i][j].begin(), card[i][j].end());
      while (card[i][j].size() > s) card[i][j].pop_back();
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j <= 3; j++)
      for (int k = 0; k < 2; k++) dp2[j][k] = -1e18;
    dp2[0][0] = 0;
    vector<pair<int, int> > cur;
    for (int j = 1; j <= 3; j++) {
      int sz = card[i][j].size();
      for (int k = 0; k < sz; k++) cur.push_back(make_pair(j, card[i][j][k]));
    }
    sort(cur.begin(), cur.end());
    do {
      int mana = 3;
      long long score = 0, mx = 0;
      int cnt = 0;
      int sz = cur.size();
      for (int j = 0; j < sz; j++) {
        pair<int, int> x = cur[j];
        cnt++;
        if (mana < x.first) break;
        mana -= x.first;
        mx = max(mx, (long long)x.second);
        score += x.second;
        dp2[cnt][0] = max(dp2[cnt][0], score);
        dp2[cnt][1] = max(dp2[cnt][1], score + mx);
      }
    } while (next_permutation(cur.begin(), cur.end()));
    for (int j = 0; j < 10; j++) {
      for (int k = 0; k <= 3; k++) {
        int nxt = (j + k) % 10;
        int f = (j + k >= 10 ? 1 : 0);
        dp[i + 1][nxt] = max(dp[i + 1][nxt], dp[i][j] + dp2[k][f]);
      }
    }
  }
  for (int i = 0; i <= 9; i++) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
