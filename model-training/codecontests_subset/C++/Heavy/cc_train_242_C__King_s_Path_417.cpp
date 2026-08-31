#include <bits/stdc++.h>
using namespace std;
template <class T>
using min_heap = priority_queue<T, std::vector<T>, std::greater<T>>;
struct hash_pair {
  template <class T1, class T2>
  size_t operator()(const pair<T1, T2>& p) const {
    auto hash1 = hash<T1>{}(p.first);
    auto hash2 = hash<T2>{}(p.second);
    return hash1 ^ hash2;
  }
};
const int fx[] = {+0, +0, +1, -1, -1, +1, -1, +1};
const int fy[] = {-1, +1, +0, +0, +1, +1, -1, -1};
unordered_map<pair<long long, long long>, long long, hash_pair> mp;
long long srcx, srcy, desx, desy;
unordered_map<pair<long long, long long>, long long, hash_pair> cost;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long i, j, k, n, m, T;
  cin >> srcx >> srcy >> desx >> desy;
  cin >> n;
  for (i = 0; i < n; i++) {
    long long r, x, y;
    cin >> r >> x >> y;
    for (j = x; j <= y; j++) {
      mp[{r, j}] = 1;
    }
  }
  queue<pair<long long, long long>> q;
  q.push({srcx, srcy});
  cost[{srcx, srcy}] = 0;
  while (!q.empty()) {
    auto cn = q.front();
    q.pop();
    for (k = 0; k < 8; k++) {
      long long x = cn.first + fx[k];
      long long y = cn.second + fy[k];
      if (mp.count({x, y}) && !cost.count({x, y})) {
        cost[{x, y}] = cost[cn] + 1;
        q.push({x, y});
      }
    }
  }
  if (!cost.count({desx, desy}))
    cout << -1 << "\n";
  else
    cout << cost[{desx, desy}] << "\n";
  return 0;
}
