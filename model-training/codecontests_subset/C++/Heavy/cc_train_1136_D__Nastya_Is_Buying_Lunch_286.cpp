#include <bits/stdc++.h>
using namespace std;
int n, m, ans, sz;
int p[300010], va[300010];
bool el[300010], test;
pair<int, int> a[500010];
bool pos(int t1, int t2) {
  int st = 1, dr = m, mij;
  while (st < dr) {
    mij = (st + dr) / 2;
    if (make_pair(t1, t2) <= a[mij])
      dr = mij;
    else
      st = mij + 1;
  }
  return (a[st] == make_pair(t1, t2));
}
int main() {
  cin.tie(0);
  cout.tie(0);
  std::ios_base::sync_with_stdio(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 1; i <= m; i++) cin >> a[i].first >> a[i].second;
  sort(a + 1, a + m + 1);
  for (int i = n - 1; i >= 1; i--)
    if (pos(p[i], p[n])) {
      test = 1;
      for (int j = 1; j <= sz; j++)
        if (!pos(p[i], va[j])) {
          test = 0;
          break;
        }
      if (test)
        ans++;
      else
        va[++sz] = p[i];
    } else
      va[++sz] = p[i];
  cout << ans;
  return 0;
}
