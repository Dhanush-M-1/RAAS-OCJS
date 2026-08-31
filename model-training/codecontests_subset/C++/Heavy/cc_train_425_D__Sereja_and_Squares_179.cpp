#include <bits/stdc++.h>
using namespace std;
int n;
vector<int> x[100002];
vector<int> y[100002];
vector<pair<int, int> > vv;
unordered_set<int> mp[100002];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    x[a].push_back(b);
    y[b].push_back(a);
    vv.push_back(make_pair(a, b));
    mp[a].insert(b);
  }
  int ans = 0;
  for (int i = 0; i < vv.size(); i++) {
    int xx = vv[i].first;
    int yy = vv[i].second;
    if (x[xx].size() > y[yy].size()) {
      for (int j = 0; j < y[yy].size(); j++) {
        int len = y[yy][j] - xx;
        if (len <= 0) continue;
        if (yy + len >= 0 && yy + len < 100002 && mp[xx].count(yy + len)) {
          if (mp[xx + len].count(yy + len)) {
            ans++;
          }
        }
      }
    } else {
      for (int j = 0; j < x[xx].size(); j++) {
        int len = x[xx][j] - yy;
        if (len <= 0) continue;
        if (xx + len >= 0 && xx + len < 100002 && mp[xx + len].count(yy)) {
          if (mp[xx + len].count(yy + len)) {
            ans++;
          }
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
