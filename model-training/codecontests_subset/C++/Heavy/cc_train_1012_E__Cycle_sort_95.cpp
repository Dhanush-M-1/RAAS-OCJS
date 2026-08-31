#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long x = 0, F = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') F = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0';
    c = getchar();
  }
  return x * F;
}
int n, cnt, s, F, tmp;
int a[500000 + 5], b[500000 + 5], val[500000 + 5];
int head[500000 + 5], ecnt;
struct edge {
  int to, nxt, vis;
} e[500000 + 5];
vector<int> P[500000 + 5];
void link(int u, int v) { e[++ecnt] = (edge){v, head[u]}, head[u] = ecnt; }
void dfs(int x) {
  for (int &i = head[x]; i;) {
    int v = e[i].to;
    i = e[i].nxt;
    dfs(a[v]);
    P[cnt].push_back(v);
  }
}
void Print(int id) {
  printf("%d\n", P[id].size());
  for (int i = P[id].size() - 1; i >= 0; i--) printf("%d ", P[id][i]);
  puts("");
}
int main() {
  n = read(), s = read();
  for (int i = 1; i <= n; i++) val[i] = a[i] = read();
  sort(val + 1, val + n + 1);
  int pn = unique(val + 1, val + n + 1) - val - 1;
  for (int i = 1; i <= n; i++)
    b[i] = a[i] = lower_bound(val + 1, val + pn + 1, a[i]) - val;
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; i++)
    if (b[i] != a[i]) link(b[i], i), s--, F = 1;
  if (!F) {
    puts("0");
    return 0;
  } else if (s < 0) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= pn; i++)
    if (head[i]) cnt++, dfs(i);
  if (cnt == 1) {
    puts("1");
    Print(1);
    return 0;
  }
  s = min(s, cnt);
  if (s > 1)
    printf("%d\n", cnt - s + 2);
  else
    printf("%d\n", cnt);
  for (int i = cnt; i > s; i--) Print(i);
  if (s) {
    int tot = 0;
    for (int i = 1; i <= s; i++) tot += P[i].size();
    printf("%d\n", tot);
    for (int i = s; i >= 1; i--)
      for (int j = P[i].size() - 1; j >= 0; j--) printf("%d ", P[i][j]);
    puts("");
    if (s > 1) {
      printf("%d\n", s);
      for (int i = 1; i <= s; i++) printf("%d ", P[i][P[i].size() - 1]);
    }
  }
}
