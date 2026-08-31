#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5e5 + 7;
const int MAXV = 207;
const int MAXE = 207;
const int INF = 0x3f3f3f3f;
int n, m;
int a[MAXN];
int idx[MAXN], cnt[MAXN];
int lst = -1;
bool vis[MAXN];
vector<int> v, g[MAXN];
bool cmp(int x, int y) { return idx[x] > idx[y]; }
int main() {
  while (cin >> n >> m) {
    for (int i = 0; i <= n; i++) g[i].clear();
    v.clear();
    memset(cnt, 0, sizeof(cnt));
    ;
    memset(vis, 0, sizeof(vis));
    ;
    for (int i = 1; i <= n; i++) {
      cin >> a[i];
      idx[a[i]] = i;
    }
    lst = a[n];
    for (int i = 0; i < m; i++) {
      int frt, bak;
      cin >> frt >> bak;
      if (bak == lst) {
        v.push_back(frt);
        vis[frt] = true;
      }
      g[frt].push_back(bak);
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < g[i].size(); j++) {
        int now = g[i][j];
        if (idx[i] < idx[now]) cnt[i]++;
      }
    }
    sort(v.begin(), v.end(), cmp);
    int ans = 0, pass = 0;
    for (int i = 0; i < v.size(); i++) {
      int now = v[i];
      if (cnt[now] >= (n - idx[now] - pass)) {
        ans++;
        pass++;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
