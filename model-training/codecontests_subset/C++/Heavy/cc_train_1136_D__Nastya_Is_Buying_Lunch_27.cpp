#include <bits/stdc++.h>
using namespace std;
int pos[1000001];
set<int, greater<int> > after[1000001], before[1000001];
int main() {
  ios::sync_with_stdio(false);
  ;
  cin.tie(0);
  ;
  int i, j, n, m, x, y, cur, ans = 0;
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> x;
    pos[x] = i;
  }
  for (i = 1; i <= m; i++) {
    cin >> x >> y;
    if (pos[x] < pos[y]) {
      after[pos[x]].insert(pos[y]);
      before[pos[y]].insert(pos[x]);
    }
  }
  cur = n;
  for (auto x : before[n]) {
    if (after[x].size() != cur - x) continue;
    cur--;
    ans++;
    for (auto y : before[x]) after[y].erase(x);
  }
  cout << ans;
  return 0;
}
