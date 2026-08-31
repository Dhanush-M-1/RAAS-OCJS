#include <bits/stdc++.h>
using namespace std;
const int MAXN = 4e5 + 5;
int last[MAXN + 5], Check[MAXN + 5];
int other[MAXN + 5], pre[MAXN + 5];
int num[MAXN + 5];
int rlast[MAXN + 5], rpre[MAXN + 5];
int rother[MAXN + 5];
int P[MAXN + 5];
queue<int> seq;
int all = -1, rall = -1;
int n;
void build(int u, int v) {
  pre[++all] = last[u];
  last[u] = all;
  other[all] = v;
}
void rbuild(int u, int v) {
  rpre[++rall] = rlast[u];
  rlast[u] = rall;
  rother[rall] = v;
}
int dfs(int ans, int fa) {
  int sum = 0, t = 0;
  int dt = last[ans];
  while (dt != -1) {
    int dr = other[dt];
    if (dr != fa) {
      int c = dfs(dr, ans);
      if (dr != 0 && ans != 0) {
        if (c & 1)
          rbuild(dr, ans), num[ans]++;
        else
          rbuild(ans, dr), num[dr]++;
      }
      sum += c, t++;
    }
    dt = pre[dt];
  }
  if ((t - sum) & 1) return 1;
  return 0;
}
void solve() {
  int tot = 0;
  for (int i = 1; i <= n; i++)
    if (num[i] == 0 && Check[i] % 2 == 0) P[++tot] = i, seq.push(i);
  while (seq.size()) {
    int ans = seq.front();
    int dt = last[ans];
    while (dt != -1) {
      int dr = other[dt];
      Check[dr]--;
      dt = pre[dt];
    }
    int rdt = rlast[ans];
    while (rdt != -1) {
      int rdr = rother[rdt];
      if (--num[rdr] == 0 && Check[rdr] % 2 == 0) seq.push(rdr), P[++tot] = rdr;
      rdt = rpre[rdt];
    }
    seq.pop();
  }
  if (tot != n)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= tot; i++) printf("%d\n", P[i]);
  }
}
int main() {
  scanf("%d", &n);
  memset(last, -1, sizeof(last));
  memset(rlast, -1, sizeof(rlast));
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    build(x, i), build(i, x);
    if (x != 0) Check[x]++, Check[i]++;
  }
  dfs(0, -1);
  solve();
}
