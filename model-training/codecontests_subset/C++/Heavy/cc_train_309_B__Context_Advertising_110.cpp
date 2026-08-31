#include <bits/stdc++.h>
using namespace std;
int fa[1000005][21];
int st[1000005], en[1000005], Last[1000005];
char str[10 * 1000005];
int get(int L, int R, int len) {
  int res = L;
  while (L <= R) {
    int mid = (L + R) >> 1;
    if (en[mid] <= len) {
      res = mid;
      L = mid + 1;
    } else
      R = mid - 1;
  }
  return res;
}
void solve(int v, int step, int &res) {
  int i;
  res = v;
  for (i = 21 - 1; i >= 0; i--)
    if (step >= (1 << i)) {
      if (fa[v][i] != -1) {
        res = fa[v][i];
        v = fa[v][i];
        step -= 1 << i;
      }
    }
}
int main() {
  int n, R, C, i, j, k;
  while (scanf("%d %d %d", &n, &R, &C) != EOF) {
    gets(str);
    gets(str);
    int len = strlen(str);
    k = 1;
    for (i = 0; i < len; i++) {
      st[k] = i;
      j = i;
      while (j < len && str[j] != ' ') j++;
      en[k++] = j - 1;
      i = j;
    }
    memset(fa, -1, sizeof(fa));
    for (i = 1; i <= n; i++) {
      if (en[i] - st[i] + 1 <= C) {
        fa[i][0] = get(i, n, st[i] + C - 1) + 1;
      } else
        fa[i][0] = -1;
    }
    for (i = n; i >= 1; i--) {
      if (fa[i][0] == -1) continue;
      for (j = 1; j < 21; j++) {
        fa[i][j] = fa[fa[i][j - 1]][j - 1];
        if (fa[i][j] == -1) break;
      }
    }
    int ans = 0, x = 0;
    for (i = 1; i <= n; i++) {
      if (fa[i][0] == -1) continue;
      solve(i, R, Last[i]);
      if (Last[i] - i > ans) {
        ans = Last[i] - i;
        x = i;
      }
    }
    for (i = 0; i < R; i++) {
      if (x != -1 && fa[x][0] != -1) {
        for (j = st[x]; j <= en[fa[x][0] - 1]; j++) printf("%c", str[j]);
      }
      puts("");
      x = fa[x][0];
      if (x == -1) break;
    }
  }
  return 0;
}
