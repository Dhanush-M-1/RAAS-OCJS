#include <bits/stdc++.h>
using namespace std;
int n, k;
long long int dp[200000 + 3][10];
vector<pair<int, int> > cards[200000 + 3];
long long int solve(int turn, int takenSoFar) {
  if (turn == n) return 0;
  if (dp[turn][takenSoFar] != -1) return dp[turn][takenSoFar];
  int nCard = (int)cards[turn].size();
  long long int result = -1e18;
  for (int mask = 0; mask < (1 << nCard); mask++) {
    int numTaken = 0;
    int totalCost = 0;
    long long int totalDamage = 0;
    int maxDamage = 0;
    for (int i = 0; i < nCard; i++) {
      if (mask & (1 << i)) {
        numTaken += 1;
        totalCost += cards[turn][i].first;
        totalDamage += cards[turn][i].second;
        maxDamage = max(maxDamage, cards[turn][i].second);
      }
    }
    if (totalCost <= 3) {
      if (takenSoFar + numTaken >= 10) {
        result = max(result, totalDamage + maxDamage +
                                 solve(turn + 1, takenSoFar + numTaken - 10));
      } else {
        result =
            max(result, totalDamage + solve(turn + 1, takenSoFar + numTaken));
      }
    }
  }
  return dp[turn][takenSoFar] = result;
}
int main() {
  scanf("%d", &n);
  for (int turn = 0; turn < n; turn++) {
    scanf("%d", &k);
    vector<int> cardsWithCost[4];
    for (int i = 1; i <= k; i++) {
      int c, d;
      scanf("%d%d", &c, &d);
      cardsWithCost[c].push_back(d);
    }
    for (int c = 1; c <= 3; c++) {
      sort(cardsWithCost[c].begin(), cardsWithCost[c].end());
      if (c == 1) {
        for (int i = cardsWithCost[c].size() - 1;
             i >= max(0, (int)cardsWithCost[c].size() - 3); i--)
          cards[turn].push_back({c, cardsWithCost[c][i]});
      } else {
        if (!cardsWithCost[c].empty())
          cards[turn].push_back({c, cardsWithCost[c].back()});
      }
    }
  }
  memset(dp, -1, sizeof(dp));
  printf("%lld\n", solve(0, 0));
}
