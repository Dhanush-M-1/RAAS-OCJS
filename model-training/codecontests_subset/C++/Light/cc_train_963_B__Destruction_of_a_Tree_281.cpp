#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 3;
vector<int> ed[N];
int dp[N][2];
int PreDel[N];
int dps(int u, int ct) {
  if (dp[u][ct] != -1) return dp[u][ct];
  int t = 0, tr = 0, sz = ed[u].size();
  int l, r;
  for (int i = 0; i < sz; i++) {
    l = dps(ed[u][i], 1);
    r = dps(ed[u][i], 0);
    if (!l && !r) return dp[u][ct] = 0;
    if (l && r) {
      PreDel[ed[u][i]] = 1;
      t = ed[u][i];
    } else if (!l && r) {
      PreDel[ed[u][i]] = 0;
      tr++;
    } else
      PreDel[ed[u][i]] = 1;
  }
  if ((tr % 2) != ct && !t) return dp[u][ct] = 0;
  if ((tr % 2) != ct) PreDel[t] = 0;
  return dp[u][ct] = 1;
}
void print(int u) {
  int sz = ed[u].size();
  for (int i = 0; i < sz; i++)
    if (PreDel[ed[u][i]] == 1) print(ed[u][i]);
  printf("%d\n", u);
  for (int i = 0; i < sz; i++)
    if (PreDel[ed[u][i]] == 0) print(ed[u][i]);
}
int main() {
  int n;
  scanf("%d", &n);
  int fr, root;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &fr);
    if (fr)
      ed[fr].push_back(i);
    else
      root = i;
  }
  memset(dp, 0xff, sizeof dp);
  int ret = dps(root, 0);
  if (!ret)
    printf("NO");
  else {
    printf("YES\n");
    print(root);
  }
  return 0;
}
