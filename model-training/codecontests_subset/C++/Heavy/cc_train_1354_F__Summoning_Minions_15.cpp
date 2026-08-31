#include <bits/stdc++.h>
using namespace std;
pair<pair<int, int>, int> ba[102];
int g[102][102], dp[102][102];
int ans[102];
vector<int> ansvec;
bool compba(pair<pair<int, int>, int> a, pair<pair<int, int>, int> b) {
  if (a.first.first != b.first.first) return a.first.first < b.first.first;
  return a.first.second < b.first.second;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n, k;
    scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; i++) {
      int ai, bi;
      scanf("%d%d", &ai, &bi);
      ba[i] = {{bi, ai}, i};
    }
    sort(ba + 1, ba + n + 1, compba);
    for (int i = 0; i <= n; i++)
      for (int j = 0; j <= k; j++) dp[i][j] = -1;
    for (int i = 0; i <= n; i++)
      for (int j = 0; j <= k; j++) g[i][j] = -1;
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= min(i - 1, k); j++) {
        int a0 = (k - 1) * ba[i].first.first;
        int a1 = min(k - 1, j) * ba[i].first.first + ba[i].first.second;
        if (dp[i][j] < dp[i - 1][j] + a0) {
          dp[i][j] = dp[i - 1][j] + a0;
          g[i][j] = 0;
        }
        if (j + 1 <= k) {
          if (dp[i][j + 1] < dp[i - 1][j] + a1) {
            dp[i][j + 1] = dp[i - 1][j] + a1;
            g[i][j + 1] = 1;
          }
        }
      }
    }
    int fi = n, fj = k;
    int lk = -1;
    while (fi) {
      int ai = ba[fi].second;
      if (g[fi][fj]) {
        ans[ai] = fj;
        if (fj == k) lk = ai;
        fj--;
      } else
        ans[ai] = 0;
      fi--;
    }
    ansvec.clear();
    ansvec.assign(k - 1, 0);
    for (int i = 1; i <= n; i++) {
      if (ans[i]) {
        if (ans[i] < k) ansvec[ans[i] - 1] = i;
      }
    }
    for (int i = 1; i <= n; i++) {
      if (!ans[i]) {
        ansvec.push_back(i);
        ansvec.push_back(-i);
      }
    }
    ansvec.push_back(lk);
    printf("%d\n", ansvec.size());
    for (auto it : ansvec) printf("%d ", it);
    printf("\n");
  }
  return 0;
}
