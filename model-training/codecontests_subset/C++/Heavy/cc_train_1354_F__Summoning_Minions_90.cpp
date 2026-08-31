#include <bits/stdc++.h>
using namespace std;
const int N = 0, M = 0;
int read() {
  char c;
  int num, f = 1;
  while (c = getchar(), !isdigit(c))
    if (c == '-') f = -1;
  num = c - '0';
  while (c = getchar(), isdigit(c)) num = num * 10 + c - '0';
  return num * f;
}
struct node {
  int a, b, id;
} p[109];
int n, k, f[109][109], ans[109][109], vis[109];
bool cmp(node x, node y) { return x.b < y.b; }
void work() {
  n = read();
  k = read();
  for (int i = 1; i <= n; i++) {
    p[i].a = read();
    p[i].b = read();
    p[i].id = i;
  }
  sort(p + 1, p + 1 + n, cmp);
  memset(f, 0x3f3f, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= i && j <= k; j++) {
      if (f[i - 1][j] < f[i][j]) {
        ans[i][j] = 0;
        f[i][j] = f[i - 1][j];
      }
      if (j && f[i - 1][j - 1] + (k - j) * p[i].b - p[i].a < f[i][j]) {
        ans[i][j] = 1;
        f[i][j] = f[i - 1][j - 1] + (k - j) * p[i].b - p[i].a;
      }
    }
  }
  printf("%d\n", k + 2 * (n - k));
  int sum = k;
  for (int i = n; i; i--) {
    vis[i] = ans[i][sum];
    sum -= ans[i][sum];
  }
  for (int i = 1, now = 1; i < k; i++) {
    while (!vis[now]) now++;
    printf("%d ", p[now++].id);
  }
  for (int i = 1; i <= n; i++)
    if (!vis[i]) printf("%d %d ", p[i].id, -p[i].id);
  for (int i = n; i; i--)
    if (vis[i]) {
      printf("%d\n", p[i].id);
      break;
    }
}
int main() {
  int Case = read();
  while (Case--) work();
  return 0;
}
