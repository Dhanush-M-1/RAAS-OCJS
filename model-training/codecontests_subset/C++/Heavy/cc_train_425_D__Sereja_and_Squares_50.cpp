#include <bits/stdc++.h>
using namespace std;
vector<int> ys[100003];
vector<int> xs[100003];
int n;
unordered_map<long long, bool> exist;
pair<int, int> pts[100003];
long long hash_pair(pair<int, int> a) {
  return (long long)(a.first) * 100003 + a.second;
}
long long ans;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> pts[i].first >> pts[i].second;
    exist[hash_pair(pts[i])] = true;
    ys[pts[i].first].push_back(pts[i].second);
    xs[pts[i].second].push_back(pts[i].first);
  }
  for (int i = 0; i < 100003; i++) {
    sort(xs[i].begin(), xs[i].end());
    sort(ys[i].begin(), ys[i].end());
  }
  for (int i = 1; i <= n; i++) {
    auto it1 = lower_bound(ys[pts[i].first].begin(), ys[pts[i].first].end(),
                           pts[i].second);
    auto it2 = lower_bound(xs[pts[i].second].begin(), xs[pts[i].second].end(),
                           pts[i].first);
    if (it1 - ys[pts[i].first].begin() < it2 - xs[pts[i].second].begin())
      for (int j = 0;
           j < ys[pts[i].first].size() && ys[pts[i].first][j] < pts[i].second;
           j++) {
        int side = pts[i].second - ys[pts[i].first][j];
        if (exist[hash_pair(
                make_pair(pts[i].first - side, ys[pts[i].first][j]))] &&
            exist[hash_pair(make_pair(pts[i].first - side, pts[i].second))])
          ans++;
      }
    else
      for (int j = 0;
           j < xs[pts[i].second].size() && xs[pts[i].second][j] < pts[i].first;
           j++) {
        int side = pts[i].first - xs[pts[i].second][j];
        if (exist[hash_pair(make_pair(pts[i].first, pts[i].second - side))] &&
            exist[hash_pair(
                make_pair(xs[pts[i].second][j], pts[i].second - side))])
          ans++;
      }
  }
  cout << ans << '\n';
}
