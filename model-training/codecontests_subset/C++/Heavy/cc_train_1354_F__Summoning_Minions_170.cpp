#include <bits/stdc++.h>
using namespace std;
template <typename T>
T &read(T &x) {
  x = 0;
  bool f = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') {
      f = 1;
    }
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 1) + (x << 3) + (ch ^ 48);
    ch = getchar();
  }
  if (f) {
    x = -x;
  }
  return x;
}
const double eps = 1e-8;
inline int sgn(double x) {
  if (x < -eps) {
    return -1;
  }
  return x > eps;
}
void fp() {
  freopen(".in", "r", stdin);
  freopen(".out", "w", stdout);
}
struct pai {
  int a, b, num;
} c[80];
inline bool cmp(pai a, pai b) { return a.b < b.b; }
int f[80][80], g[80][80], ans1[155], ans2[155];
int main() {
  int t = read(t);
  while (t--) {
    int n = read(n), k = read(k), i, j;
    for (i = 1; i <= n; i++) {
      read(c[i].a);
      read(c[i].b);
      c[i].num = i;
    }
    sort(c + 1, c + n + 1, cmp);
    for (i = 1; i <= n; i++) {
      for (j = 0; j <= min(k, i); j++) {
        if (j == i) {
          f[i][j] = f[i - 1][j - 1] + c[i].a + c[i].b * (j - 1);
          g[i][j] = 2;
          continue;
        }
        if (!j) {
          f[i][j] = f[i - 1][j] + c[i].b * (k - 1);
          g[i][j] = 1;
          continue;
        }
        if (f[i - 1][j - 1] + c[i].a + c[i].b * (j - 1) <
            f[i - 1][j] + c[i].b * (k - 1)) {
          f[i][j] = f[i - 1][j] + c[i].b * (k - 1);
          g[i][j] = 1;
        } else {
          f[i][j] = f[i - 1][j - 1] + c[i].a + c[i].b * (j - 1);
          g[i][j] = 2;
        }
      }
    }
    printf("%d\n", 2 * n - k);
    int nowx = n, nowy = k, cnt1 = 0, cnt2 = 0;
    for (i = 1; i <= n; i++) {
      if (g[nowx][nowy] == 1) {
        ans1[++cnt1] = -c[nowx].num;
        ans1[++cnt1] = c[nowx].num;
        nowx--;
      } else {
        nowx--;
        nowy--;
      }
    }
    nowx = n;
    nowy = k;
    for (i = 1; i <= n; i++) {
      if (g[nowx][nowy] == 1) {
        nowx--;
      } else {
        ans2[++cnt2] = c[nowx].num;
        nowx--;
        nowy--;
      }
    }
    for (i = cnt2; i >= 2; i--) {
      printf("%d ", ans2[i]);
    }
    for (i = cnt1; i; i--) {
      printf("%d ", ans1[i]);
    }
    printf("%d ", ans2[1]);
    puts("");
  }
  return 0;
}
