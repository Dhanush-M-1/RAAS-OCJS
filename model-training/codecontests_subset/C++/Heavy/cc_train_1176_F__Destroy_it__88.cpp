#include <bits/stdc++.h>
using namespace std;
int n, k;
bool mark[10][200010];
long long memo[10][200010];
vector<int> t[4][200010];
long long dp(int turn, int cards) {
  if (turn == n) return 0;
  long long& ans = memo[cards][turn];
  if (mark[cards][turn]) return ans;
  mark[cards][turn] = true;
  ans = dp(turn + 1, cards);
  long long dmg;
  if (t[3][turn].size()) {
    dmg = t[3][turn][0];
    if (cards == 9) dmg *= 2LL;
    ans = max(ans, dp(turn + 1, (cards + 1) % 10) + dmg);
  }
  if (t[1][turn].size()) {
    int l = t[1][turn].size();
    dmg = t[1][turn][0];
    if (cards == 9) dmg *= 2LL;
    ans = max(ans, dp(turn + 1, (cards + 1) % 10) + dmg);
    if (l >= 2) {
      dmg = t[1][turn][0];
      if (cards >= 8) dmg *= 2LL;
      ans = max(ans, dp(turn + 1, (cards + 2) % 10) + dmg + t[1][turn][1]);
    }
    if (l >= 3) {
      dmg = t[1][turn][0];
      if (cards >= 7) dmg *= 2LL;
      ans = max(ans, dp(turn + 1, (cards + 3) % 10) + dmg + t[1][turn][1] +
                         t[1][turn][2]);
    }
  }
  if (t[2][turn].size()) {
    dmg = t[2][turn][0];
    if (cards == 9) dmg *= 2LL;
    ans = max(ans, dp(turn + 1, (cards + 1) % 10) + dmg);
    if (t[1][turn].size()) {
      long long a = t[2][turn][0], b = t[1][turn][0];
      if (cards >= 8 && a > b) {
        a *= 2LL;
      } else if (cards >= 8) {
        b *= 2LL;
      }
      dmg = a + b;
      ans = max(ans, dp(turn + 1, (cards + 2) % 10) + dmg);
    }
  }
  return ans;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &k);
    for (int j = 0; j < k; j++) {
      int ci, di;
      scanf("%d %d", &ci, &di);
      t[ci][i].push_back(di);
    }
    for (int j = 1; j <= 3; j++)
      sort(t[j][i].begin(), t[j][i].end(), greater<int>());
  }
  printf("%lld\n", dp(0, 0));
  return 0;
}
