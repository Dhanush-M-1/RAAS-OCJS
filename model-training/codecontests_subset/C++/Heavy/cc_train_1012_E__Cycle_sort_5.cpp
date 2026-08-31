#include <bits/stdc++.h>
using namespace std;
int n, s, a[200005], b[200005], c[200005], vis[200005], wa, cir, prn[200005],
    to[200005], nex[200005], beg[200005], val[200005], e;
bool acs[200005];
void insert(int x, int y, int z) {
  to[++e] = y;
  nex[e] = beg[x];
  beg[x] = e;
  val[e] = z;
}
vector<int> tek[200005];
void dfs(int now) {
  vis[now] = cir;
  for (int &i = beg[now]; i; i = nex[i]) {
    if (!acs[i]) {
      int tmp = i;
      acs[i] = true;
      dfs(to[i]);
      tek[cir].push_back(val[tmp]);
    }
  }
}
int main() {
  scanf("%d %d", &n, &s);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]), b[i] = a[i];
  sort(b + 1, b + 1 + n);
  int len = unique(b + 1, b + 1 + n) - b - 1;
  for (int i = 1; i <= n; ++i)
    c[i] = a[i] = lower_bound(b + 1, b + 1 + len, a[i]) - b;
  sort(c + 1, c + 1 + n);
  for (int i = 1; i <= n; ++i)
    if (c[i] != a[i]) ++wa, insert(a[i], c[i], i);
  if (wa > s) return puts("-1") & 0;
  for (int i = 1; i <= n; ++i)
    if (!vis[i] && beg[i]) ++cir, dfs(i);
  if (cir <= 1 || s - wa <= 1) {
    printf("%d\n", cir);
    for (int i = 1; i <= cir; ++i) {
      printf("%d\n", int(tek[i].size()));
      for (unsigned int j = 0; j < tek[i].size(); ++j) printf("%d ", tek[i][j]);
      puts("");
    }
  } else {
    printf("%d\n", cir - min(cir, s - wa) + 2);
    for (int i = s - wa + 1; i <= cir; ++i) {
      printf("%d\n", int(tek[i].size()));
      for (unsigned int j = 0; j < tek[i].size(); ++j) printf("%d ", tek[i][j]);
      puts("");
    }
    if (s != wa) {
      int p1 = 0, p2 = 0;
      for (int i = min(s - wa, cir); i; --i)
        p1 += int(tek[i].size()), prn[++p2] = tek[i][0];
      printf("%d\n", p1);
      for (int i = 1; i <= min(s - wa, cir); ++i)
        for (unsigned int j = 0; j < tek[i].size(); ++j)
          printf("%d ", tek[i][j]);
      puts("");
      printf("%d\n", p2);
      for (int i = 1; i <= p2; ++i) printf("%d ", prn[i]);
    }
  }
  return 0;
}
