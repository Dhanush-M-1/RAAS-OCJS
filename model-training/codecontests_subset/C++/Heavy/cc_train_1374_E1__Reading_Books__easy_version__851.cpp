#include <bits/stdc++.h>
using namespace std;
deque<long long> v11, v10, v01;
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, k;
  cin >> n >> k;
  for (long long i = 0; i < n; i++) {
    long long a, b, c;
    cin >> a >> b >> c;
    if (b == 1 && c == 1)
      v11.emplace_back(a);
    else if (b == 1 && c == 0)
      v10.emplace_back(a);
    else if (b == 0 && c == 1)
      v01.emplace_back(a);
  }
  sort(v11.begin(), v11.end());
  sort(v10.begin(), v10.end());
  sort(v01.begin(), v01.end());
  priority_queue<long long> pq;
  long long ans = 0;
  long long nk = k;
  for (long long i = 0; i < min(k, (long long)min(v10.size(), v01.size()));
       i++) {
    pq.emplace(v10[i] + v01[i]);
    ans += v10[i] + v01[i];
    nk--;
  }
  while (v11.size() && nk) {
    nk--;
    ans += v11[0];
    v11.pop_front();
  }
  if (nk) {
    cout << -1 << endl;
    return 0;
  }
  while (pq.size() && v11.size()) {
    if (v11[0] < pq.top()) {
      ans -= pq.top();
      ans += v11[0];
      v11.pop_front();
      pq.pop();
    } else
      break;
  }
  cout << ans << endl;
  return 0;
}
