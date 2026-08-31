#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1000 + 86;
int f[MAXN];
int e[MAXN];
int n, x;
int p = -1;
int tot;
vector<int> head;
vector<int> c;
vector<int> out;
void dfs(int r, int d) {
  if (r == x) p = d;
  ++tot;
  if (e[r] != -1) dfs(e[r], d + 1);
}
int main() {
  scanf("%d%d", &n, &x);
  memset(e, -1, sizeof(e));
  for (int i = 1, j; i <= n; ++i) {
    scanf("%d", &j);
    if (j == 0)
      head.push_back(i);
    else
      e[j] = i;
  }
  int m = head.size(), cc = 0;
  for (int i = 0; i < m; ++i) {
    tot = 0;
    dfs(head[i], 1);
    if (p != -1)
      cc = p, p = -1;
    else
      c.push_back(tot);
  }
  sort(c.begin(), c.end());
  f[0] = 1;
  for (int i = 0; i < c.size(); ++i) {
    for (int k = MAXN - 1; k >= 0; --k)
      if (f[k]) {
        f[k + c[i]] = 1;
      }
  }
  for (int i = 0; i < MAXN; ++i)
    if (f[i]) out.push_back(i + cc);
  sort(out.begin(), out.end());
  for (int i = 0; i < out.size(); ++i) printf("%d\n", out[i]);
  return 0;
}
