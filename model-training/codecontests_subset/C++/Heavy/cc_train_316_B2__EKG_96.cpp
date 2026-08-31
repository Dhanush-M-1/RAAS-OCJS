#include <bits/stdc++.h>
using namespace std;
const int maxn = 1003;
int to[maxn], from[maxn];
int a[maxn];
struct node {
  int h, size;
} p[maxn];
int f;
int tot;
int dp[maxn];
int main() {
  int i, j;
  int n, x;
  bool flag = 0;
  scanf("%d%d", &n, &x);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i]) {
      flag = 1;
      from[i] = a[i];
      to[a[i]] = i;
    }
  }
  if (!flag) {
    for (i = 1; i <= n; i++) printf("%d\n", i);
    return 0;
  }
  int cnt = 0;
  for (i = 1; i <= n; i++) {
    if (!from[i]) {
      p[++tot].h = i;
      int c = 1;
      j = i;
      if (j == x) {
        cnt = 1;
        f = tot;
      }
      bool g = 0;
      while (to[j]) {
        j = to[j];
        if (j == x) {
          g = 1;
        }
        c++;
      }
      p[tot].size = c;
      if (g) {
        f = tot;
        j = i;
        c = 1;
        while (to[j]) {
          j = to[j];
          if (j == x) cnt = c + 1;
          c++;
        }
      }
    }
  }
  memset(dp, 0, sizeof(dp));
  dp[0] = 1;
  for (i = 1; i <= tot; i++)
    if (i != f) {
      int size = p[i].size;
      for (j = n; j >= size; j--)
        if (dp[j - size]) dp[j] = 1;
    }
  vector<int> ans;
  for (i = 0; i <= n; i++)
    if (dp[i]) ans.push_back(i + cnt);
  sort(ans.begin(), ans.end());
  for (i = 0; i < ans.size(); i++) printf("%d\n", ans[i]);
  return 0;
}
