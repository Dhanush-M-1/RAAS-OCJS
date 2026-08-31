#include <bits/stdc++.h>
using namespace std;
vector<vector<pair<long long, long long>>> mt(4 * 200005);
vector<pair<long long, long long>> a;
void buildTree(long long idx, long long second, long long se) {
  if (second == se) {
    mt[idx].push_back({a[second].second, a[second].first});
    return;
  }
  long long mid = (second + se) / 2;
  buildTree(2 * idx + 1, second, mid);
  buildTree(2 * idx + 2, mid + 1, se);
  merge(mt[2 * idx + 1].begin(), mt[2 * idx + 1].end(), mt[2 * idx + 2].begin(),
        mt[2 * idx + 2].end(), back_inserter(mt[idx]));
}
pair<long long, long long> query(long long node, long long qs, long long qe,
                                 long long second, long long se,
                                 long long diff) {
  if (qs > se || qe < second) return {0, 0};
  if (qs <= second && qe >= se) {
    long long l = 0, r = mt[node].size() - 1, ind = 1e9;
    while (l <= r) {
      long long mid = (l + r) / 2;
      if (mt[node][mid].first >= diff) {
        ind = min(ind, mid);
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    pair<long long, long long> ans = {0, 0};
    if (ind != 1e9) {
      ans.second = mt[node].size() - ind;
      ans.first = mt[node][mt[node].size() - 1].second;
      if (ind != 0) ans.first -= mt[node][ind - 1].second;
    }
    return ans;
  }
  long long mid = (second + se) / 2;
  pair<long long, long long> p1 =
      query(2 * node + 1, qs, qe, second, mid, diff);
  pair<long long, long long> p2 =
      query(2 * node + 2, qs, qe, mid + 1, se, diff);
  p1.first += p2.first;
  p1.second += p2.second;
  return p1;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n;
  cin >> n;
  a.resize(n);
  for (int i = 0; i < n; i++) cin >> a[i].first;
  for (int i = 0; i < n; i++) cin >> a[i].second;
  sort(a.begin(), a.end());
  buildTree(0, 0, n - 1);
  for (int i = 0; i < (4 * n) + 5; i++) {
    for (int j = 1; j < mt[i].size(); j++)
      mt[i][j].second += mt[i][j - 1].second;
  }
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    pair<long long, long long> q =
        query(0, i + 1, n - 1, 0, n - 1, a[i].second);
    ans += (q.first - (q.second * a[i].first));
  }
  cout << ans << "\n";
}
