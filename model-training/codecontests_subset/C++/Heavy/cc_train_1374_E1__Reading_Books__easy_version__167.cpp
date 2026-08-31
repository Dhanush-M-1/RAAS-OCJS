#include <bits/stdc++.h>
using namespace std;
int main(int argc, char **argv) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> cnt(5, 0), mark(4, 0), as;
  vector<pair<long long, long long> > v[4];
  long long ret = 1e18, ans = 0;
  for (int i = 0; i < n; i++) {
    int x, y, z;
    cin >> x >> y >> z;
    v[2 * y + z].push_back({x, i});
  }
  if (min((int)(v[1].size()), (int)(v[2].size())) + (int)(v[3].size()) < k ||
      ((int)(v[3].size()) < k &&
       (int)(v[3].size()) + 2 * (k - (int)(v[3].size())) > m)) {
    cout << -1 << endl;
    return 0;
  }
  int hi = min(min((int)(v[1].size()), (int)(v[2].size())), k),
      lo = max(0, k - (int)(v[3].size()));
  mark[0] = 0, mark[1] = mark[2] = hi, mark[3] = k - hi;
  for (int i = 0; i < 4; i++)
    v[i].push_back({2 * 1000000007, n + i}), sort(v[i].begin(), v[i].end());
  for (int i = 0; i < 4; i++)
    for (int j = 0; j < mark[i]; j++) ans += v[i][j].first;
  while (hi + k > m) {
    ans -= v[1][hi - 1].first + v[2][hi - 1].first - v[3][k - hi].first, hi--;
    mark[1] = mark[2] = hi, mark[3] = k - hi;
  }
  for (int i = 0; i < 4; i++) cnt[i] = mark[i];
  for (int i = 0; i < m - (hi + k); i++) {
    int qw = 2 * 1000000007, in;
    for (int j = 0; j < 4; j++)
      if (qw > v[j][cnt[j]].first) qw = v[j][cnt[j]].first, in = j;
    ans += qw, cnt[in]++;
  }
  ret = min(ret, ans), as = cnt;
  for (int i = hi - 1; i >= lo; i--) {
    int temp = 0;
    if (mark[1]-- == cnt[1]) cnt[1]--, temp--, ans -= v[1][cnt[1]].first;
    if (mark[2]-- == cnt[2]) cnt[2]--, temp--, ans -= v[2][cnt[2]].first;
    while (temp < 0) {
      int qw = 2 * 1000000007, in;
      for (int j = 0; j < 4; j++)
        if (qw > v[j][cnt[j]].first) qw = v[j][cnt[j]].first, in = j;
      ans += qw, cnt[in]++, temp++;
    }
    if (mark[3]++ == cnt[3]) {
      int qw = 0, in = 4;
      for (int j = 0; j < 4; j++)
        if (cnt[j] > mark[j] && qw < v[j][cnt[j] - 1].first)
          qw = v[j][cnt[j] - 1].first, in = j;
      ans -= qw, cnt[in]--;
      ans += v[3][cnt[3]].first, cnt[3]++;
    }
    if (ret > ans) as = cnt, ret = ans;
  }
  cout << ret << endl;
  for (int i = 0; i < 4; i++)
    for (int j = 0; j < as[i]; j++) cout << v[i][j].second + 1 << " ";
  cout << endl;
}
