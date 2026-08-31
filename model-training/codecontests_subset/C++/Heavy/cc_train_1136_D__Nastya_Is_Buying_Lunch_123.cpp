#include <bits/stdc++.h>
using namespace std;
int ai[300005];
int bi[300005];
int id[300005];
vector<int> vc[300005];
bool mrk[300005];
map<pair<int, int>, int> ma;
int taken[300005];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &ai[i]);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    if (v == ai[n]) {
      mrk[u] = 1;
    }
    ma[{u, v}] = 1;
  }
  int ans = 0;
  n--;
  while (mrk[ai[n]] && n > 0) n--, ans++;
  for (int i = n; i >= 1; i--) {
    if (mrk[ai[i]]) {
      int ok = 1;
      for (int j = i + 1; j <= n; j++)
        if (!taken[j] && !ma[{ai[i], ai[j]}]) ok = 0, j = n + 1;
      if (ok) {
        taken[i] = 1;
        ans++;
      }
    }
  }
  cout << ans;
}
