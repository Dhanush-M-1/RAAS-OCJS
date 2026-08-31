#include <bits/stdc++.h>
using namespace std;
int v[7000], dp[20][10], m;
int l[] = {0, 4, 7};
char s[20];
void PrintMsk(int msk) {
  int i;
  for (i = 0; i < 6; i++, msk /= 3) {
    if (i) printf(" ");
    printf("%d", l[msk % 3]);
  }
  printf("\n");
}
void initvar() {
  int i, tmp;
  for (i = 0, m = 1; i < 6; i++) m *= 3;
  for (i = 0; i < m; i++) {
    tmp = i;
    while (tmp) {
      v[i] += l[tmp % 3];
      tmp /= 3;
    }
  }
}
bool check(int msk) {
  if (msk == 243 || msk == 3 || msk == 1)
    return 1;
  else
    return 0;
}
int dfs(int pos, int lst) {
  int i, t;
  if (dp[pos][lst] != -1) return dp[pos][lst];
  if (!s[pos]) {
    if (lst)
      return dp[pos][lst] = 0;
    else
      return dp[pos][lst] = 1;
  }
  t = s[pos] - '0' + lst * 10;
  for (i = 0; i < m; i++)
    if (v[i] <= t && t - v[i] <= 4) {
      if (check(i)) {
      }
      int tmp = dfs(pos + 1, t - v[i]);
      if (tmp) return dp[pos][lst] = 1;
    }
  return dp[pos][lst] = 0;
}
long long ans[7];
void getans(int pos, int lst) {
  int i, j, t;
  if (!s[pos]) return;
  t = s[pos] - '0' + lst * 10;
  for (i = 0; i < m; i++)
    if (v[i] <= t && t - v[i] <= 4 && dp[pos + 1][t - v[i]]) {
      int tmp = i;
      for (j = 0; j < 6; j++, tmp /= 3) ans[j] = ans[j] * 10 + l[tmp % 3];
      getans(pos + 1, t - v[i]);
      break;
    }
}
void PrintAns() {
  memset(ans, 0, sizeof(ans));
  getans(0, 0);
  for (int i = 0; i < 6; i++) {
    if (i) printf(" ");
    printf("%I64d", ans[i]);
  }
  printf("\n");
}
int main() {
  int t;
  scanf("%d", &t);
  initvar();
  while (t--) {
    long long n = 0;
    scanf("%s", s);
    for (int i = 0; s[i]; i++) n = n * 10 + s[i] - '0';
    memset(dp, -1, sizeof(dp));
    if (!dfs(0, 0))
      printf("-1\n");
    else
      PrintAns();
    long long sum = 0;
    for (int i = 0; i < 6; i++) sum += ans[i];
  }
  return 0;
}
