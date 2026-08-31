#include <bits/stdc++.h>
using namespace std;
int mod = 1e9 + 7;
const long long MAX = 1e18;
const long long MIN = -1e18;
using namespace std;
int main() {
  int turns;
  cin >> turns;
  long long dp[turns + 1][10];
  for (int i = 0; i <= turns; i++)
    for (int j = 0; j < 10; j++) dp[i][j] = MIN;
  dp[0][0] = 0;
  int T = 0;
  while (T < turns) {
    int n;
    cin >> n;
    vector<pair<int, long long> > card;
    for (int i = 1; i <= n; i++) {
      int c, d;
      cin >> c >> d;
      card.push_back({c, d});
    }
    vector<long long> temp[4];
    vector<pair<int, long long> > curr;
    for (int i = 0; i < n; i++) temp[card[i].first].push_back(card[i].second);
    for (int i = 1; i <= 3; i++) sort(temp[i].rbegin(), temp[i].rend());
    if (temp[3].size() >= 1) curr.push_back({3, temp[3][0]});
    if (temp[2].size() >= 1) curr.push_back({2, temp[2][0]});
    for (int i = 0; i < min(3, (int)temp[1].size()); i++)
      curr.push_back({1, temp[1][i]});
    long long val[4][2];
    for (int i = 0; i < 4; i++) val[i][0] = MIN, val[i][1] = MIN;
    val[0][0] = 0;
    sort(curr.begin(), curr.end());
    do {
      int mana = 3;
      long long score = 0;
      long long mx = 0;
      int cnt = 0;
      for (auto x : curr) {
        cnt++;
        if (mana < x.first) break;
        mana -= x.first;
        mx = max(mx, (long long)(x.second));
        score += x.second;
        val[cnt][0] = max(val[cnt][0], score);
        val[cnt][1] = max(val[cnt][1], score + mx);
      }
    } while (next_permutation(curr.begin(), curr.end()));
    for (int y = 0; y < 10; y++) {
      for (int x = 0; x <= 3; x++)
        dp[T + 1][(x + y) % 10] = max(dp[T + 1][(y + x) % 10],
                                      dp[T][y] + val[x][x + y >= 10 ? 1 : 0]);
    }
    T++;
  }
  long long mx = 0;
  for (int i = 0; i < 10; i++) mx = max(mx, dp[turns][i]);
  cout << mx;
}
