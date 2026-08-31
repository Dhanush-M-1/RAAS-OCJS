#include <bits/stdc++.h>
using namespace std;
int a[200010], p[200010], n, s;
pair<int, int> b[200010];
int fa[200010], r[200010];
int get_fa(int x) {
  if (fa[x] == 0) return x;
  fa[x] = get_fa(fa[x]);
  return fa[x];
}
void merge(int x, int y) {
  int fx = get_fa(x);
  int fy = get_fa(y);
  if (fx != fy) fa[fx] = fy;
}
bool check(int x, int y) { return get_fa(x) == get_fa(y); }
int now;
bool used[200010];
vector<int> ans[200010];
void dfs(int x) {
  used[x] = 1;
  ans[now].push_back(x);
  if (used[p[x]] == 0) dfs(p[x]);
}
int main() {
  scanf("%d%d", &n, &s);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    b[i] = make_pair(a[i], i);
  }
  sort(b + 1, b + 1 + n);
  for (int i = 1; i <= n; i++) p[b[i].second] = i;
  for (int i = 1; i <= n; i++)
    if (a[i] == b[i].first && p[i] != i) {
      p[b[i].second] = p[i];
      b[p[i]].second = b[i].second;
      p[i] = i;
      b[i].second = i;
    }
  for (int i = 1; i <= n; i++)
    if (p[i] != i) merge(p[i], i);
  int las = 0;
  for (int i = 1; i <= n; i++) {
    if (p[b[i].second] == b[i].second) continue;
    if (las >= 1 && a[las] == a[b[i].second]) {
      int x = las;
      int y = b[i].second;
      if (check(x, y)) continue;
      merge(x, y);
      swap(p[x], p[y]);
    }
    las = b[i].second;
  }
  now = 0;
  for (int i = 1; i <= n; i++)
    if (used[i] == 0 && p[i] != i) {
      now++;
      dfs(i);
    }
  int sum = 0;
  for (int i = 1; i <= now; i++) sum += ans[i].size();
  if (sum > s) {
    printf("-1");
    return 0;
  }
  s -= sum;
  s = min(s, now);
  if (s <= 1) {
    printf("%d\n", now);
    for (int i = 1; i <= now; i++) {
      printf("%d\n", ans[i].size());
      for (int j = 0; j < ans[i].size(); j++) printf("%d ", ans[i][j]);
      puts("");
    }
    return 0;
  }
  printf("%d\n", now - s + 2);
  for (int i = 1; i <= now - s; i++) {
    printf("%d\n", ans[i + s].size());
    for (int j = 0; j < ans[i + s].size(); j++) printf("%d ", ans[i + s][j]);
    puts("");
    sum -= ans[i + s].size();
  }
  printf("%d\n", sum);
  for (int i = 1; i <= s; i++)
    for (int j = 0; j < ans[i].size(); j++) printf("%d ", ans[i][j]);
  printf("\n%d\n", s);
  for (int i = s; i > 0; i--) printf("%d ", ans[i][0]);
}
