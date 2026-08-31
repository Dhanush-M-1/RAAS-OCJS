#include <bits/stdc++.h>
using namespace std;
struct Node {
  int ex, mini;
  int pref[335];
};
Node block[335];
vector<int> posi[200010];
int n, k, ara[200010], val[200010], dp[200010];
int blockSz;
int which(int p) { return (p / blockSz); }
void add(int &a, int b) {
  a += b;
  if (a >= 998244353) a -= 998244353;
}
void calDp(int bi) {
  int first = max(1, blockSz * bi), last = blockSz * (bi + 1) - 1;
  int mini, &ex = block[bi].ex;
  for (int i = first; i <= last; i++) val[i] += ex;
  mini = INT_MAX;
  ex = 0;
  for (int i = first; i <= last; i++) mini = min(val[i], mini);
  for (int i = first; i <= last; i++) val[i] -= mini;
  ex = mini;
  mini = 0;
  memset(block[bi].pref, 0, sizeof(block[bi].pref));
  for (int i = first; i <= last; i++) add(block[bi].pref[val[i]], dp[i - 1]);
  for (int i = 1; i <= blockSz; i++)
    add(block[bi].pref[i], block[bi].pref[i - 1]);
}
void update(int l, int r, int v) {
  for (int i = l; i <= r; i++) {
    int blockId = which(i), first = blockSz * blockId,
        last = blockSz * (blockId + 1) - 1;
    if (l <= first && last <= r)
      block[blockId].ex += v, i = last;
    else
      val[i] += v;
  }
  calDp(which(l));
  calDp(which(r));
}
int main() {
  ios::sync_with_stdio(false);
  int v;
  cin >> n >> k;
  blockSz = sqrt(n) + 1;
  for (int i = 0; i <= 200010 - 1; i++) posi[i].push_back(0);
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    cin >> v;
    int p = (int)posi[v].size() - 1;
    if (posi[v].size() >= 2) update(posi[v][p - 1] + 1, posi[v][p], -1);
    posi[v].push_back(i);
    p = (int)posi[v].size() - 1;
    update(posi[v][p - 1] + 1, posi[v][p], 1);
    dp[i] = 0;
    int til = which(i);
    for (int bi = 0; bi <= til; bi++) {
      int can = k - block[bi].ex;
      if (can >= 0) add(dp[i], block[bi].pref[min(blockSz, can)]);
    }
  }
  cout << dp[n] << endl;
  return 0;
}
