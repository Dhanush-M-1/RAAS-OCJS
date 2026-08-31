#include <bits/stdc++.h>
using namespace std;
int n;
int a[105], b[105];
pair<int, int> dp[105][105 * 105];
bool seen[105][105 * 105];
int tsa;
pair<int, int> f(int i, int sb) {
  if (seen[i][sb]) return dp[i][sb];
  seen[i][sb] = true;
  if (i == n) {
    if (sb >= tsa) {
      return dp[i][sb] = make_pair(0, 0);
    } else {
      return dp[i][sb] = make_pair(105, 0);
    }
  } else {
    auto p = f(i + 1, sb);
    p.second += a[i];
    auto op = f(i + 1, sb + b[i]);
    op.first += 1;
    return dp[i][sb] = min(op, p);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = (0); i < (n); i++) {
    scanf("%d", a + i);
    tsa += a[i];
  }
  for (int i = (0); i < (n); i++) scanf("%d", b + i);
  auto p = f(0, 0);
  printf("%d %d\n", p.first, p.second);
  return 0;
}
