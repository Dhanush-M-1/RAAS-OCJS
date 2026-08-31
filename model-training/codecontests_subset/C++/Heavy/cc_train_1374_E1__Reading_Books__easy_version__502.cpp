#include <bits/stdc++.h>
const int MAXN = 3e5 + 10;
const double eps = 1e-8;
const int inf = 2e9 + 9;
using namespace std;
struct edge {
  int t, v;
  edge *next;
} e[MAXN << 1], *h[MAXN], *o = e;
void add(int x, int y, int vul) {
  o->t = y;
  o->v = vul;
  o->next = h[x];
  h[x] = o++;
}
long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return x * f;
}
pair<int, int> a[4][MAXN];
int cnt[4];
int num[MAXN << 2], sum[MAXN << 2];
void up(int x) {
  num[x] = num[x << 1] + num[x << 1 | 1];
  sum[x] = sum[x << 1] + sum[x << 1 | 1];
}
void update(int x, int l, int r, int t, int y) {
  if (l == r) {
    num[x] += y;
    sum[x] = l * num[x];
    return;
  }
  int mid = (l + r) >> 1;
  if (t <= mid)
    update(x << 1, l, mid, t, y);
  else
    update(x << 1 | 1, mid + 1, r, t, y);
  up(x);
}
int ans;
void query(int x, int l, int r, int k) {
  if (!k) return;
  if (l == r) {
    ans += k * l;
    return;
  }
  int mid = (l + r) >> 1;
  if (num[x << 1] >= k)
    query(x << 1, l, mid, k);
  else
    ans += sum[x << 1], query(x << 1 | 1, mid + 1, r, k - num[x << 1]);
}
int n, m, k;
int sum1[MAXN], sum2[MAXN];
pair<int, int> b[MAXN];
int main() {
  n = read();
  m = read();
  k = read();
  int x, y, z;
  int sz = 1e4;
  for (int i = 1; i <= n; i++) {
    x = read();
    y = read();
    z = read();
    int p = 2 * y + z;
    a[p][++cnt[p]] = make_pair(x, i);
  }
  for (int i = 0; i <= 3; i++) sort(a[i] + 1, a[i] + cnt[i] + 1);
  for (int j = 0; j <= 2; j++)
    for (int i = 1; i <= cnt[j]; i++) update(1, 1, sz, a[j][i].first, 1);
  int pos = cnt[3];
  int minn = inf;
  int p = -1;
  for (int i = 1; i <= min(cnt[1], cnt[2]); i++)
    sum1[i] = sum1[i - 1] + a[1][i].first + a[2][i].first;
  for (int i = 1; i <= cnt[3]; i++) sum2[i] = sum2[i - 1] + a[3][i].first;
  for (int i = 0; i <= min(cnt[1], cnt[2]); i++) {
    if (i > 0) {
      update(1, 1, sz, a[1][i].first, -1);
      update(1, 1, sz, a[2][i].first, -1);
    }
    if (i > k) continue;
    if (cnt[3] < k - i) continue;
    if (2 * i + k - i > m) continue;
    while (pos > k - i) {
      update(1, 1, sz, a[3][pos].first, 1);
      pos--;
    }
    ans = 0;
    query(1, 1, sz, m - k - i);
    if (ans + sum1[i] + sum2[pos] < minn) {
      minn = ans + sum1[i] + sum2[pos];
      p = i;
    }
  }
  if (minn == inf) return 0 * printf("-1\n");
  printf("%d\n", minn);
  for (int i = 1; i <= p; i++) printf("%d %d ", a[1][i].second, a[2][i].second);
  for (int i = 1; i <= k - p; i++) printf("%d ", a[3][i].second);
  int tot = 0;
  for (int i = 1; i <= cnt[0]; i++) b[++tot] = a[0][i];
  for (int i = p + 1; i <= cnt[1]; i++) b[++tot] = a[1][i];
  for (int i = p + 1; i <= cnt[2]; i++) b[++tot] = a[2][i];
  for (int i = k - p + 1; i <= cnt[3]; i++) b[++tot] = a[3][i];
  sort(b + 1, b + tot + 1);
  for (int i = k + p + 1; i <= m; i++) printf("%d ", b[i - k - p].second);
  return 0;
}
