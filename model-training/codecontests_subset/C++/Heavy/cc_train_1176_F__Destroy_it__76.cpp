#include <bits/stdc++.h>
void print_array(int *a, int n) {
  printf("#");
  for (int i = 0; i < n; i++) printf("%d%c", a[i], i == n - 1 ? '\n' : ' ');
}
using namespace std;
const double EPS = 1e-8;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const int sz = 3e5 + 9;
int m;
vector<long long> card[5];
void init() {
  for (int i = 1; i < 4; ++i) {
    card[i].clear();
  }
}
long long max3(long long a, long long b, long long c) {
  return max(a, max(b, c));
}
long long get_best(int cnt, bool doub) {
  long long ans = -1;
  if (cnt == 0)
    return 0;
  else if (cnt == 1) {
    if (card[1].size() >= 1) ans = max(ans, card[1][0] * (1 + doub));
    if (card[2].size() >= 1) ans = max(ans, card[2][0] * (1 + doub));
    if (card[3].size() >= 1) ans = max(ans, card[3][0] * (1 + doub));
  } else if (cnt == 2) {
    if (card[1].size() >= 2)
      ans = max(ans,
                card[1][0] + card[1][1] + doub * max(card[1][0], card[1][1]));
    if (card[1].size() >= 1 && card[2].size() >= 1)
      ans = max(ans,
                card[1][0] + card[2][0] + doub * max(card[1][0], card[2][0]));
  } else if (cnt == 3) {
    if (card[1].size() >= 3)
      ans = max(ans, card[1][0] + card[1][1] + card[1][2] +
                         doub * max3(card[1][0], card[1][1], card[1][2]));
  }
  return ans;
}
long long dp[sz][15];
void solve() {
  for (int i = 0; i < m + 4; ++i)
    for (int j = 0; j < 10; ++j) dp[i][j] = -INF;
  dp[0][0] = 0;
  for (int I = 1; I < m + 1; ++I) {
    init();
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
      int c, x;
      scanf("%d%d", &c, &x);
      card[c].push_back(x);
    }
    for (int i = 1; i < 4; ++i) {
      sort(card[i].begin(), card[i].end(), [](int a, int b) { return a > b; });
    }
    for (int lastnum = 0; lastnum < 10; ++lastnum) {
      for (int choose = 0; choose < 4; ++choose) {
        int num = lastnum + choose;
        long long best = get_best(choose, num >= 10);
        if (best >= 0)
          dp[I][num % 10] = max(dp[I][num % 10], dp[I - 1][lastnum] + best);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; ++i) {
    ans = max(ans, dp[m][i]);
  }
  cout << ans << endl;
}
int main() {
  cin >> m;
  solve();
  return 0;
}
