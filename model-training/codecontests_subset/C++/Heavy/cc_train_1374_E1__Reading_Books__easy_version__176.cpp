#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const long long N = 2e5 + 5;
long long n, m, k;
vector<pair<long long, long long>> type[2][2];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (long long i = 1; i <= n; ++i) {
    long long a, x, y;
    cin >> a >> x >> y;
    type[x][y].emplace_back(a, i);
  }
  for (long long i = 0; i <= 1; ++i)
    for (long long j = 0; j <= 1; ++j) sort(begin(type[i][j]), end(type[i][j]));
  long long ans = INT_MAX;
  set<long long> trace;
  for (long long _ = 0; _ < 2; ++_) {
    long long tot = 0;
    set<long long> s2;
    priority_queue<pair<long long, long long>> pq;
    priority_queue<pair<long long, long long>,
                   vector<pair<long long, long long>>,
                   greater<pair<long long, long long>>>
        pq1;
    for (long long i = 0; i <= 1; ++i) {
      for (long long j = 0; j <= 1; ++j) {
        if ((i == 0 && j) or (j == 0 && i)) {
          for (long long p = 0; p < min(k, (long long)type[i][j].size()); ++p) {
            tot += type[i][j][p].first;
            s2.insert(type[i][j][p].second);
          }
          for (long long p = k; p < (long long)(type[i][j].size()); ++p) {
            tot += type[i][j][p].first;
            s2.insert(type[i][j][p].second);
            pq.push(type[i][j][p]);
          }
        }
      }
    }
    for (auto &v : type[0][0]) {
      tot += v.first;
      s2.insert(v.second);
      pq.push(v);
    }
    for (long long i = 0; i <= type[1][1].size(); ++i) {
      if (i) {
        tot += type[1][1][i - 1].first;
        s2.insert(type[1][1][i - 1].second);
        for (long long __ = 0; __ <= 1; ++__) {
          for (long long j = 0; j <= 1; ++j)
            if ((__ == 0 && j) or (j == 0 && __)) {
              if ((long long)(type[__][j].size()) > k - i && k - i >= 0)
                pq.push(type[__][j][k - i]);
            }
        }
      }
      if (pq1.size()) {
        pq.push(pq1.top());
        tot += pq1.top().first;
        s2.insert(pq1.top().second);
        pq1.pop();
      }
      while (pq.size() && pq.size() > m - i - 2 * max(k - i, 0ll)) {
        tot -= pq.top().first;
        s2.erase(pq.top().second);
        pq1.push(pq.top());
        pq.pop();
      }
      if (pq.size() == m - i - 2 * max(k - i, 0ll) && type[1][1].size() >= i &&
          type[1][0].size() >= k - i && type[0][1].size() >= k - i && tot < ans)
        ans = tot;
      if (_ == 1 && tot == ans && trace.empty()) trace = s2;
    }
  }
  if (ans == INT_MAX) ans = -1;
  cout << ans << '\n';
  if (ans != -1)
    for (auto v : trace) cout << v << ' ';
}
