#include <bits/stdc++.h>
using namespace std;
const int next_x[8] = {0, 1, -1, 0, 1, 1, -1, -1};
const int next_y[8] = {1, 0, 0, -1, 1, -1, -1, 1};
const int inf = 2147483647;
const long long linf = 1e15;
int read() {
  int t = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    t = t * 10 + ch - '0';
    ch = getchar();
  }
  return t * f;
}
extern const int MAXN = 200005;
extern const int N = 500000;
bool cmp(long long a, long long b) { return a > b; }
int n, m, k;
long long a[MAXN][4], f[MAXN][10];
long long b[MAXN][4];
int work() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    vector<long long> t[4];
    int k;
    long long c, d;
    scanf("%d", &k);
    for (int j = 1; j <= k; j++) scanf("%lld%lld", &c, &d), t[c].push_back(d);
    for (int j = 1; j <= 3; j++)
      if (!t[j].empty()) sort(t[j].begin(), t[j].end(), cmp);
    a[i][0] = 0;
    a[i][1] = -1;
    for (int j = 1; j <= 3; j++)
      if (!t[j].empty()) a[i][1] = max(a[i][1], t[j].front());
    a[i][2] = -1;
    if (t[1].size() >= 2) a[i][2] = max(a[i][2], t[1][0] + t[1][1]);
    if (t[1].size() >= 1 && t[2].size() >= 1)
      a[i][2] = max(a[i][2], t[1][0] + t[2][0]);
    a[i][3] = -1;
    if (t[1].size() >= 3) a[i][3] = t[1][0] + t[1][1] + t[1][2];
    b[i][1] = -1;
    for (int j = 1; j <= 3; j++)
      if (!t[j].empty()) b[i][1] = max(b[i][1], t[j].front() * 2);
    b[i][2] = -1;
    if (t[1].size() >= 2) b[i][2] = max(b[i][2], t[1][0] * 2 + t[1][1]);
    if (t[1].size() >= 1 && t[2].size() >= 1)
      b[i][2] = max(b[i][2], max(t[1][0], t[2][0]) * 2 + min(t[1][0], t[2][0]));
    b[i][3] = -1;
    if (t[1].size() >= 3) b[i][3] = t[1][0] * 2 + t[1][1] + t[1][2];
  }
  memset(f, -1, sizeof(f)), f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 3; j < 10; j++) {
      for (int k = 0; k <= 3; k++) {
        int pre = (j - k + 10) % 10;
        if (f[i - 1][pre] == -1 || a[i][k] == -1) continue;
        f[i][j] = max(f[i][j], f[i - 1][pre] + a[i][k]);
      }
    }
    for (int j = 0; j < 3; j++) {
      for (int k = 0; k <= j; k++) {
        int pre = (j - k + 10) % 10;
        if (f[i - 1][pre] == -1 || a[i][k] == -1) continue;
        f[i][j] = max(f[i][j], f[i - 1][pre] + a[i][k]);
      }
      for (int k = j + 1; k <= 3; k++) {
        int pre = (j - k + 10) % 10;
        if (f[i - 1][pre] == -1 || b[i][k] == -1) continue;
        f[i][j] = max(f[i][j], f[i - 1][pre] + b[i][k]);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) ans = max(ans, f[n][i]);
  return printf("%lld\n", ans);
}
int main() {
  ios::sync_with_stdio(false);
  work();
  return 0;
}
