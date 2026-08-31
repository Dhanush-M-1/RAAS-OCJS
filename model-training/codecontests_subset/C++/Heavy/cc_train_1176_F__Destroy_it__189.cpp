#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int MAX_N = 2e5;
vector<ll> card[3][MAX_N];
ll dp[10][MAX_N];
int n;
ll rec(int t, int p) {
  if (p == n) return 0;
  ll& ret = dp[t][p];
  if (ret != -1) return ret;
  ret = rec(t, p + 1);
  int i;
  for (i = 0; i < card[0][p].size(); i++)
    ret = max(ret, rec((t + 1) % 10, p + 1) + (!t ? 2 : 1) * card[0][p][i]);
  if (!card[1][p].empty())
    ret = max(ret, rec((t + 1) % 10, p + 1) + (!t ? 2 : 1) * card[1][p][0]);
  if (!card[2][p].empty())
    ret = max(ret, rec((t + 1) % 10, p + 1) + (!t ? 2 : 1) * card[2][p][0]);
  if (card[0][p].size() > 1)
    ret = max(ret, rec((t + 2) % 10, p + 1) +
                       (!t || t + 2 > 10 ? 2 : 1) * card[0][p][0] +
                       card[0][p][1]);
  if (!card[0][p].empty() && !card[1][p].empty())
    ret = max(ret, rec((t + 2) % 10, p + 1) +
                       (!t || t + 2 > 10 ? 2 : 1) *
                           max(card[0][p][0], card[1][p].back()) +
                       min(card[0][p][0], card[1][p].back()));
  if (card[0][p].size() == 3)
    ret = max(ret, rec((t + 3) % 10, p + 1) +
                       (!t || t + 3 > 10 ? 2 : 1) * card[0][p][0] +
                       card[0][p][1] + card[0][p][2]);
  return ret;
}
int main() {
  memset(dp, -1, sizeof dp);
  int k, i, j;
  ll cx, dx;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &k);
    for (j = 0; j < k; j++) {
      scanf("%lld%lld", &cx, &dx);
      cx--;
      if (cx) {
        if (card[cx][i].empty())
          card[cx][i].push_back(dx);
        else
          card[cx][i].back() = max(card[cx][i].back(), dx);
      } else {
        if (card[cx][i].size() < 3) {
          card[cx][i].push_back(dx);
          sort(card[cx][i].begin(), card[cx][i].end(),
               [](const ll& a, const ll& b) { return a > b; });
        } else {
          card[cx][i][2] = max(card[cx][i][2], dx);
          sort(card[cx][i].begin(), card[cx][i].end(),
               [](const ll& a, const ll& b) { return a > b; });
        }
      }
    }
  }
  printf("%lld", rec(1, 0));
  return 0;
};
