#include <bits/stdc++.h>
using namespace std;
int t;
long long n;
bool dp[30][30];
pair<int, pair<int, int> > pre[30][30];
int ans[30][30];
inline void build(long long n) {
  vector<int> d;
  d.clear();
  while (n) {
    d.push_back(n % 10);
    n /= 10;
  }
  while ((int)d.size() < 19) d.push_back(0);
  reverse(d.begin(), d.end());
  memset(dp, false, sizeof(dp));
  dp[0][0] = true;
  int give;
  for (int i = 0; i < 19; i++)
    for (int j = 0; j < 10; j++)
      if (dp[i][j]) {
        for (int k4 = 0; k4 <= 6; k4++)
          for (int k7 = 0; k7 <= 6 - k4; k7++) {
            if ((j + 4 * k4 + 7 * k7) % 10 != d[18 - i]) continue;
            give = (j + 4 * k4 + 7 * k7) / 10;
            dp[i + 1][give] = true;
            pre[i + 1][give] = make_pair(j, make_pair(k4, k7));
          }
      }
  if (!dp[19][0])
    cout << "-1\n";
  else {
    memset(ans, 0, sizeof(ans));
    int h = 0, f4, f7;
    for (int i = 19; i; i--) {
      f4 = pre[i][h].second.first;
      f7 = pre[i][h].second.second;
      for (int j = 1; j <= f4; j++) ans[j][i] = 4;
      for (int j = f4 + 1; j <= f4 + f7; j++) ans[j][i] = 7;
      h = pre[i][h].first;
    }
    int beg;
    for (int i = 1; i <= 6; i++) {
      beg = 19;
      while (beg >= 1 && ans[i][beg] == 0) beg--;
      if (beg < 1)
        cout << "0 ";
      else {
        for (int j = beg; j >= 1; j--) cout << ans[i][j];
        cout << " ";
      }
    }
    cout << "\n";
  }
}
int main() {
  srand(time(0));
  ios_base::sync_with_stdio(0);
  cin >> t;
  while (t--) {
    cin >> n;
    build(n);
  }
  return 0;
}
