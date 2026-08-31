#include <bits/stdc++.h>
using namespace std;
vector<int> v[200005];
int poz[200005];
bool viz[200005];
int a, b, n;
void reset() {
  for (int i = 0; i <= n; i++) {
    v[i].clear();
    viz[i] = 0;
    poz[i] = 0;
  }
}
void dfs(int nod, int val) {
  if (val == 1 && nod == b) return;
  if (val == -1 && nod == a) return;
  viz[nod] = 1;
  poz[nod] += val;
  for (int i = 0; i < v[nod].size(); i++) {
    if (viz[v[nod][i]] == 0) dfs(v[nod][i], val);
  }
}
int main() {
  int t, m, x, y;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    reset();
    for (int i = 1; i <= m; i++) {
      cin >> x >> y;
      v[x].push_back(y);
      v[y].push_back(x);
    }
    dfs(a, 1);
    memset(viz, 0, sizeof(viz));
    dfs(b, -1);
    poz[a] = 2;
    poz[b] = 2;
    int cnt1 = 0, cnt2 = 0;
    for (int i = 1; i <= n; i++) {
      if (poz[i] == -1)
        cnt2++;
      else {
        if (poz[i] == 1) cnt1++;
      }
    }
    cout << 1ll * cnt1 * cnt2 << "\n";
  }
  return 0;
}
