#include <bits/stdc++.h>
using namespace std;
using VI = vector<int>;
const int NN = 200011;
int a[NN], b[NN], arr[NN];
VI vec[NN], cyc[NN];
int nc;
int dp[NN], vst[NN];
int n, s;
void dfs(int u) {
  while (not vec[u].empty()) {
    int v = vec[u].back();
    vec[u].pop_back();
    dfs(a[v]);
    cyc[nc].push_back(v);
  }
}
int solve() {
  cin >> n >> s;
  for (int i = 1; i <= n; i++) scanf("%d", a + i), arr[i] = a[i], dp[i] = i;
  sort(arr + 1, arr + n + 1);
  int m = unique(arr + 1, arr + n + 1) - arr - 1;
  for (int i = 1; i <= n; i++) {
    b[i] = a[i] = lower_bound(arr + 1, arr + m + 1, a[i]) - arr;
  }
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; i++)
    if (a[i] ^ b[i]) {
      vec[b[i]].push_back(i);
    }
  for (int i = 1; i <= m; i++) {
    if (not vec[i].empty()) {
      dfs(i);
      int r = ((int)cyc[nc].size());
      for (int j = 0; j < r; j++) {
        dp[cyc[nc][(j + 1) % r]] = cyc[nc][j];
        s--;
      }
      nc++;
    }
    if (s < 0) return puts("-1");
  }
  s = min(s, nc);
  if (s >= 2) {
    cout << nc - s + 2 << endl;
    cout << s << endl;
    for (int i = 0; i < s; i++) printf("%d ", cyc[i][0]);
    puts("");
    int tmp = dp[cyc[s - 1][0]];
    for (int i = s; --i;) {
      dp[cyc[i][0]] = dp[cyc[i - 1][0]];
    }
    dp[cyc[0][0]] = tmp;
  } else
    cout << nc << endl;
  for (int i = 1; i <= n; i++) {
    if (dp[i] == i or vst[i]) continue;
    VI ans;
    for (int u = i; not vst[u];) {
      ans.push_back(u);
      vst[u] = 1;
      u = dp[u];
    }
    printf("%d\n", ans.size());
    for (int u : ans) printf("%d ", u);
    puts("");
  }
}
int main() { solve(); }
