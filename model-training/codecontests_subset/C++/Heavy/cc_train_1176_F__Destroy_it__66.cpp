#include <bits/stdc++.h>
using namespace std;
const long long INF = (1ll << 62);
vector<pair<int, long long> > a;
int n, k[200010];
long long dp[200010][11], t1[200010], s1[200010][4], s2[200010], s3[200010],
    md[5][2], ans = 0;
bool cmp(int _, int __) { return _ > __; }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int cnt = 0, l1 = 0, l2 = 0, l3 = 0;
    scanf("%d", &k[i]);
    s1[i][1] = -1ll;
    s1[i][2] = -1ll;
    s1[i][3] = -1ll;
    s2[i] = -1ll;
    s3[i] = -1ll;
    for (int j = 1; j <= k[i]; j++) {
      int c;
      long long d;
      scanf("%d %I64d", &c, &d);
      switch (c) {
        case 1:
          t1[++cnt] = d;
          break;
        case 2:
          s2[i] = max(s2[i], d);
          l2 = 1;
          break;
        case 3:
          s3[i] = max(s3[i], d);
          l3 = 1;
          break;
      }
    }
    sort(t1 + 1, t1 + cnt + 1, cmp);
    if (cnt >= 1) {
      s1[i][1] = t1[1];
      l1++;
    }
    if (cnt >= 2) {
      s1[i][2] = t1[2];
      l1++;
    }
    if (cnt >= 3) {
      s1[i][3] = t1[3];
      l1++;
    }
  }
  for (int i = 0; i <= n; i++)
    for (int j = 0; j <= 9; j++) dp[i][j] = -INF;
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= 3; j++) {
      md[j][0] = -INF;
      md[j][1] = -INF;
    }
    md[0][0] = 0;
    a.clear();
    if (s1[i][3] != -1ll) a.push_back(make_pair(1, s1[i][3]));
    if (s1[i][2] != -1ll) a.push_back(make_pair(1, s1[i][2]));
    if (s1[i][1] != -1ll) a.push_back(make_pair(1, s1[i][1]));
    if (s2[i] != -1ll) a.push_back(make_pair(2, s2[i]));
    if (s3[i] != -1ll) a.push_back(make_pair(3, s3[i]));
    do {
      long long tot = 0, mx = 0;
      int cnt = 0, ccnt = 0;
      for (int j = 0; j < a.size(); j++) {
        pair<int, long long> tmp = a[j];
        if (cnt + tmp.first > 3) break;
        cnt += tmp.first;
        ccnt++;
        tot += tmp.second;
        mx = max(mx, tmp.second);
        md[ccnt][0] = max(md[ccnt][0], tot);
        md[ccnt][1] = max(md[ccnt][1], tot + mx);
      }
    } while (next_permutation(a.begin(), a.end()));
    for (int j = 0; j <= 9; j++)
      for (int kk = 0; kk <= 3; kk++) {
        int f = (j + kk >= 10 ? 1 : 0);
        dp[i][(j + kk) % 10] =
            max(dp[i][(j + kk) % 10], dp[i - 1][j] + md[kk][f]);
      }
  }
  for (int i = 0; i <= 9; i++) ans = max(ans, dp[n][i]);
  printf("%I64d", ans);
  return 0;
}
