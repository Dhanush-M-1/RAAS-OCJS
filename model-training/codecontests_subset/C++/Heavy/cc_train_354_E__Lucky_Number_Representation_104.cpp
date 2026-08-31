#include <bits/stdc++.h>
using namespace std;
string to[110];
void build(int dep, string now, int val) {
  if (dep == 6) {
    to[val] = now;
    return;
  }
  char f0 = '0' + 0;
  char f4 = '0' + 4;
  char f7 = '0' + 7;
  build(dep + 1, now + f0, val + 0);
  build(dep + 1, now + f4, val + 4);
  build(dep + 1, now + f7, val + 7);
}
void init() {
  for (int i = 0; i <= 100; i++) to[i] = ".";
  build(0, "", 0);
}
int dp[20][10];
int pre[20][10];
int val[20][10];
int pp[110];
int qq;
int dfs(int pos, int need) {
  if (pos == -1) return need == 0;
  if (dp[pos][need] != -1) return dp[pos][need];
  int digit = need * 10 + pp[pos];
  for (int add = 0; add <= 5; add++) {
    int now = digit - add;
    if (now < 0) continue;
    if (dfs(pos - 1, add) == 1 && to[now] != ".") {
      dp[pos][need] = 1;
      val[pos][need] = now;
      pre[pos][need] = add;
      return 1;
    }
  }
  dp[pos][need] = 0;
  return 0;
}
string out[110];
int main() {
  init();
  int cas;
  scanf("%d", &cas);
  for (int cc = 1; cc <= cas; cc++) {
    long long s;
    scanf("%I64d", &s);
    qq = 0;
    while (s) {
      pp[qq++] = s % 10;
      s /= 10;
    }
    memset(dp, -1, sizeof(dp));
    if (dfs(qq - 1, 0) == 0)
      printf("-1\n");
    else {
      for (int i = 0; i < 6; i++)
        out[i] = "0000000000000000000000000000000000000000";
      int x = qq - 1;
      int y = 0;
      while (x != -1) {
        int s = val[x][y];
        for (int i = 0; i < 6; i++) out[i][x] = to[s][i];
        y = pre[x][y];
        x--;
      }
      for (int i = 0; i < 6; i++) {
        int end = 0;
        for (int j = 0; j < 30; j++)
          if (out[i][j] != '0') end = j;
        for (int j = end; j >= 0; j--) printf("%c", out[i][j]);
        if (i == 5)
          printf("\n");
        else
          printf(" ");
      }
    }
  }
  return 0;
}
