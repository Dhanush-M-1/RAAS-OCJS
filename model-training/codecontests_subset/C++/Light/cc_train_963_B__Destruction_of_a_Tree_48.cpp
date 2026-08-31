#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const int maxm = 1e6 + 10;
const int INF = 0x3f3f3f3f;
int casn, n, m, k;
int st, pre[maxn], deg[maxn];
int to[maxn], nex[maxn], head[maxn], nume;
int dfn[maxn], cnt, ans1[maxn], ans2[maxn], cnt2;
void dfs(int now) {
  for (int i = head[now]; i; i = nex[i]) {
    if (to[i] != now) dfs(to[i]);
  }
  dfn[++cnt] = now;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> pre[i];
    deg[pre[i]]++;
    if (pre[i]) {
      deg[i]++;
      to[++nume] = i;
      nex[nume] = head[pre[i]];
      head[pre[i]] = nume;
    } else
      st = i;
  }
  dfs(st);
  cnt = 0;
  for (int i = 1; i < n; i++) {
    if (deg[dfn[i]] & 1) {
      ans2[++cnt2] = dfn[i];
    } else
      ans1[++cnt] = dfn[i], deg[pre[dfn[i]]]--;
  }
  if (deg[dfn[n]] & 1)
    cout << "NO\n";
  else {
    ans1[++cnt] = dfn[n];
    cout << "YES\n";
    for (int i = 1; i <= cnt; i++) cout << ans1[i] << '\n';
    for (int i = cnt2; i; i--) cout << ans2[i] << '\n';
  }
  return 0;
}
