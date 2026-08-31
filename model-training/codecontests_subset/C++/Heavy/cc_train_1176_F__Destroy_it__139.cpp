#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18 + 7;
const long long mod = 998244353;
const int maxn = 2e5 + 7;
long long dp[4][2];
long long dp2[maxn][10];
void solve() {
  int n;
  cin >> n;
  for (int i = 0; i <= n; i++) {
    for (int j = 0; j < 10; j++) {
      dp2[i][j] = -INF;
    }
  }
  dp2[0][0] = 0;
  for (int iter = 1; iter <= n; iter++) {
    int ki;
    cin >> ki;
    vector<long long> cards[4];
    for (int i = 0; i < ki; i++) {
      int cj;
      long long dj;
      cin >> cj >> dj;
      cards[cj].push_back(dj);
    }
    for (int i = 1; i <= 3; i++) {
      sort(cards[i].rbegin(), cards[i].rend());
    }
    vector<pair<int, long long>> turn_cards;
    for (int i = 0; i < min(3, (int)cards[1].size()); i++) {
      turn_cards.push_back({1, cards[1][i]});
    }
    if (cards[2].size()) {
      turn_cards.push_back({2, cards[2][0]});
    }
    if (cards[3].size()) {
      turn_cards.push_back({3, cards[3][0]});
    }
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 2; j++) {
        dp[i][j] = -INF;
      }
    }
    dp[0][0] = 0;
    sort(turn_cards.begin(), turn_cards.end());
    do {
      long long max_dmg = 0;
      long long mana = 3;
      long long sum = 0;
      for (int i = 0; i < turn_cards.size(); i++) {
        if (turn_cards[i].first > mana) {
          break;
        }
        mana -= turn_cards[i].first;
        max_dmg = max(max_dmg, turn_cards[i].second);
        sum += turn_cards[i].second;
        dp[i + 1][0] = max(dp[i + 1][0], sum);
        dp[i + 1][1] = max(dp[i + 1][1], sum + max_dmg);
      }
    } while (next_permutation(turn_cards.begin(), turn_cards.end()));
    for (int j = 0; j <= 9; j++) {
      for (int k = 0; k <= 3; k++) {
        int next = j + k;
        int id = 0;
        if (next >= 10) {
          next -= 10;
          id++;
        }
        dp2[iter][next] = max(dp2[iter][next], dp2[iter - 1][j] + dp[k][id]);
      }
    }
  }
  long long ans = 0;
  for (int j = 0; j <= 9; j++) {
    ans = max(ans, dp2[n][j]);
  }
  cout << ans;
}
int main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(false);
  solve();
  return 0;
}
