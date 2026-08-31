#include <bits/stdc++.h>
using namespace std;
void read(int& x) {
  bool fu = 0;
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  if (c == '-') fu = 1, c = getchar();
  for (x = 0; c > 32; c = getchar()) x = x * 10 + c - '0';
  if (fu) x = -x;
};
char getc() {
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  return c;
}
int T, i, j, k, l, p, w;
char a[20];
long long ans[10], ten[20];
bool v[20][20];
bool dfs(int i, int j) {
  if (j >= 5) return 0;
  if (i == w + 1) return j == 0;
  if (v[i][j]) return 0;
  v[i][j] = 1;
  int t, s0, s1, last = j * 10 + a[i] - '0';
  for (s0 = 0; s0 <= 6; s0++)
    for (s1 = 0; s1 <= 6 - s0; s1++)
      if (s0 * 4 + s1 * 7 <= last)
        if (dfs(i + 1, last - (s0 * 4 + s1 * 7))) {
          for (t = 1; t <= s0; t++) ans[t] += ten[w - i] * 4;
          for (t = 1; t <= s1; t++) ans[t + s0] += ten[w - i] * 7;
          return 1;
        }
  return 0;
}
int main() {
  for (read(T); T; T--) {
    scanf("%s", a + 1);
    w = strlen(a + 1);
    memset(ans, 0, sizeof(ans));
    memset(v, 0, sizeof(v));
    ten[0] = 1;
    for (i = 1; i <= w; i++) ten[i] = ten[i - 1] * 10;
    if (dfs(1, 0)) {
      for (i = 1; i <= 6; i++) printf("%I64d%s", ans[i], i == 6 ? "\n" : " ");
    } else
      printf("-1\n");
  }
  scanf("\n");
  return 0;
}
