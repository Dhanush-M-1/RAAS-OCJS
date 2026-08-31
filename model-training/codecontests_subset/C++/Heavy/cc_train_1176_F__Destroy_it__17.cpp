#include <bits/stdc++.h>
using namespace std;
long long modx(long long Base, long long exponent) {
  long long ans = 1;
  if (Base == 1) return Base;
  while (exponent) {
    if (exponent & 1) ans = (ans * Base) % 1000000007LL;
    Base = (Base * Base) % 1000000007LL;
    exponent = exponent >> 1;
  }
  return ans;
}
long long inmodx(long long num) { return (modx(num, 1000000007LL - 2LL)); }
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.second < b.second) return 1;
  if (a.second > b.second) return 0;
  if (a.first <= b.first) return 1;
  return 0;
}
const int N = (2e5) + 9;
const int M = (N << 2) + 9;
const int LOGN = ((int)log2(N)) + 3;
const int LOGM = ((int)log2(M)) + 3;
const int BUCK = 900;
vector<long long> cards[N][4];
long long dp[N][10];
pair<long long, long long> dpp[5];
void func(int ind) {
  int i, j;
  for (i = (0); i < (4); i++) dpp[i] = {-100000000000011LL, -100000000000011LL};
  dpp[0] = {0, 0};
  for (i = (1); i < (4); i++) {
    if ((int)((cards[ind][1]).size()) < i) break;
    dpp[i].first = 0;
    for (j = (0); j < (i); j++) {
      dpp[i].first += cards[ind][1][j];
      dpp[i].second = max(dpp[i].second, cards[ind][1][j]);
    }
  }
  if (!cards[ind][2].empty()) {
    if (cards[ind][2][0] > dpp[1].first)
      dpp[1] = {cards[ind][2][0], cards[ind][2][0]};
    if (!cards[ind][1].empty() &&
        (cards[ind][1][0] + cards[ind][2][0]) > dpp[2].first)
      dpp[2] = {cards[ind][1][0] + cards[ind][2][0],
                max(cards[ind][1][0], cards[ind][2][0])};
  }
  if (!cards[ind][3].empty() && cards[ind][3][0] > dpp[1].first)
    dpp[1] = {cards[ind][3][0], cards[ind][3][0]};
  return;
}
void solve() {
  int n, i, j, k, a, b;
  long long ans = -100000000000011LL;
  cin >> n;
  for (i = (1); i < (n + 1); i++) {
    cin >> k;
    while (k--) {
      cin >> a >> b;
      cards[i][a].push_back(b);
    }
    sort((cards[i][1]).begin(), (cards[i][1]).end(), greater<int>());
    sort((cards[i][2]).begin(), (cards[i][2]).end(), greater<int>());
    sort((cards[i][3]).begin(), (cards[i][3]).end(), greater<int>());
  }
  for (i = (0); i < (n + 1); i++)
    for (j = (0); j < (10); j++) dp[i][j] = -100000000000011LL;
  dp[0][0] = 0;
  for (i = (1); i < (n + 1); i++) {
    func(i);
    for (j = (0); j < (10); j++)
      for (k = (0); k < (4); k++)
        dp[i][j] = max(dp[i][j], dp[i - 1][(j - k + 10) % 10] +
                                     ((j < k) ? (dpp[k].first + dpp[k].second)
                                              : dpp[k].first));
  }
  for (j = (0); j < (10); j++) ans = max(ans, dp[n][j]);
  cout << ans << '\n';
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  clock_t clk;
  clk = clock();
  int t = 1, cs;
  cout << fixed << setprecision(6);
  for (cs = (1); cs < (t + 1); cs++) {
    solve();
  }
  clk = clock() - clk;
  cerr << fixed << setprecision(6) << "Time: " << ((double)clk) / CLOCKS_PER_SEC
       << "\n";
  return 0;
}
