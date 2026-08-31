#include <bits/stdc++.h>
using namespace std;
int N, R, C, a[1000010][30], sum[1000010];
string str[1000010];
char s[5100000];
int id, mx, len[1000010];
int find_root(int k, int r) {
  int u = k;
  for (int i = 0; i < 30; i++) {
    if (r & (1 << i)) u = a[u][i];
  }
  return u - k;
}
int main() {
  scanf("%d%d%d", &N, &R, &C);
  int cu = 0;
  for (int i = 1; i <= N; i++) {
    scanf("%s", s + cu);
    len[i] = strlen(s + cu);
    if (i > 1)
      sum[i] = len[i] + sum[i - 1];
    else
      sum[i] = len[i];
    cu += len[i];
  }
  for (int i = 1; i <= N; i++) {
    int ed = max(i, a[i - 1][0]);
    while (ed <= N && ed - i + sum[ed] - sum[i - 1] <= C) ed++;
    a[i][0] = ed;
  }
  for (int j = 0; j < 30; j++) a[N + 1][j] = N + 1;
  for (int j = 1; j < 30; j++)
    for (int i = 1; i <= N; i++) a[i][j] = a[a[i][j - 1]][j - 1];
  id = 1;
  mx = 0;
  for (int i = 1; i <= N; i++) {
    int cnt = find_root(i, R);
    if (mx < cnt) mx = cnt, id = i;
  }
  int cur = 0, pos = -1;
  for (int i = id; i <= N && cur < R; i++) {
    if (pos + len[i] >= C) {
      cur++;
      puts("");
      if (cur == R) return 0;
      pos = -1;
    }
    if (pos + len[i] >= C) return 0;
    if (pos >= 0) putchar(' ');
    for (int j = sum[i - 1]; j < sum[i]; j++) putchar(s[j]);
    pos += len[i] + 1;
  }
  return 0;
}
