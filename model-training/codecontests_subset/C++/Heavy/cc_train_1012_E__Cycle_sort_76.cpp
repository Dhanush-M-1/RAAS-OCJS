#include <bits/stdc++.h>
int n, s, a[200010], b[200010], nums[200010], cnt, fa[200010];
int find(int i) { return fa[i] == i ? i : fa[i] = find(fa[i]); }
bool tag[200010];
struct edge {
  int to;
  edge* next;
} E[200010], *fir[200010];
std::vector<int> C[200010];
void dfs(int i, int t) {
  while (fir[i]) {
    edge* e = fir[i];
    fir[i] = e->next;
    dfs(e->to, t);
    C[t].push_back(e - E);
  }
}
void mf() {
  for (int i = 0; i < n; i++) fa[i] = i, tag[i] = 0;
  for (int i = 0; i < n; i++)
    if (find(a[i]) != find(b[i]))
      fa[find(a[i])] = find(b[i]), tag[find(b[i])] = 1;
}
void me() {
  for (int i = 0; i < n; i++) fir[i] = 0;
  for (int i = 0; i < n; i++)
    if (a[i] != b[i]) {
      E[i] = (edge){b[i], fir[a[i]]};
      fir[a[i]] = E + i;
    }
}
int rs[200010];
void cyc(int c) {
  if (c < 2) return;
  int v = a[rs[c - 1]];
  for (int i = c; --i;) a[rs[i]] = a[rs[i - 1]];
  a[rs[0]] = v;
}
int main() {
  scanf("%d%d", &n, &s);
  for (int i = 0; i < n; i++)
    scanf("%d", a + i), b[i] = a[i], nums[cnt++] = a[i];
  std::sort(b, b + n);
  std::sort(nums, nums + cnt);
  cnt = std::unique(nums, nums + cnt) - nums;
  for (int i = 0; i < n; i++) {
    a[i] = std::lower_bound(nums, nums + cnt, a[i]) - nums;
    b[i] = std::lower_bound(nums, nums + cnt, b[i]) - nums;
  }
  int t = 0;
  for (int i = 0; i < n; i++)
    if (a[i] != b[i]) t++;
  if (t > s) return puts("-1"), 0;
  mf();
  me();
  int tot = 0;
  for (int i = 0; i < n; i++)
    if (fa[i] == i && tag[i]) rs[tot++] = fir[i] - E;
  if (t + tot > s) tot = s - t;
  cyc(tot);
  mf();
  me();
  for (int i = t = 0; i < n; i++)
    if (fa[i] == i && tag[i]) dfs(i, t++);
  printf("%d\n", t + (tot > 1));
  if (tot > 1) {
    printf("%d\n", tot);
    for (int i = 0; i < tot; i++)
      printf("%d%c", rs[i] + 1, " \n"[i == tot - 1]);
  }
  for (int i = 0; i < t; i++) {
    printf("%d\n", C[i].size());
    for (int j = 0; j < C[i].size(); j++)
      printf("%d%c", C[i][j] + 1, " \n"[j == C[i].size() - 1]);
  }
}
