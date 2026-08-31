#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000005;
long long N;
long long nk[MAXN];
long long c1_tmp[MAXN], c1[MAXN][4], c2[MAXN], c3[MAXN];
long long dp[MAXN][11], z[7][3];
bool cmp(long long a, long long b) { return a > b; }
int main() {
  scanf("%I64d", &N);
  int tyf;
  for (int i = 1; i <= N; i++) {
    int ccnt = 0, len = 0, len2 = 0, len3 = 0;
    c2[i] = -1;
    c3[i] = -1;
    scanf("%I64d", &nk[i]);
    for (int j = 1; j <= nk[i]; j++) {
      long long cst, cx;
      scanf("%I64d%I64d", &cst, &cx);
      if (cst == 1) c1_tmp[++ccnt] = cx;
      if (cst == 2) c2[i] = max(c2[i], cx), len2 = 1;
      if (cst == 3) c3[i] = max(c3[i], cx), len3 = 1;
    }
    sort(c1_tmp + 1, c1_tmp + ccnt + 1, cmp);
    c1[i][1] = c1[i][2] = c1[i][3] = -1;
    if (ccnt >= 1) c1[i][1] = c1_tmp[1], ++len;
    if (ccnt >= 2) c1[i][2] = c1_tmp[2], ++len;
    if (ccnt >= 3) c1[i][3] = c1_tmp[3], ++len;
    if (i == 1) tyf = len + len2 + len3;
  }
  for (int i = 0; i <= N; i++) {
    for (int j = 0; j <= 9; j++) {
      dp[i][j] = -1e18;
    }
  }
  dp[0][0] = 0;
  for (int i = 1; i <= N; i++) {
    vector<pair<long long, long long> > vm;
    for (int j = 0; j <= 3; j++) z[j][0] = z[j][1] = -1e18;
    z[0][0] = 0;
    if (c1[i][3] != -1) vm.push_back(make_pair(1, c1[i][3]));
    if (c1[i][2] != -1) vm.push_back(make_pair(1, c1[i][2]));
    if (c1[i][1] != -1) vm.push_back(make_pair(1, c1[i][1]));
    if (c2[i] != -1) vm.push_back(make_pair(2, c2[i]));
    if (c3[i] != -1) vm.push_back(make_pair(3, c3[i]));
    do {
      long long cnt = 0, res = 0, mx = 0, nums = 0;
      for (int j = 0; j < vm.size(); j++) {
        pair<long long, long long> cur = vm[j];
        if (cnt + cur.first > 3) break;
        cnt += cur.first;
        ++nums;
        res += cur.second;
        mx = max(mx, cur.second);
        z[nums][0] = max(z[nums][0], res);
        z[nums][1] = max(z[nums][1], res + mx);
      }
    } while (next_permutation(vm.begin(), vm.end()));
    for (int j = 0; j < 10; j++) {
      for (int k = 0; k <= 3; k++) {
        int fg = 0;
        if (j + k >= 10) fg = 1;
        dp[i][(j + k) % 10] = max(dp[i][(j + k) % 10], dp[i - 1][j] + z[k][fg]);
      }
    }
    vm.clear();
  }
  long long ans = 0;
  for (int j = 0; j <= 9; j++) ans = max(ans, dp[N][j]);
  printf("%I64d\n", ans);
  return 0;
}
