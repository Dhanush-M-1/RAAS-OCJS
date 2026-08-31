#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') f = -1;
  for (; isdigit(ch); ch = getchar()) x = (x << 3) + (x << 1) + ch - '0';
  return (f == 1) ? x : -x;
}
const int maxn = 200005;
const int inf = 0x3f3f3f3f;
int n, a[maxn], cnt[maxn], sum[maxn], mn[maxn << 1], pre[maxn], suf[maxn],
    val[maxn], id[maxn], tot;
vector<int> v[maxn];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++)
    scanf("%d", &a[i]), cnt[a[i]]++, v[a[i]].push_back(i);
  int mx = 0, se = 0, D = 0;
  for (int i = 1; i <= n; i++)
    if (cnt[i] > mx)
      mx = cnt[i], se = 1, D = i;
    else if (cnt[i] == mx)
      se++;
  if (se >= 2) return printf("%d\n", n), 0;
  sum[0] = pre[0] = 0;
  for (int i = 1; i <= n; i++)
    sum[i] = sum[i - 1] + (a[i] == D),
    pre[i] = a[i - 1] == D ? i - 1 : pre[i - 1];
  suf[n + 1] = n + 1;
  for (int i = n; i > 0; i--) suf[i] = a[i + 1] == D ? i + 1 : suf[i + 1];
  for (int j = 0; j <= 2 * n; j++) mn[j] = inf;
  int ans = 0;
  for (int i = 1; i <= n; i++)
    if (i != D && cnt[i] > 100) {
      int now = 0;
      mn[n] = 0;
      for (int j = 1; j <= n; j++) {
        now += a[j] == D ? 1 : a[j] == i ? -1 : 0;
        ans = max(ans, j - mn[now + n]);
        mn[now + n] = min(mn[now + n], j);
      }
      for (int j = 0; j <= 2 * n; j++) mn[j] = inf;
    } else if (i != D && cnt[i] <= 100) {
      int sz = (int)v[i].size();
      for (int l = 0, r = 0; l < sz; l = r + 1) {
        int k = pre[v[i][l]];
        for (int j = 0; j <= cnt[i] && k > (!l ? 0 : v[i][l - 1]);
             j++, k = pre[k])
          val[++tot] = -1, id[tot] = k;
        if (k <= (!l ? 0 : v[i][l - 1]))
          val[++tot] = 0, id[tot] = (!l ? 0 : v[i][l - 1]);
        reverse(val + 1, val + tot + 1), reverse(id + 1, id + tot + 1);
        val[++tot] = 1, id[tot] = v[i][l];
        for (r = l; r < sz - 1 && sum[v[i][r + 1]] - sum[v[i][r]] <= cnt[i];
             r++) {
          int k = suf[v[i][r]];
          for (; k < v[i][r + 1]; k = suf[k]) val[++tot] = -1, id[tot] = k;
          val[++tot] = 1, id[tot] = v[i][r + 1];
        }
        k = suf[v[i][r]];
        for (int j = 0; j <= cnt[i] && k < (r == sz - 1 ? n + 1 : v[i][r + 1]);
             j++, k = suf[k])
          val[++tot] = -1, id[tot] = k;
        if (k >= (r == sz - 1 ? n + 1 : v[i][r + 1]))
          val[++tot] = 0, id[tot] = (r == sz - 1 ? n + 1 : v[i][r + 1]);
        int now = 0;
        for (int j = 1; j < tot; j++) {
          now += val[j];
          ans = max(ans, id[j + 1] - 1 - mn[now + n]);
          mn[now + n] = min(mn[now + n], id[j]);
        }
        now = 0, mn[n] = inf;
        for (int j = 1; j < tot; j++) now += val[j], mn[now + n] = inf;
        tot = 0;
      }
    }
  printf("%d\n", ans);
  return 0;
}
