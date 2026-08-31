#include <bits/stdc++.h>
const int A[4][4] = {{0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}};
const int p = 1000000007;
int f[110][55][55][4];
int c[55][55][55];
int num[55][55];
bool a[55][55], b[55][55];
int len[10050], tail[10050], next[10050];
int s[400];
int head[55][4];
int n, m, tot;
void add(int x, int t, int y, int l) {
  tot++;
  tail[tot] = y;
  len[tot] = l;
  next[tot] = head[x][t];
  head[x][t] = tot;
}
void add(int &x, int y) {
  x += y;
  if (x > p) x -= p;
}
void get(int x, int y, int z) {
  int i, l, r, L, R;
  L = 105;
  R = 104;
  for (i = 1; i <= num[x][y]; i++) {
    R++;
    s[R] = c[x][y][i];
    if (i == z) {
      l = R;
      r = R + 1;
    }
  }
  while (l > L) {
    if (R - L > 2 * n) return;
    if (!a[s[l - 1]][s[l]]) return;
    for (i = num[s[l - 1]][s[l]]; i >= 1; i--) {
      L--;
      s[L] = c[s[l - 1]][s[l]][i];
    }
    l--;
  }
  while (r < R) {
    if (R - L > 2 * n) return;
    if (!a[s[r]][s[r + 1]]) return;
    for (i = 1; i <= num[s[r]][s[r + 1]]; i++) {
      R++;
      s[R] = c[s[r]][s[r + 1]][i];
    }
    r++;
  }
  add(s[L], 0, s[R], R - L);
}
void findtail1(int x, int y) {
  int i, l, r, L, R;
  L = 105;
  R = 104;
  for (i = 1; i <= num[x][y]; i++) {
    R++;
    s[R] = c[x][y][i];
  }
  l = R;
  r = R;
  while (l > L) {
    if (R - L > 2 * n) return;
    if (!a[s[l - 1]][s[l]]) return;
    for (i = num[s[l - 1]][s[l]]; i >= 1; i--) {
      L--;
      s[L] = c[s[l - 1]][s[l]][i];
    }
    l--;
  }
  add(s[L], 1, y, R - L + 1);
}
void findtail2(int x, int y) {
  int i, l, r, L, R;
  L = 105;
  R = 104;
  for (i = 1; i <= num[x][y]; i++) {
    R++;
    s[R] = c[x][y][i];
  }
  l = L;
  r = L;
  while (r < R) {
    if (R - L > 2 * n) return;
    if (!a[s[r]][s[r + 1]]) return;
    for (i = 1; i <= num[s[r]][s[r + 1]]; i++) {
      R++;
      s[R] = c[s[r]][s[r + 1]][i];
    }
    r++;
  }
  add(x, 2, s[R], R - L + 1);
}
int main() {
  int i, j, k, l, t0, t1, x, y, z, ans;
  scanf("%d%d", &n, &m);
  memset(b, false, sizeof(b));
  memset(a, false, sizeof(a));
  memset(head, 0, sizeof(head));
  tot = 0;
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d", &x, &y, &z);
    a[x][y] = true;
    num[x][y] = z;
    for (k = 1; k <= z; k++) scanf("%d", &c[x][y][k]);
    for (k = 1; k <= z - 1; k++)
      if ((c[x][y][k] == x) && (c[x][y][k + 1] == y)) {
        b[x][y] = true;
        break;
      }
    if (z == 0) add(x, 3, y, 1);
  }
  for (i = 1; i <= n; i++)
    for (j = 1; j <= n; j++) {
      if (b[i][j])
        for (k = 1; k <= num[i][j] - 1; k++)
          if ((c[i][j][k] == i) && (c[i][j][k + 1] == j)) get(i, j, k);
      if (num[i][j] && (c[i][j][num[i][j]] == i)) findtail1(i, j);
      if (num[i][j] && (c[i][j][1] == j)) findtail2(i, j);
    }
  memset(f, 0, sizeof(f));
  for (i = 1; i <= n; i++)
    for (j = 0; j <= 1; j++) {
      k = head[i][j];
      while (k != 0) {
        f[len[k]][i][tail[k]][j]++;
        k = next[k];
      }
    }
  for (i = 1; i <= 2 * n - 1; i++)
    for (j = 1; j <= n; j++)
      for (k = 1; k <= n; k++)
        for (t0 = 0; t0 <= 3; t0++)
          if (f[i][j][k][t0])
            for (t1 = 0; t1 <= 3; t1++)
              if (A[t0][t1]) {
                l = head[k][t1];
                while (l != 0) {
                  if (i + len[l] <= 2 * n)
                    add(f[i + len[l]][j][tail[l]][t1], f[i][j][k][t0]);
                  l = next[l];
                }
              }
  for (i = 1; i <= 2 * n; i++) {
    ans = 0;
    for (j = 1; j <= n; j++)
      for (k = 1; k <= n; k++) {
        add(ans, f[i][j][k][0]);
        add(ans, f[i][j][k][2]);
      }
    printf("%d\n", ans);
  }
  return 0;
}
