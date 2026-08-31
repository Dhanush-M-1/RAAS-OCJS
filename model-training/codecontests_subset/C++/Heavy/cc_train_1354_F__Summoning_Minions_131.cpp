#include <bits/stdc++.h>
using namespace std;
int me[76][76];
int de[76][76];
int n, k;
int res[200];
const int INF = 1000000000;
vector<pair<int, pair<int, int> > > mv;
int dp(int ac, int ll) {
  if (me[ac][ll] >= 0) return me[ac][ll];
  if (ac == n) return me[ac][ll] = 0;
  if (ll < k) {
    me[ac][ll] = mv[ac].first * ll + dp(ac + 1, ll + 1) + mv[ac].second.first;
    de[ac][ll] = 0;
  }
  if (n - ac - 1 + ll >= k) {
    int can = mv[ac].first * (k - 1) + dp(ac + 1, ll);
    if (can > me[ac][ll]) {
      me[ac][ll] = can;
      de[ac][ll] = 1;
    }
  }
  return me[ac][ll];
}
int it;
void rec(int ac, int ll) {
  if (ac == n) return;
  if (de[ac][ll]) {
    res[it++] = mv[ac].second.second + 1;
    res[it++] = -mv[ac].second.second - 1;
    rec(ac + 1, ll);
  } else {
    res[ll] = mv[ac].second.second + 1;
    rec(ac + 1, ll + 1);
  }
}
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> k;
    mv.clear();
    mv.resize(n);
    for (int i = 0; i < n; i++) {
      mv[i].second.second = i;
      cin >> mv[i].second.first >> mv[i].first;
    }
    sort(mv.begin(), mv.end());
    it = k;
    memset(me, -1, sizeof me);
    dp(0, 0);
    rec(0, 0);
    cout << it << endl;
    for (int i = 0; i < k - 1; i++) cout << res[i] << ' ';
    for (int i = k; i < it; i++) cout << res[i] << ' ';
    cout << res[k - 1] << endl;
  }
  return 0;
}
