#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
const int MAXN = 1000000;
int n, lim;
int par[MAXN];
vector<int> ch[MAXN];
int dleaf[MAXN];
int dp[MAXN];
void dfsinit(int at) {
  dleaf[at] = ((int)(ch[at]).size()) == 0 ? 0 : INT_MAX;
  dp[at] = ((int)(ch[at]).size()) == 0 ? 1 : 0;
  for (int i = (0); i < (((int)(ch[at]).size())); ++i) {
    int to = ch[at][i];
    dfsinit(to);
    dleaf[at] = min(dleaf[at], 1 + dleaf[to]);
    if (dleaf[to] <= lim - 1) dp[at] += dp[to];
  }
}
int dfsans(int at) {
  int ret = dp[at];
  for (int i = (0); i < (((int)(ch[at]).size())); ++i) {
    int to = ch[at][i];
    int cur = dp[at] + dfsans(to) - (dleaf[to] <= lim - 1 ? dp[to] : 0);
    ret = max(ret, cur);
  }
  return ret;
}
int solve() {
  for (int i = (0); i < (n); ++i)
    if (par[i] != -1) ch[par[i]].push_back(i);
  dfsinit(0);
  return dfsans(0);
}
void run() {
  scanf("%d%d", &n, &lim);
  par[0] = -1;
  for (int i = (1); i < (n); ++i) scanf("%d", &par[i]), --par[i];
  printf("%d\n", solve());
}
int main() {
  run();
  return 0;
}
