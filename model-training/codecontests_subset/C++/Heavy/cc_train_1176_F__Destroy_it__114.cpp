#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int const MAXN = 200001;
ll dp[10][MAXN]{};
ll NINF = -(1LL << 60);
ll dp2[2][4];
int n, k;
vector<pair<int, int>> cards[MAXN];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> k;
    vector<int> v[4];
    for (int j = 0; j < k; j++) {
      int c, d;
      cin >> c >> d;
      v[c].push_back(d);
    }
    for (int j = 1; j < 4; j++) {
      sort(v[j].rbegin(), v[j].rend());
    }
    for (int j = 1; j < 4; j++) {
      v[j].resize(min((int)v[j].size(), (j == 1 ? 3 : 1)));
    }
    for (int j = 1; j < 4; j++) {
      for (auto x : v[j]) {
        cards[i].push_back({j, x});
      }
    }
  }
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < MAXN; j++) {
      dp[i][j] = NINF;
    }
  }
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    sort(cards[i].begin(), cards[i].end());
    for (int j = 0; j < 2; j++)
      for (int k = 0; k < 4; k++) dp2[j][k] = NINF;
    dp2[0][0] = 0;
    dp2[1][0] = 0;
    do {
      int mana = 3;
      int cnt = 0;
      ll damage = 0;
      ll MAX = 0;
      for (auto card : cards[i]) {
        if (mana - card.first >= 0) {
          mana -= card.first;
          MAX = max(MAX, (ll)card.second);
          cnt++;
          damage += card.second;
          dp2[0][cnt] = max(dp2[0][cnt], damage);
          dp2[1][cnt] = max(dp2[1][cnt], MAX);
        } else {
          break;
        }
      }
    } while (next_permutation(cards[i].begin(), cards[i].end()));
    for (int j = 0; j < 10; j++) {
      if (dp[j][i] == NINF) continue;
      for (int k = 0; k < 4; k++) {
        if (dp2[0][k] == NINF) continue;
        dp[(j + k) % 10][i + 1] =
            max(dp[(j + k) % 10][i + 1],
                dp[j][i] + dp2[0][k] + (j + k >= 10 ? dp2[1][k] : 0));
      }
    }
  }
  ll ans = 0;
  for (int i = 0; i < 10; i++) {
    ans = max(ans, dp[i][n]);
  }
  cout << ans;
  return 0;
}
