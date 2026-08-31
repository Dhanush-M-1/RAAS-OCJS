#include <bits/stdc++.h>
using namespace std;
long long int n, md[200010][10], td[200010][10], cnt[10], memo[200010][10];
long long int dp(long long int pos, long long int kartu) {
  long long int ret, temp;
  if (pos == n) return 0;
  if (memo[pos][kartu] != -1) return memo[pos][kartu];
  ret = dp(pos + 1, kartu);
  for (long long int p = 0; p < 6; p++) {
    if (md[pos][p] < 1) continue;
    temp = dp(pos + 1, (kartu + cnt[p]) % 10) + td[pos][p];
    if (kartu + cnt[p] > 9) temp += md[pos][p];
    ret = max(ret, temp);
  }
  memo[pos][kartu] = ret;
  return ret;
}
using namespace std;
int main() {
  long long int k, c, d, ans, x, y, z;
  vector<long long int> dam[5];
  scanf("%lld", &n);
  for (long long int i = 0; i < n; i++) {
    scanf("%lld", &k);
    for (long long int j = 1; j < 4; j++) dam[j].clear();
    for (long long int j = 0; j < k; j++) {
      scanf("%lld %lld", &c, &d);
      dam[c].push_back(d);
    }
    for (long long int j = 1; j < 4; j++) sort(dam[j].rbegin(), dam[j].rend());
    md[i][0] = md[i][1] = md[i][2] = md[i][3] = md[i][4] = md[i][5] = 0;
    x = dam[1].size();
    y = dam[2].size();
    z = dam[3].size();
    if (x > 0) td[i][0] = md[i][0] = dam[1][0];
    if (x > 1) {
      md[i][1] = dam[1][0];
      td[i][1] = dam[1][0] + dam[1][1];
    }
    if (x > 2) {
      md[i][2] = dam[1][0];
      td[i][2] = dam[1][0] + dam[1][1] + dam[1][2];
    }
    if (y > 0) td[i][3] = md[i][3] = dam[2][0];
    if ((y > 0) && (x > 0)) {
      td[i][4] = dam[1][0] + dam[2][0];
      md[i][4] = max(dam[1][0], dam[2][0]);
    }
    if (z > 0) td[i][5] = md[i][5] = dam[3][0];
  }
  cnt[0] = cnt[3] = cnt[5] = 1;
  cnt[1] = cnt[4] = 2;
  cnt[2] = 3;
  memset(memo, -1, sizeof memo);
  ans = dp(0, 0);
  printf("%lld\n", ans);
  return 0;
}
