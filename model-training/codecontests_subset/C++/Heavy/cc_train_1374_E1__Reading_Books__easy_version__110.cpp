#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long inf = 922337203685477;
const long long mininf = -922337203685477;
const long long nax = 2e5 + 5;
long long n, k, t, x, y;
priority_queue<long long, vector<long long>, greater<long long>> pq[5];
long long val(long long x) {
  if (!pq[x].empty()) {
    return pq[x].top();
  } else {
    return inf;
  }
}
void ers(long long x) {
  if (!pq[x].empty()) {
    pq[x].pop();
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) {
    cin >> t >> x >> y;
    if (x && y) {
      pq[3].push(t);
    } else if (x) {
      pq[1].push(t);
    } else if (y) {
      pq[2].push(t);
    }
  }
  if (pq[1].size() + pq[3].size() >= k && pq[2].size() + pq[3].size() >= k) {
    long long ans = 0;
    long long x = 0, y = 0;
    while (x < k || y < k) {
      if (val(3) <= val(1) + val(2)) {
        x++;
        y++;
        ans += val(3);
        ers(3);
      } else {
        ans += val(1);
        ans += val(2);
        x++;
        y++;
        ers(1), ers(2);
      }
    }
    cout << ans << '\n';
  } else {
    cout << -1 << '\n';
  }
}
