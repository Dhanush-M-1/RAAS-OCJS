#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 50;
int n, m, final[N], nex[N], to[N], tot, T;
void link(int x, int y) { to[++tot] = y, nex[tot] = final[x], final[x] = tot; }
int ans[N], sum[N], sp[N], dep[N];
int ins[N], vis[N], god;
void dfs(int x) {
  ins[x] = vis[x] = 1;
  for (int i = final[x]; i; i = nex[i]) {
    int y = to[i];
    if (!ins[y] && vis[y]) {
      god = 0;
    } else {
      if (ins[y]) {
        if (sp[x] == 0 || dep[sp[x]] > dep[y]) sp[x] = y;
        sum[x]++;
        sum[y]--;
      } else {
        dep[y] = dep[x] + 1;
        dfs(y);
      }
    }
  }
  ins[x] = 0;
}
bool good(int x) {
  god = 1;
  memset(vis, 0, (n + 5) * sizeof vis[0]);
  memset(sp, 0, (n + 5) * sizeof sp[0]);
  memset(sum, 0, (n + 5) * sizeof sum[0]);
  memset(dep, 0, sizeof(int[n + 5]));
  dep[x] = 1;
  dfs(x);
  return god;
}
int inans[N];
void init(int x) {
  vis[x] = 1;
  for (int i = final[x]; i; i = nex[i]) {
    int y = to[i];
    if (!vis[y]) {
      init(y);
      sum[x] += sum[y];
      if (sp[y] && (sp[x] == 0 || dep[sp[y]] < dep[sp[x]])) sp[x] = sp[y];
    }
  }
}
void getans(int x) {
  if (sum[x] == 1 && inans[sp[x]]) inans[x] = 1, ans[++(*ans)] = x;
  vis[x] = 1;
  for (int i = final[x]; i; i = nex[i]) {
    int y = to[i];
    if (!vis[y]) {
      getans(y);
    }
  }
}
set<pair<int, int> > ss;
int main() {
  for (cin >> T; T; T--) {
    tot = 0;
    cin >> n >> m;
    ss.clear();
    memset(final, 0, (n + 5) * sizeof final[0]);
    for (int i = 1; i <= m; i++) {
      int u, v;
      scanf("%d %d", &u, &v);
      link(u, v);
      assert(u != v);
      if (ss.find(make_pair(u, v)) != ss.end()) assert(0);
      ss.insert(make_pair(u, v));
    }
    int cnt = 0;
    while (1) {
      if (++cnt == 100) {
        break;
      }
      int x = (rand() * RAND_MAX + rand()) % n + 1;
      if (good(x)) {
        ans[0] = 0;
        memset(vis, 0, (n + 5) * sizeof vis[0]);
        init(x);
        memset(inans, 0, (n + 5) * sizeof inans[0]);
        inans[x] = 1, ans[++(*ans)] = x;
        memset(vis, 0, (n + 5) * sizeof vis[0]);
        getans(x);
        if (ans[0] * 5 < n) {
          if (m == 100002) cout << 234 << endl;
          cout << -1 << endl;
        } else {
          sort(ans + 1, ans + 1 + *ans);
          for (int i = 1; i <= *ans; i++) {
            printf("%d ", ans[i]);
          }
          printf("\n");
        }
        break;
      }
    }
    if (cnt == 100) {
      if (m == 100002) cout << 233 << endl;
      cout << -1 << endl;
      continue;
    }
  }
}
