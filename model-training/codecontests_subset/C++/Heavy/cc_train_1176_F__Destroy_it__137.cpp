#include <bits/stdc++.h>
using namespace std;
const int N = 200005, M = 105;
const long long MOD = 1e9 + 7;
const double eps = 1e-6;
const double PI = acos(-1.0);
const int oo = 2e9;
int n;
pair<long long, long long> mx[N][4];
long long dp[N][11];
long long calc(int turn, int card_number) {
  if (turn == n) return 0;
  long long& ret = dp[turn][card_number];
  if (ret != -1) return ret;
  ret = calc(turn + 1, card_number);
  for (int cards = 1; cards <= 3; cards++) {
    if (mx[turn][cards].first == -1) continue;
    long long cur = mx[turn][cards].first;
    if (card_number + cards >= 10) cur += mx[turn][cards].second;
    cur += calc(turn + 1, (card_number + cards) % 10);
    ret = max(ret, cur);
  }
  return ret;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int k, c, d;
    scanf("%d", &k);
    map<int, vector<pair<int, int> > > v;
    for (int j = 0; j < k; j++) {
      scanf("%d%d", &c, &d);
      for (int l = 1; l <= 3; l++)
        if (l >= c) v[l].push_back(make_pair(d, c));
    }
    for (int l = 1; l <= 3; l++) {
      int cards = 4 - l;
      sort(v[l].begin(), v[l].end());
      reverse(v[l].begin(), v[l].end());
      mx[i][cards] = make_pair(0, -1);
      int cost = 0, cards_taken = 0;
      for (int j = 0; j < v[l].size() && cards_taken < cards; j++) {
        if (v[l][j].second + cost <= 3) {
          mx[i][cards].second = max(mx[i][cards].second, 1ll * v[l][j].first);
          mx[i][cards].first += v[l][j].first;
          cost += v[l][j].second;
          cards_taken++;
        }
      }
      if (cards_taken != cards) mx[i][cards] = make_pair(-1, -1);
    }
  }
  memset(dp, -1, sizeof dp);
  printf("%lld\n", calc(0, 0));
  return 0;
}
