#include <bits/stdc++.h>
using namespace std;
long long n, m, k, r[200005], redd[200005], t, xx[200005], yy[200005],
    ans[200005];
vector<pair<long long, long long> > v[200005];
void red(long long x, long long time) {
  if (time == 5) {
  }
  redd[x] = 1;
  t++;
  for (int i = 0; i < v[x].size(); i++) {
    if (v[x][i].first > time) break;
    r[v[x][i].second]--;
    if (r[v[x][i].second] < k && redd[v[x][i].second] == 0) {
      red(v[x][i].second, time);
    }
  }
}
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> xx[i] >> yy[i];
    v[xx[i]].push_back(make_pair(i, yy[i]));
    r[xx[i]]++;
    v[yy[i]].push_back(make_pair(i, xx[i]));
    r[yy[i]]++;
  }
  for (int i = 1; i <= n; i++) sort(v[i].begin(), v[i].end());
  ans[m] = n;
  for (int i = 1; i <= n; i++) {
    if (r[i] < k && redd[i] == 0) {
      t = 0;
      red(i, m);
      ans[m] -= t;
    }
  }
  for (int i = m; i >= 2; i--) {
    for (int j = 1; j <= n; j++) {
    }
    if (redd[yy[i]] == 0) r[xx[i]]--;
    t = 0;
    if (r[xx[i]] < k && redd[xx[i]] == 0) {
      red(xx[i], i);
      ans[i - 1] = ans[i] - t;
      continue;
    }
    if (redd[xx[i]] == 0) r[yy[i]]--;
    if (r[yy[i]] < k && redd[yy[i]] == 0) {
      if (xx[i] == 5) {
      }
      r[xx[i]]++;
      red(yy[i], i);
    }
    ans[i - 1] = ans[i] - t;
  }
  for (int i = 1; i <= m; i++) {
    cout << ans[i] << endl;
  }
  return 0;
}
