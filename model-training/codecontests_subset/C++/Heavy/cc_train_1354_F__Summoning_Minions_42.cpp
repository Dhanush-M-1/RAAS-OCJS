#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T &n) {
  n = 0;
  T f = 1;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-') f = -1, c = getchar();
  while (isdigit(c)) n = n * 10 + c - '0', c = getchar();
  n *= f;
}
template <typename T>
void write(T n) {
  if (n < 0) putchar('-'), n = -n;
  if (n > 9) write(n / 10);
  putchar(n % 10 + '0');
}
int n, m, vis[105];
long long f[105][105], p[105][105];
struct node {
  long long a, b;
  int id;
  friend bool operator<(node a, node b) { return a.b < b.b; }
} v[105];
int main() {
  int T;
  cin >> T;
  while (T--) {
    read(n), read(m);
    for (int i = 1; i <= n; i++) {
      read(v[i].a), read(v[i].b);
      v[i].id = i;
    }
    sort(v + 1, v + n + 1);
    memset(f, -0x3f, sizeof(f));
    memset(p, 0, sizeof(p));
    memset(vis, 0, sizeof(vis));
    f[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= min(i, m); j++) {
        f[i][j] = f[i - 1][j] + v[i].b * (m - 1);
        if (j && f[i - 1][j - 1] + v[i].a + v[i].b * (j - 1) > f[i][j]) {
          f[i][j] = f[i - 1][j - 1] + v[i].a + v[i].b * (j - 1);
          p[i][j] = 1;
        }
      }
    }
    int t = m;
    for (int i = n; i >= 1; i--) {
      if (p[i][t]) {
        vis[i] = 1;
        t--;
      }
    }
    printf("%d\n", m + (n - m) * 2);
    int cnt = 0, x;
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) continue;
      cnt++;
      if (cnt == m)
        x = v[i].id;
      else
        printf("%d ", v[i].id);
    }
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) printf("%d %d ", v[i].id, -v[i].id);
    }
    printf("%d\n", x);
  }
  return 0;
}
