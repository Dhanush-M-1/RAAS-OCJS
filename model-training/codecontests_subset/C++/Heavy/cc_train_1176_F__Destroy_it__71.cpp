#include <bits/stdc++.h>
using namespace std;
int turn;
long long max_dame[200005][10];
int mana_cost[4][200005], mem[4];
long long moves[4];
void process(int pos) {
  int amount;
  scanf("%d", &amount);
  mem[1] = 2, mem[2] = 1, mem[3] = 1;
  for (int i = 1; i <= amount; i++) {
    int mana, damage;
    scanf("%d %d", &mana, &damage);
    mana_cost[mana][++mem[mana]] = damage;
  }
  for (int i = 1; i <= 3; i++)
    sort(mana_cost[i] + 1, mana_cost[i] + mem[i] + 1);
  moves[1] =
      max({mana_cost[1][mem[1]], mana_cost[2][mem[2]], mana_cost[3][mem[3]]});
  if (mem[1] >= 4 || (mem[1] >= 3 && mem[2] >= 2))
    moves[2] = mana_cost[1][mem[1]] +
               max(mana_cost[1][mem[1] - 1], mana_cost[2][mem[2]]);
  else
    moves[2] = -(long long)1e18;
  if (mem[1] >= 5)
    moves[3] = (long long)mana_cost[1][mem[1]] + mana_cost[1][mem[1] - 1] +
               mana_cost[1][mem[1] - 2];
  else
    moves[3] = -(long long)1e18;
  for (int remain = 0; remain <= 9; remain++) {
    max_dame[pos][remain] = max_dame[pos - 1][remain];
    long long one = moves[1];
    int pre = (remain - 1 + 10) % 10;
    if (remain < 1) one *= 2;
    max_dame[pos][remain] =
        max(max_dame[pos][remain], max_dame[pos - 1][pre] + one);
    long long two = moves[2];
    pre = (remain - 2 + 10) % 10;
    if (remain < 2) two += max(mana_cost[1][mem[1]], mana_cost[2][mem[2]]);
    max_dame[pos][remain] =
        max(max_dame[pos][remain], max_dame[pos - 1][pre] + two);
    long long three = moves[3];
    pre = (remain - 3 + 10) % 10;
    if (remain < 3) three += mana_cost[1][mem[1]];
    max_dame[pos][remain] =
        max(max_dame[pos][remain], max_dame[pos - 1][pre] + three);
  }
}
void solve() {
  for (int i = 0; i <= turn; i++)
    for (int j = 0; j < 10; j++) max_dame[i][j] = -(long long)1e18;
  max_dame[0][0] = 0;
  for (int i = 1; i <= turn; i++) process(i);
  int res = 0;
  for (int remain = 0; remain < 10; remain++)
    if (max_dame[turn][remain] > max_dame[turn][res]) res = remain;
  printf("%lld", max_dame[turn][res]);
}
int main() {
  scanf("%d", &turn);
  solve();
}
